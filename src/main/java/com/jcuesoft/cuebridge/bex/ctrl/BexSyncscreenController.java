package com.jcuesoft.cuebridge.bex.ctrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jcuesoft.cuebridge.bex.service.BexMasterService;
import com.jcuesoft.cuebridge.bex.service.BexSyncscreenService;
import com.jcuesoft.cuebridge.bex.vo.BexMasterRequestVO;
import com.jcuesoft.cuebridge.bex.vo.BexMasterResponseVO;
import com.jcuesoft.cuebridge.common.module.CommonSessionUtil;
import com.jcuesoft.cuebridge.common.service.CommonCacheService;
import com.jcuesoft.cuebridge.web.ctrl.BaseController;

@Controller
public class BexSyncscreenController extends BaseController {

    @Autowired
    private BexSyncscreenService bexSyncscreenService;

    @Autowired
    private CommonCacheService commonCacheService;    
    
    @Autowired
    private BexMasterService bexMasterService;    
    /**
     * 심사기표보정
     *
     * @param request
     * @param response
     */
    @RequestMapping("/bex/syncscreen/select")
    public ModelAndView mainView(HttpServletRequest request, HttpServletResponse response,BexMasterRequestVO bexMasterRequestVO) throws Exception {
        
        // 로그인 & 권한체크
        /*super.LoginCheck(request,response);*/
        
        ModelAndView modelAndView = new ModelAndView();
        
        // 전체검색 비허용
        bexMasterRequestVO.setSearchDmRegStart("1900-01-01");
        bexMasterRequestVO.setSearchDmRegEnd("2900-12-31");
        if(bexMasterRequestVO.getNoReq() == null || bexMasterRequestVO.getNoReq().trim().equals("")){
            bexMasterRequestVO.setSearchNoReq("99999999-999");
            //bexMasterRequestVO.setSearchNoReq("20141216-0095");
        }else{
            bexMasterRequestVO.setSearchNoReq(bexMasterRequestVO.getNoReq());
        }
        
        List<BexMasterResponseVO> masterList = bexMasterService.getExListAll(bexMasterRequestVO); 
        
        if(bexMasterRequestVO.getNoEx() != null && bexMasterRequestVO.getNoEx().trim().getBytes().length > 0){
            BexMasterResponseVO view = bexMasterService.getBexMasterOne(bexMasterRequestVO);
            modelAndView.addObject("pdtList"  , commonCacheService.getStPdtList());       //상품
            modelAndView.addObject("view", view);
        }
        
        modelAndView.addObject("masterList", masterList);
        modelAndView.addObject("requestVO", bexMasterRequestVO);
        modelAndView.setViewName("/bex/bexSyncscreenV.tiles");      
        return modelAndView;        
    }
    
    /**
     * 파일업로드
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */    
    @RequestMapping(value = "/bex/syncscreen/upload", method = RequestMethod.POST)
    public ModelAndView uploadFile(HttpServletRequest request, HttpServletResponse response,ModelAndView modelAndView, MultipartFile file, BexMasterRequestVO bexMasterRequestVO)
            throws Exception {
        logger.debug("Call BexSyncscreenController uploadFile file:"+file.getOriginalFilename());
        // 로그인 & 권한체크
        /*super.LoginCheck(request, response);*/
        bexMasterRequestVO.setIdReg(CommonSessionUtil.getIdUser());
        String callBack = bexSyncscreenService.excuteByCsv(bexMasterRequestVO, file);
        if(callBack.substring(0,1).equals("S")) {
            modelAndView = new ModelAndView();
            modelAndView.addObject("callBack", callBack);
        }else{
            //에러처리
        }
            
        modelAndView.setViewName("/bex/bexSyncscreenV.tiles");        
        return modelAndView;
    }
    
    @RequestMapping(value = "/bex/syncscreen/update", method = RequestMethod.POST)
    public ModelAndView updateSyncscreen(HttpServletRequest request, HttpServletResponse response, BexMasterRequestVO bexMasterRequestVO) throws Exception {
        logger.debug("Call BexSyncscreenController updateSyncscreen...");
        // 로그인 & 권한체크
        /*super.LoginCheck(request, response);*/
        bexMasterRequestVO.setIdReg(CommonSessionUtil.getIdUser());
        bexSyncscreenService.excuteByView(bexMasterRequestVO);
        
        return new ModelAndView("redirect:/bex/syncscreen/select?noReq="+bexMasterRequestVO.getNoReq()+"&noEx="+bexMasterRequestVO.getNoEx());
    }    
    
}