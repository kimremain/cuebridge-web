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
import com.jcuesoft.cuebridge.st.service.StSmssendService;
import com.jcuesoft.cuebridge.st.vo.StSmssendRequestVO;
import com.jcuesoft.cuebridge.st.vo.StSmssendResponseVO;
import com.jcuesoft.cuebridge.web.ctrl.BaseController;

@Controller
public class StSmssendController extends BaseController {

    @Autowired
    private StSmssendService stSmssendService;
    
    @Autowired
    private CommonCacheService commonCacheService;

    @RequestMapping("/st/smssend/select")
    public ModelAndView mainView(
            HttpServletRequest request,
            HttpServletResponse response,
            @ModelAttribute("stSmssendRequestVO") StSmssendRequestVO stSmssendRequestVO,
            @RequestParam(required = false, defaultValue = "1") int page, 
            @RequestParam(required = false, defaultValue = "30") int limit,
            @RequestParam(required = false, defaultValue = "no") String sort,
            @RequestParam(required = false, defaultValue = "desc") String dir
        ) throws Exception {
        
        ModelAndView modelAndView = new ModelAndView();
        
        // 코드조회 
        modelAndView.addObject("codeUser", commonCacheService.getStUserList()); //사용자리스트
        
        Date today = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");      
        modelAndView.addObject("excelFileName", "SMS발송내역_"+simpleDateFormat.format(today)); 
        
        PageBounds pageBounds = new PageBounds(page, limit);
        pageBounds.getOrders().add(Order.create(sort, dir));

        logger.debug("getParameter : stSmssendRequestVO:" + stSmssendRequestVO);

        PageList<StSmssendResponseVO> pageList = stSmssendService.getStSmssendList(stSmssendRequestVO, pageBounds);

        modelAndView.addObject("requestVO", stSmssendRequestVO);
        modelAndView.addObject("pageList", pageList);
        modelAndView.setViewName("/st/stSmssendV.tiles");
        return modelAndView;

    }

    @RequestMapping("/st/smssend/excel")
    public void mainView(HttpServletRequest request,HttpServletResponse response,StSmssendRequestVO stSmssendRequestVO) throws Exception {

        String csvFileName = new String((stSmssendRequestVO.getLogDsRemk()+".csv").getBytes("KSC5601"),"8859_1");
        response.reset();
        response.resetBuffer();
        response.setContentType("application/octet-stream; charset=euc-kr"); 
        response.setDateHeader("Expires", 0);
        response.setHeader("Content-Disposition", "attachment;filename="+csvFileName+";");
        response.setHeader("Content-Transfer-Encoding", "binary" );        
        
        String[] header = { "일련번호", 
                                    "발송구분", 
                                    "접수번호", 
                                    "발송자", 
                                    "발송일시", 
                                    "발신번호",
                                    "수신번호", 
                                    "전송결과", 
                                    "메세지"}; 

        String[] data = { "no", 
                                    "cdKind", 
                                    "noReq", 
                                    "nmReg", 
                                    "dmSend", 
                                    "noSend",
                                    "noRcv", 
                                    "nmResult", 
                                    "dsMsg" };                                     

        List<StSmssendResponseVO> getStSmssendList = stSmssendService.getStSmssendList(stSmssendRequestVO);

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        csvWriter.writeHeader(header);

        for(StSmssendResponseVO dummy : getStSmssendList){

            csvWriter.write(dummy, data);
        }

        csvWriter.close();  


    }

   
}