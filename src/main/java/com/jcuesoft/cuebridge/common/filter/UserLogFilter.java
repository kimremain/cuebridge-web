package com.jcuesoft.cuebridge.common.filter;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.StringTokenizer;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import com.jcuesoft.cuebridge.common.module.CommonSessionUtil;
import com.jcuesoft.cuebridge.common.module.CommonUtil;
import com.jcuesoft.cuebridge.st.service.StUserLogService;
import com.jcuesoft.cuebridge.st.vo.StUserLogRequestVO;

public class UserLogFilter implements Filter {
    /**
     * logger
     */
    final static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    /**
     * stUserLogService
     */
    @Resource
    private StUserLogService stUserLogService;

    /**
     * User Log를 처리하지 않을 URL
     */
    private List<String> byPassURIs;

    /**
     * User Log를 처리하지 않을 URL 세팅 <BR/>
     * application-context.xml의 userLogFilter빈에서 세팅
     *
     * @param byPassURIs
     */
    public void setByPassURIs(List<String> byPassURIs) {
        this.byPassURIs = byPassURIs;
    }

    /**
     * Filter Method Override
     */
    @Override
    public void init(FilterConfig arg0) throws ServletException {}

    /**
     * User Log 처리
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.debug("Call UserLogFilter doFilter...");

        //httpServletRequest
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;

        //ByPass
        boolean isByPass = false;
        for (String byPassURI : byPassURIs) {
            logger.debug("@@@@ byPassURI:"+byPassURI);
            logger.debug("@@@@ httpServletRequest.getRequestURI():"+httpServletRequest.getRequestURI());
            
            if (httpServletRequest.getRequestURI().startsWith(byPassURI)) {
                isByPass = true;
            }
        }
        logger.debug("@@@@ isByPass:"+isByPass);
        //insert user log
        if (!isByPass) {
            try {
                //CommonUtil commonUtil = new CommonUtil();
                StUserLogRequestVO filterUserLogRequestVO = new StUserLogRequestVO();

                //사용자ID
                filterUserLogRequestVO.setIdUser(CommonSessionUtil.getIdUser());

                //접수일련번호
                String noReq = httpServletRequest.getParameter("noReq");
                if (noReq==null || noReq.isEmpty()) {noReq = httpServletRequest.getParameter("searchNoReq");}
                filterUserLogRequestVO.setNoReq(noReq);

                //프로그램URL
                filterUserLogRequestVO.setDsUrl(getDsUrl(httpServletRequest.getRequestURI()));

                //동작구분코드
                filterUserLogRequestVO.setCdUserAction(getCdUserAction(httpServletRequest.getRequestURI()));
               
                //비고
                filterUserLogRequestVO.setDsRemk(httpServletRequest.getParameter("logDsRemk"));

                //insert
                stUserLogService.insertStUserLog(filterUserLogRequestVO);
                
                if(filterUserLogRequestVO.getIdUser() == null || filterUserLogRequestVO.getIdUser().trim().length() == 0){
                    logger.warn("unknown user!");
                    logger.warn(filterUserLogRequestVO.toString());;
                }

                // TODO : 프로그램에서 권한을 체크하기 위한 참조객체를 추가하여 뒤로 넘긴다.
                httpServletRequest.setAttribute("filterUserLogRequestVO", filterUserLogRequestVO);
                
                
                if(logger.isDebugEnabled()){
                    logger.debug("setAttribute : filterUserLogRequestVO:"+filterUserLogRequestVO);
                }
                
            } catch (Exception e) {
                logger.error("UserLogFilter Insert User Log Error : " + e.toString());
                e.printStackTrace();
            }
        }

        putMDC(getDsUrl(httpServletRequest.getRequestURI()));
        filterChain.doFilter(httpServletRequest, servletResponse);
        removeMDC();
    }

    private void removeMDC() {
        logger.debug("Call UserLogFilter removeMDC...");
        MDC.remove("nmUser");
        MDC.remove("dsUserAction");
        MDC.remove("nmLogFile");
        MDC.remove("ynAdmin");
        MDC.clear();
    }

    private void putMDC(String requestUrl) {
        logger.debug("Call UserLogFilter putMDC...");
        try {
            String ynAdmin = CommonSessionUtil.getYnAdmin();
            String nmUser = CommonSessionUtil.getIdUser()+"-"+CommonSessionUtil.getNmUser();
            String dsUserAction = "["+nmUser+"]:["+requestUrl+"]";
            String nmLogFile;
            if(ynAdmin != null && ynAdmin.equals("Y")){
                nmLogFile = CommonSessionUtil.getCdCompany()+nmUser;
            }else{
                nmLogFile = CommonSessionUtil.getCdCompany()+"CUEBRIDGE-WEB";
            }
            nmLogFile = nmLogFile.trim();
            logger.debug("nmLogFile: {}", nmLogFile);
            logger.debug("MDC.put [{} {} {} {}]", nmUser,dsUserAction,nmLogFile,ynAdmin);
            MDC.put("nmUser", nmUser);
            MDC.put("dsUserAction", dsUserAction);
            MDC.put("nmLogFile", nmLogFile);
            MDC.put("ynAdmin", ynAdmin);
 
        } catch (Exception e) {
            logger.error("putMDC Exception", e);
        }
        
        

    }

    /**
     * 프로그램ID 를 조회하기위한 URL
     *
     * @param requestURI
     * @return
     */
    public String getDsUrl(String requestURI) {
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(requestURI, "/");

        int i=0;
        while (st.hasMoreTokens()) {
            sb.append("/").append(st.nextToken());
            if (++i==2) {break;}
        }

        return sb.toString();
    }

    /**
     * 동작구분코드
     *
     * @param requestURI
     * @return
     */
    public String getCdUserAction(String requestURI) {
        String nmUserAction = "";
        String cdUserAction = "";
        StringTokenizer st = new StringTokenizer(requestURI, "/");

        //nmUserAction
        if (st.countTokens() < 3) { //3depth 이하 URL은 select 처리
            nmUserAction = "select";
        } else {
            int i=0;
            String tmpStr = "";
            while (st.hasMoreTokens()) {
                tmpStr = st.nextToken();
                if (++i == 3) {
                    nmUserAction = tmpStr.toLowerCase().trim();
                    break;
                }
            }
        }

        //cdUserAction
        if (nmUserAction.contains("select")) {
            cdUserAction = "70001";
        } else if (nmUserAction.contains("update")) {
            cdUserAction = "70002";
        } else if (nmUserAction.contains("delete")) {
            cdUserAction = "70003";
        } else if (nmUserAction.contains("excel")) {
            cdUserAction = "70004";
        } else if (nmUserAction.contains("print")) {
            cdUserAction = "70005";
        } else if (nmUserAction.contains("upload")) {
            cdUserAction = "70008";
        } else if (nmUserAction.contains("insert")) {
            cdUserAction = "71000";
        } else if (nmUserAction.contains("download")) {
            cdUserAction = "70009";
        } else if (nmUserAction.contains("sendmail")) {
            cdUserAction = "70010";
        } else if (nmUserAction.contains("sendsms")) {
            cdUserAction = "70011";
        } else if (nmUserAction.contains("updatebatch")) {
            cdUserAction = "70012";
        } else if (nmUserAction.contains("deletebatch")) {
            cdUserAction = "70013";
        }

        return cdUserAction;
    }

    /**
     * Filter Method Override
     */
    @Override
    public void destroy() {}

}
