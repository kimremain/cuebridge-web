package com.jcuesoft.cuebridge.brc.ctrl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.jcuesoft.cuebridge.bex.service.BexMasterService;
import com.jcuesoft.cuebridge.bex.vo.BexMasterRequestVO;
import com.jcuesoft.cuebridge.bex.vo.BexMasterResponseVO;
import com.jcuesoft.cuebridge.brc.service.BrcExcelReportService;
import com.jcuesoft.cuebridge.brc.vo.BrcExcelReportRequestVO;
import com.jcuesoft.cuebridge.brc.vo.BrcExcelReportResponseVO;
import com.jcuesoft.cuebridge.common.service.CommonCacheService;
import com.jcuesoft.cuebridge.web.ctrl.BaseController;

@Controller
public class BrcExcelReportController extends BaseController {
    /**
     * brcLoanService
     */
    @Autowired
    private BrcExcelReportService brcExcelReportService;
    
    /**
     * brcLoanService
     */
    @Autowired
    private BexMasterService bexMasterService;
    
    /**
     * commonSearchService
     */
    @Autowired
    private CommonCacheService commonCacheService;

    /**
     * BRC04 - 접수정보 엑셀 추출
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/brc/excel/select")
    public ModelAndView mainView(HttpServletRequest request, HttpServletResponse response,BrcExcelReportRequestVO brcExcelReportRequestVO) throws Exception {
        
        //log
        logger.debug("Call BrcExcelReportController mainView...");        
        // 로그인 & 권한체크
        /*super.LoginCheck(request,response);*/
        ModelAndView modelAndView = new ModelAndView();
        
        modelAndView.addObject("pdtList", commonCacheService.getStPdtList());       //상품        
        modelAndView.addObject("code703", commonCacheService.getStCodeList("703")); //거래처
        modelAndView.addObject("code704", commonCacheService.getStCodeList("704")); //접수경로                
        modelAndView.addObject("code705", commonCacheService.getStCodeList("705")); //광고포털구분코드
        modelAndView.addObject("code710", commonCacheService.getStCodeList("710")); //접수상태 
        modelAndView.addObject("screenList", commonCacheService.getStUserListScreen()); //심사자

        
        Date today = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        brcExcelReportRequestVO.setDmReceiveStart(simpleDateFormat.format(today));
        brcExcelReportRequestVO.setDmReceiveEnd(simpleDateFormat.format(today));
        
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyyMMddHHmmss");      
        modelAndView.addObject("excelFileName", "접수현황_"+simpleDateFormat2.format(today)); 
        modelAndView.addObject("bexExcelFileName", "대출심사현황_"+simpleDateFormat2.format(today)); 
        modelAndView.addObject("requestVO", brcExcelReportRequestVO); 
        
