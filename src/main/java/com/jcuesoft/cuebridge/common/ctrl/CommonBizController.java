package com.jcuesoft.cuebridge.common.ctrl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.jcuesoft.cuebridge.brc.vo.BrcImageListRequestVO;
import com.jcuesoft.cuebridge.common.service.CommonBizService;
import com.jcuesoft.cuebridge.common.vo.CommonBizVO;
import com.jcuesoft.cuebridge.web.ctrl.BaseController;

@Controller
public class CommonBizController extends BaseController {
    
    @Autowired
    private CommonBizService  commonBizService;
    
    /**
     * 메세지 반환
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/common/message/select", method = RequestMethod.POST  , produces={"application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody HashMap<String, String>  getSmsMessage(HttpServletRequest request, HttpServletResponse response,CommonBizVO commonBizVO) throws Exception {
        
        logger.debug("call /common/message/select RequestVO:"+commonBizVO);
        HashMap<String, String> result = new HashMap<String, String>();
        result = commonBizService.setSmsMessage(commonBizVO);
        return result;
  
    }
    
    /**
     * server file resource return
     */    
    @RequestMapping("/common/file/download/{dsFileBase64}")
    public void downloadFile(HttpServletRequest request, HttpServletResponse response, @PathVariable("dsFileBase64") String dsFileBase64) throws Exception {
        logger.debug("Call CommonBizController downloadFile...");
        
        /*super.LoginCheck(request, response);*/
        
        try {
            logger.debug("base64 string:"+dsFileBase64);
            String filePathToBeServed = commonUtil.convertBase64Decode(dsFileBase64);
            logger.debug("base64 decode string:"+filePathToBeServed);
            //filePathToBeServed = "Z:\\test.jpg";
            logger.debug("filePathToBeServed:"+filePathToBeServed);
            
            if(!filePathToBeServed.startsWith("/ext_data/")){
                String msg = "접근 가능한 리소스 경로가 아닙니다.\r\n불법적인 시스템 사용은 관련법에 의해 처벌을 받습니다.";
                request.setAttribute("errorResult", msg);
                throw new Exception(msg);
            }
            
            String fileName = commonUtil.getLastIndexString(filePathToBeServed, "/");
            File fileToDownload = new File(filePathToBeServed);
            InputStream inputStream = new FileInputStream(fileToDownload);
            response.reset();
            response.resetBuffer();            
            response.setContentType("application/force-download");
            response.setContentLength((int)fileToDownload.length());
            response.setDateHeader("Expires", 0);
            response.setHeader("Content-Transfer-Encoding", "binary");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
            IOUtils.copy(inputStream, response.getOutputStream());
            response.flushBuffer();
            inputStream.close();            
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }    
    
    /**
     * 이미지뷰어 팝업 공통처리
     * @param noReq, dsFile
     */    
    @RequestMapping("/common/imageview/select")
    @ResponseBody
    public  ModelAndView imageview(HttpServletRequest request, HttpServletResponse response,BrcImageListRequestVO brcImageListRequestVO) throws Exception {
        /*super.LoginCheck(request, response);*/

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("noReq", brcImageListRequestVO.getNoReq());
        //modelAndView.addObject("dsFileBase64", Base64.getEncoder().encodeToString("Z:\\test.tif".getBytes("utf-8")));
        modelAndView.addObject("dsFileBase64", brcImageListRequestVO.getDsFileBase64());

        String filePath = commonUtil.convertBase64Decode(brcImageListRequestVO.getDsFileBase64());
        String imgExt = commonUtil.getFileExtension(filePath).toLowerCase();
        if(imgExt == null){
            imgExt = "empty";
        }else if(imgExt.matches(".*png.*") ){
            imgExt = "png";
        }else if(imgExt.matches(".*jpg.*") || imgExt.matches(".*jpeg.*") ){
            imgExt = "jpg";
        }else if(imgExt.matches(".*gif.*") ){
            imgExt = "gif";
        }else if(imgExt.matches(".*bmp.*") ){
            imgExt = "bmp";
        }else if(imgExt.matches(".*tif.*") ){
            imgExt = "tif";
        }
        
        modelAndView.addObject("imgExt", imgExt);        
        modelAndView.setViewName("/common/commonImageView.pop");

        return modelAndView;
    }        

}
