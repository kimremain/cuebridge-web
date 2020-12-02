package com.jcuesoft.cuebridge.st.ctrl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.jcuesoft.cuebridge.common.pagination.Order;
import com.jcuesoft.cuebridge.common.pagination.PageBounds;
import com.jcuesoft.cuebridge.common.pagination.PageList;
import com.jcuesoft.cuebridge.common.service.CommonCacheService;
import com.jcuesoft.cuebridge.st.service.StUserLogService;
import com.jcuesoft.cuebridge.st.vo.StUserLogRequestVO;
import com.jcuesoft.cuebridge.st.vo.StUserLogResponseVO;
import com.jcuesoft.cuebridge.web.ctrl.BaseController;

@Controller
public class StUserLogController extends BaseController {

    @Autowired
    private StUserLogService stUserLogService;
    
    /**
     * commonSearchService
     */
    @Autowired
    private CommonCacheService commonCacheService;
    
    /**
     * 사용자 로그 ST03
     *
     * @param request
     * @param response
     */
    @RequestMapping("/st/userlog/select")
    public ModelAndView mainView(
            HttpServletRequest request,
            HttpServletResponse response,
            @ModelAttribute("stUserLogRequestVO") StUserLogRequestVO stUserLogRequestVO,
            @RequestParam(required = false, defaultValue = "1") int page, 
            @RequestParam(required = false, defaultValue = "30") int limit,
            @RequestParam(required = false, defaultValue = "no") String sort,
            @RequestParam(required = false, defaultValue = "desc") String dir
        ) throws Exception {

        // 로그인 & 권한체크
        /*super.LoginCheck(request, response);*/
        
        ModelAndView modelAndView = new ModelAndView();
        
        // 코드조회 
        modelAndView.addObject("code700", commonCacheService.getStCodeList("700")); //동작구분코드
        modelAndView.addObject("codePgm", commonCacheService.getStPgmList()); //프로그램리스트
        modelAndView.addObject("codeUser", commonCacheService.getStUserList()); //사용자리스트
        
        Date today = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");      
        modelAndView.addObject("excelFileName", "사용자로그_"+simpleDateFormat.format(today)); 
        
        PageBounds pageBounds = new PageBounds(page, limit);
        pageBounds.getOrders().add(Order.create(sort, dir));

        logger.debug("getParameter : stUserLogRequestVO:" + stUserLogRequestVO);

        PageList<StUserLogResponseVO> pageList = stUserLogService.getStUserLogList(stUserLogRequestVO, pageBounds);

        modelAndView.addObject("requestVO", stUserLogRequestVO);
        modelAndView.addObject("pageList", pageList);
        modelAndView.setViewName("/st/stUserLogV.tiles");
        return modelAndView;

    }
    
    /**
     * 사용자 로그 엑셀출력
     *
     * @param request
     * @param response
     */
    @RequestMapping("/st/userlog/excel")
    public void mainView(HttpServletRequest request,HttpServletResponse response,StUserLogRequestVO stUserLogRequestVO) throws Exception {

        // 로그인 & 권한체크
        /*super.LoginCheck(request, response);*/
        
        String csvFileName = new String((stUserLogRequestVO.getLogDsRemk()+".csv").getBytes("KSC5601"),"8859_1");
        response.reset();
        response.resetBuffer();
        response.setContentType("application/octet-stream; charset=euc-kr"); 
        response.setDateHeader("Expires", 0);
        response.setHeader("Content-Disposition", "attachment;filename="+csvFileName+";");
        response.setHeader("Content-Transfer-Encoding", "binary" );        
        
        String[] header = { "일련번호", 
                                    "사용자명", 
                                    "접수번호", 
                                    "프로그램명", 
                                    "동작구분", 
                                    "비고", 
                                    "등록일시"}; 

        String[] data = { "noSeq", 
                                    "nmUser", 
                                    "noReq", 
                                    "dsPgm", 
                                    "cdUserAction", 
                                    "dsRemk", 
                                    "dmReg" };                                     

        List<StUserLogResponseVO> getStUserLogList = stUserLogService.getStUserLogList(stUserLogRequestVO);

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        csvWriter.writeHeader(header);

        for(StUserLogResponseVO dummy : getStUserLogList){

            csvWriter.write(dummy, data);
        }

        csvWriter.close();  


    }

   
}