        //return
        modelAndView.setViewName("/brc/brcExcelV.tiles");
        return modelAndView;
    }

    /**
     * BRC04 - makeExcel
     *
     * @param request
     * @param response
     * @param brcExcelReportRequestVO
     * @param modelMap
     * @throws Exception
     */
    @RequestMapping("/brc/excel/excel")
    public void makeExcel(HttpServletRequest request, HttpServletResponse response, BrcExcelReportRequestVO brcExcelReportRequestVO, Map<String, Object> modelMap) throws Exception {
        //log
        logger.debug("Call BrcExcelReportController makeExcel..."+brcExcelReportRequestVO);

        String csvFileName = new String((brcExcelReportRequestVO.getLogDsRemk()+".csv").getBytes("KSC5601"),"8859_1");
        response.reset();
        response.resetBuffer();
        response.setContentType("application/octet-stream; charset=euc-kr"); 
        response.setDateHeader("Expires", 0);
        response.setHeader("Content-Disposition", "attachment;filename="+csvFileName+";");
        response.setHeader("Content-Transfer-Encoding", "binary" );        
        
        String[] header = { "ADMIN번호", 
                                    "접수번호",
                                    "해쉬", 
                                    "성별", 
                                    "접수경로", 
                                    "대출과목", 
                                    "광고구분", 
                                    "광고키워드", 
                                    "접속구분",  
                                    "신청금액", 
                                    "상태", 
                                    "거절사유",
                                    "취소사유",
                                    "담당자", 
                                    "상담자",
                                    "SAFEKEY유무",
                                    "SAFEKEY",
                                    "실행건수",
                                    "접수일시",
                                    "상담완료일시",
                                    "최종접촉일시",
                                    "처리일시",
                                    "CB조회일",
                                    "CB건수",                                    
                                    "CFS조회일",
                                    "(신)CFS조회일",
                                    "1차등급",
                                    "2차등급",
                                    "ASS등급",
                                    "판정결과",                                    
                                    "전략한도",
                                    "스코어ID",
                                    "보증인여부",
                                    "재접수여부"}; 
        String[] data = { "NoCooperate", 
                                    "NoReq",
                                    "noCustomHash", 
                                    "NoCustom", 
                                    "CdPath", 
                                    "NmPdt", 
                                    "CdEportal", 
                                    "NmEkeyword", 
                                    "CdEpath", 
                                    "AmCustom", 
                                    "CdStatus", 
                                    "nmReject",
                                    "nmCancel",
                                    "IdReceive", 
                                    "IdScreen", 
                                    "YnNiceSafekey", 
                                    "dsNiceSafekey",                                     
                                    "BexCount", 
                                    "DmReceive",
                                    "DmScreen",
                                    "DmContact",
                                    "DmProcess",
                                    "dmCbSsn",
                                    "dsCntCb",                                    
                                    "dmCfsSsn",
                                    "dmCfs2Ssn",
                                    "ds1stRank",
                                    "ds2ndRank",
                                    "dsAssRank",
                                    "cdTactic",                                    
                                    "cdTacticLimit",
                                    "dsAssId",
                                    "ynSurety",
                                    "ynReapp"};                                     

        List<BrcExcelReportResponseVO> brcExcelReportList = brcExcelReportService.getBrcExcelReportList(brcExcelReportRequestVO);

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        csvWriter.writeHeader(header);
        
        for(BrcExcelReportResponseVO dummy : brcExcelReportList){

            csvWriter.write(dummy, data);
        }

        csvWriter.close();  
    }
    
    /**
     * BRC04 - makeExcel
     *
     * @param request
     * @param response
     * @param brcExcelReportRequestVO
     * @param modelMap
     * @throws Exception
     */
    @RequestMapping("/bex/excel/excel")
    public void bexMakeExcel(HttpServletRequest request, HttpServletResponse response,BexMasterRequestVO bexMasterRequestVO, Map<String, Object> modelMap) throws Exception {
        //log
        logger.debug("Call BrcExcelReportController makeExcel..."+bexMasterRequestVO);

        String csvFileName = new String((bexMasterRequestVO.getLogDsRemk()+".csv").getBytes("KSC5601"),"8859_1");
        response.reset();
        response.resetBuffer();
        response.setContentType("application/octet-stream; charset=euc-kr"); 
        response.setDateHeader("Expires", 0);
        response.setHeader("Content-Disposition", "attachment;filename="+csvFileName+";");
        response.setHeader("Content-Transfer-Encoding", "binary" );        
        
        String[] header = { "접수번호",
                "성명", 
                "생년월일",                 
                "해쉬", 
                "실행번호", 
                "접수경로", 
                "대출상품", 
                "상담자", 
                "접수일시", 
                "심사요청일시",  
                "신청금액(만원)", 
                "심사업체", 
                "접수위치", 
                "심사상품", 
                "심사상태",
                "승인금액(만원)",
                "기표변경일시",
                }; 
        String[] data = { "noReq",
                "nmCustom",
                "noCustom",
                "noCustomHash",                
                "noEx", 
                "cdPath", 
                "nmPdt", 
                "idScreen", 
                "dmReceive", 
                "dmReg", 
                "amApp", 
                "cdCooperate", 
                "nmScreenPath", 
                "nmBexPdt", 
                "nmScreen", 
                "amCooperate", 
                "dmUpt"};                              
        
        List<BexMasterResponseVO> brcExcelReportList = bexMasterService.getExListAll(bexMasterRequestVO); 
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        csvWriter.writeHeader(header);
        

        
        for(BexMasterResponseVO dummy : brcExcelReportList){
            if (!request.isUserInRole("72199")) {
                dummy.setNmCustom("***");
                dummy.setNoCustom("******");
            }            
            csvWriter.write(dummy, data);
        }

        csvWriter.close();  
    }
}