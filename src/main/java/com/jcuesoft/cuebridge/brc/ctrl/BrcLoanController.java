package com.jcuesoft.cuebridge.brc.ctrl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.jcuesoft.cuebridge.bex.service.BexMasterService;
import com.jcuesoft.cuebridge.bex.vo.BexMasterRequestVO;
import com.jcuesoft.cuebridge.bex.vo.BexMasterResponseVO;
import com.jcuesoft.cuebridge.brc.service.BrcContactService;
import com.jcuesoft.cuebridge.brc.service.BrcFileService;
import com.jcuesoft.cuebridge.brc.service.BrcImageListService;
import com.jcuesoft.cuebridge.brc.service.BrcLoanService;
import com.jcuesoft.cuebridge.brc.service.BrcReAppService;
import com.jcuesoft.cuebridge.brc.service.BrcSearchService;
import com.jcuesoft.cuebridge.brc.service.BrcSmsService;
import com.jcuesoft.cuebridge.brc.service.BrcSuretyService;
import com.jcuesoft.cuebridge.brc.vo.BrcContactRequestVO;
import com.jcuesoft.cuebridge.brc.vo.BrcContactResponseVO;
import com.jcuesoft.cuebridge.brc.vo.BrcFileRequestVO;
import com.jcuesoft.cuebridge.brc.vo.BrcFileResponseVO;
import com.jcuesoft.cuebridge.brc.vo.BrcImageListRequestVO;
import com.jcuesoft.cuebridge.brc.vo.BrcImageListResponseVO;
import com.jcuesoft.cuebridge.brc.vo.BrcLoanCountVO;
import com.jcuesoft.cuebridge.brc.vo.BrcLoanInfoResponseVO;
import com.jcuesoft.cuebridge.brc.vo.BrcLoanRequestVO;
import com.jcuesoft.cuebridge.brc.vo.BrcLoanResponseVO;
import com.jcuesoft.cuebridge.brc.vo.BrcSearchRequestVO;
import com.jcuesoft.cuebridge.brc.vo.BrcSearchResponseVO;
import com.jcuesoft.cuebridge.brc.vo.BrcSmsRequestVO;
import com.jcuesoft.cuebridge.brc.vo.BrcSmsResponseVO;
import com.jcuesoft.cuebridge.brc.vo.BrcSuretyInfoResponseVO;
import com.jcuesoft.cuebridge.brc.vo.BrcSuretyRequestVO;
import com.jcuesoft.cuebridge.common.module.CommonFileUpload;
import com.jcuesoft.cuebridge.common.module.CommonSessionUtil;
import com.jcuesoft.cuebridge.common.module.CommonUtil;
import com.jcuesoft.cuebridge.common.pagination.Order;
import com.jcuesoft.cuebridge.common.pagination.PageBounds;
import com.jcuesoft.cuebridge.common.pagination.PageList;
import com.jcuesoft.cuebridge.common.service.CommonBizService;
import com.jcuesoft.cuebridge.common.service.CommonCacheService;
import com.jcuesoft.cuebridge.common.vo.LincusCommunicationVO;
import com.jcuesoft.cuebridge.common.vo.LincusMemberVO;
import com.jcuesoft.cuebridge.ups.vo.MemberListInoutTmVO;
import com.jcuesoft.cuebridge.web.ctrl.BaseController;

@Controller
public class BrcLoanController extends BaseController{
    /**
     * brcLoanService
     */
    @Autowired
    private BrcLoanService brcLoanService;
    
    @Autowired
    private BrcContactService brcContactService;
    
    @Autowired
    private BrcSmsService brcSmsService;
    
    @Autowired
    private BrcImageListService brcImageListService;
    
    @Autowired
    private BrcSearchService brcSearchService;    
    
    @Autowired
    private BrcFileService brcFileService;    
    
    @Autowired
    private BrcSuretyService brcSuretyService;     
    
    @Autowired
    private BexMasterService bexMasterService;    
    
    @Autowired
    private BrcReAppService brcReAppService;    
    
    /**
     * commonSearchService
     */
    @Autowired
    private CommonCacheService commonCacheService;
    
    @Autowired
    private CommonBizService commonBizService;    

    /**
     * 상담자별 접수관리 BRC01
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/brc/loan/select")
    public ModelAndView mainView(HttpServletRequest request, HttpServletResponse response, 
                                                BrcLoanRequestVO brcLoanRequestVO,
                                                BrcSuretyRequestVO brcSuretyRequestVO ,
                                                BrcContactRequestVO brcContactRequestVO,
                                                BrcFileRequestVO brcFileRequestVO ,
                                                BexMasterRequestVO bexMasterRequestVO) throws Exception {
       
        // 로그인 & 권한체크
        /*super.LoginCheck(request,response);*/
        
        //log
        logger.debug("Call BrcLoanController mainView...");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pdtList", commonCacheService.getStPdtList());       //상품
        modelAndView.addObject("screenList", commonCacheService.getStUserListScreen());       //심사자
        modelAndView.addObject("emailList", commonCacheService.getEmailList());       //이메일
        modelAndView.addObject("HH", commonCacheService.getHHList());   //약속시각
        modelAndView.addObject("MI", commonCacheService.getMIList());   //약속분
        modelAndView.addObject("code131", commonCacheService.getStCodeList("131")); //취소사유
        modelAndView.addObject("code132", commonCacheService.getStCodeList("132")); //거절사유
        modelAndView.addObject("code203", commonCacheService.getStCodeList("203")); //파일구분                
        modelAndView.addObject("code703", commonCacheService.getStCodeList("703")); //거래처코드
        modelAndView.addObject("code704", commonCacheService.getStCodeList("704")); //접수경로
        modelAndView.addObject("code707", commonCacheService.getStCodeList("707")); //결혼구분
        modelAndView.addObject("code708", commonCacheService.getStCodeList("708")); //통신사구분
        modelAndView.addObject("code709", commonCacheService.getStCodeList("709")); //직업구분
        modelAndView.addObject("code710", commonCacheService.getStCodeList("710")); //심사상태
        modelAndView.addObject("code711", commonCacheService.getStCodeList("711")); //공인인증구분
        modelAndView.addObject("code133", commonCacheService.getStCodeList("133")); //직급코드
        modelAndView.addObject("code185", commonCacheService.getStCodeList("185")); //고용형태코드
        modelAndView.addObject("code186", commonCacheService.getStCodeList("186")); //직무구분코드
        modelAndView.addObject("code719", commonCacheService.getStCodeList("719")); //모집분류코드
        
        // 상담자 셋팅 
        brcLoanRequestVO.setLeftSearchId(CommonSessionUtil.getIdUser()); // 트리메뉴 조건
        brcLoanRequestVO.setIdReg(CommonSessionUtil.getIdUser()); // 등록자
        
        // 고객정보 
        boolean isView = (brcLoanRequestVO.getSearchNoReq() != null);
        if(isView){
            BrcLoanInfoResponseVO view = brcLoanService.getBrcLoanInfo(brcLoanRequestVO);
            logger.debug("#######################################################################");
            logger.debug(view.getNmCustom());
            String browserTitle = view.getNmCustom();
            if(view.getNoCustom() != null && view.getNoCustom().length() >= 6){
                browserTitle = browserTitle + "("+view.getNoCustom().substring(0,6)+")";
            }
            
            modelAndView.addObject("browserTitle", browserTitle);
            modelAndView.addObject("view", view);
            
            // 고객정보창일경우만  해당 고객의 담당 심사자로 트리메뉴구성
            brcLoanRequestVO.setLeftSearchId(view.getIdScreen());
        }
        //brcLoanRequestVO.setLeftSearchId("C0028");
        // left menu 
        List<BrcLoanResponseVO> list01 = brcLoanService.getBrcLoanLeftList(brcLoanRequestVO);
        
        modelAndView.addObject("list01", list01);    //접수내역
        // 리스트 내 접수메모 이력조회
        if(brcLoanRequestVO.getSearchContactNoReq() != ""){
            brcContactRequestVO.setSearchContactNoReq(brcLoanRequestVO.getSearchContactNoReq().split(","));
            List<BrcContactResponseVO> list02 = brcContactService.getContactReqList(brcContactRequestVO);
            modelAndView.addObject("list02", list02);//접촉이력조회
        }
        
        // 보증인정보
        boolean isSuretyView = (brcSuretyRequestVO.getSearchNoSurety() != null);
        if(isSuretyView){
            logger.debug("suretyView");
            BrcSuretyInfoResponseVO suretyView = brcSuretyService.getBrcSuretyInfo(brcSuretyRequestVO);
            logger.debug("suretyView");
            logger.debug("suretyView:"+suretyView.getDmPromiseYMD());
            logger.debug("suretyView:"+suretyView.getDmPromiseHH());
            logger.debug("suretyView:"+suretyView.getDmPromiseMI());
            
            modelAndView.addObject("suretyView", suretyView);
        }        
        
        boolean isListView = (brcLoanRequestVO.getSearchCdStatus() != null);
        if(isListView){
            logger.debug("isListView");
            
            // List<BrcLoanResponseVO> brcLoanList = brcLoanService.getBrcLoanList(brcLoanRequestVO);
            //modelAndView.addObject("brcLoanList", brcLoanList);
            
            // 페이징 처리 
            int page          = brcLoanRequestVO.getPage() > 0  ? brcLoanRequestVO.getPage() : 1;
            int limit           = brcLoanRequestVO.getLimit() > 0  ? brcLoanRequestVO.getLimit() : 20;
            String sort      = "DM_RECEIVE";
            String dir        = "DESC"; 

            PageBounds pageBounds = new PageBounds(page, limit);
            pageBounds.getOrders().add(Order.create(sort, dir));
            
            PageList<BrcLoanResponseVO> pageList = brcLoanService.getBrcLoanList(brcLoanRequestVO,pageBounds);
            modelAndView.addObject("pageList", pageList);

            // 리스트 내  접수메모 이력조회
            if(brcLoanRequestVO.getSearchContactNoReq() != ""){
                brcContactRequestVO.setSearchContactNoReq(brcLoanRequestVO.getSearchContactNoReq().split(","));
                List<BrcContactResponseVO> brcContactList = brcContactService.getContactReqList(brcContactRequestVO);
                modelAndView.addObject("brcContactList", brcContactList);
            }
            
            //List<BrcContactResponseVO> brcContactList = brcContactService.getContactListForTooltip(brcContactRequestVO);
            //modelAndView.addObject("brcContactList", brcContactList);
            logger.debug("@@@@@@@@@@@@"+brcLoanRequestVO);
            BrcLoanCountVO brcLoanCount = brcLoanService.getBrcLoanCount(brcLoanRequestVO);
            modelAndView.addObject("brcLoanCount", brcLoanCount);
        
        }else{
        
            //보증인리스트
            brcSuretyRequestVO.setNoReq(brcLoanRequestVO.getSearchNoReq());
            List<BrcSuretyInfoResponseVO> suretyList = brcSuretyService.getBrcSuretyList(brcSuretyRequestVO);
            modelAndView.addObject("suretyList", suretyList);
            
            //실행현황리스트
            bexMasterRequestVO.setNoReq(brcLoanRequestVO.getSearchNoReq());
            logger.debug("bexMasterRequestVO.getNoReq:"+bexMasterRequestVO.getNoReq());
            List<BexMasterResponseVO> bexList = bexMasterService.getBexMasterList(bexMasterRequestVO);
            modelAndView.addObject("bexList", bexList);
            
            // 메모 리스트
            brcContactRequestVO.setCdContact("71201");
            List<BrcContactResponseVO> contactList = brcContactService.getContactList(brcContactRequestVO);
            modelAndView.addObject("contactList", contactList);
            
            // 첨부파일 리스트
            brcFileRequestVO.setNoReq(brcLoanRequestVO.getSearchNoReq());
            List<BrcFileResponseVO> fileList = brcFileService.getBrcFileList(brcFileRequestVO);
            modelAndView.addObject("fileList", fileList);
                 
        }
        modelAndView.addObject("requestVO", brcLoanRequestVO);
        
        modelAndView.setViewName("/brc/brcLoanV.tiles");
        return modelAndView;
    }
    
    /**
     * 비대면 관리대장 
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */    
    @RequestMapping(value = "/brc/loantm/select", method = RequestMethod.POST)    
    public ModelAndView getLoanTmList(HttpServletRequest request, HttpServletResponse response, BrcLoanRequestVO brcLoanRequestVO)
            throws Exception {

        //비대면관리대장리스트
        logger.debug("memberListInoutTmList");
        List<MemberListInoutTmVO> memberListInoutTmList = brcLoanService.getMemberListInoutTmList(brcLoanRequestVO.getSearchNoReq());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("memberListInoutTmList", memberListInoutTmList);
        modelAndView.setViewName("/brc/brcLoanInfoAjaxTm");
        return modelAndView;
    }
    
    /**
     * 접수자일괄변경
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */    
    @RequestMapping(value = "/brc/loan/updatebatch", method = RequestMethod.POST)    
    public ModelAndView updateBatchBrcLoan(HttpServletRequest request, HttpServletResponse response, BrcLoanRequestVO brcLoanRequestVO)
            throws Exception {
        logger.debug("Call BrcLoanController updateBatchBrcLoan...");
        commonBizService.updateBatchBrcLoan(brcLoanRequestVO);
        logger.debug("before model return");
        return new ModelAndView("redirect:/brc/loan/select?searchCdStatus=" + brcLoanRequestVO.getSearchCdStatus());
    }
    
    /**
     * 보증인정보등록
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */    
    @RequestMapping(value = "/brc/surety/insert", method = RequestMethod.POST)    
    public ModelAndView insertBrcSuretyInfo(HttpServletRequest request, HttpServletResponse response, BrcSuretyRequestVO brcSuretyRequestVO)
            throws Exception {
        logger.debug("Call BrcLoanController insertBrcSuretyInfo...");
        //brcSuretyRequestVO.setNoReq(brcSuretyRequestVO.getSearchNoReq());
        logger.debug(brcSuretyRequestVO.getNoReq());
        String callback = brcSuretyService.insertBrcSuretyInfo(brcSuretyRequestVO);
        logger.debug("insertBrcSuretyInfo callback:"+callback);
        if(callback.substring(0,1).equals("S")) {
            
        }else{
            //에러처리
        }
        logger.debug("insertBrcSuretyInfo searchNoReq:"+brcSuretyRequestVO.getNoReq());
        logger.debug("insertBrcSuretyInfo searchNoSurety:"+brcSuretyRequestVO.getNoSurety());
        return new ModelAndView("redirect:/brc/loan/select?searchNoReq=" + brcSuretyRequestVO.getNoReq()+"&searchNoSurety="+ brcSuretyRequestVO.getNoSurety());
    }
    
    /**
     * 보증인정보수정
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */    
    @RequestMapping(value = "/brc/surety/update", method = RequestMethod.POST)    
    public ModelAndView updateBrcSurety(HttpServletRequest request, HttpServletResponse response, BrcSuretyRequestVO brcSuretyRequestVO)
            throws Exception {
        logger.debug("Call BrcLoanController updateBrcSurety...");
        logger.debug("brcSuretyRequestVO:" + brcSuretyRequestVO.getNmCustom());
        logger.debug("brcSuretyRequestVO:" + brcSuretyRequestVO.getDmPromise());      
        String callBack = brcSuretyService.updateBrcSuretyInfo(brcSuretyRequestVO);
        logger.debug("updateBrcSurety callBack:"+callBack);
        if(callBack.substring(0,1).equals("S")) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("callBack", callBack);
        }else{
            //에러처리
        }            
        
        
        return new ModelAndView("redirect:/brc/loan/select?searchNoReq=" + brcSuretyRequestVO.getNoReq()+"&searchNoSurety="+ brcSuretyRequestVO.getNoSurety());
    }
    
    /**
     * 첨부파일 정보수정
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */    
    @RequestMapping(value = "/brc/attach/update", method = RequestMethod.POST)    
    public ModelAndView updateAttach(HttpServletRequest request, HttpServletResponse response, BrcFileRequestVO brcFileRequestVO)
            throws Exception {
        
        // 파일정보 수정 
        brcFileService.updateBrcFile(brcFileRequestVO);
        return new ModelAndView("redirect:/brc/loan/select?searchNoReq=" + brcFileRequestVO.getNoReq());
    }
    
    /**
     * 첨부파일 삭제
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */    
    @RequestMapping(value = "/brc/attach/delete", method = RequestMethod.POST)    
    public ModelAndView deleteAttach(HttpServletRequest request, HttpServletResponse response, BrcFileRequestVO brcFileRequestVO)
            throws Exception {
        
        brcFileService.deleteBrcFile(brcFileRequestVO);
        return new ModelAndView("redirect:/brc/loan/select?searchNoReq=" + brcFileRequestVO.getNoReq());
    }
    
    /**
     * 파일업로드
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */    
    @RequestMapping(value = "/brc/loan/upload", method = RequestMethod.POST)
    public ModelAndView uploadFile(HttpServletRequest request, HttpServletResponse response,ModelAndView mv, BrcFileRequestVO brcFileRequestVO)
            throws Exception {
        
        try {
            logger.debug("Call BrcLoanController uploadFile...");
            logger.debug("brcFileRequestVO.toString():"+brcFileRequestVO.toString());
            CommonFileUpload commonFileUpload = new CommonFileUpload();
            String nasPath = commonCacheService.getDsNasImgPath();
            String nmCompShort = commonCacheService.getStCompOne().getNmCompShortEng();
            BigDecimal noSeq = brcFileService.getBrcFileSeq();      
            
            String nmFileUser = "";        
            String extension = "";
            String nmFile = "";
            String dsPath = "";
            String callBack = "";
            
            // 외부 유입된 이미지 처리
            if(brcFileRequestVO.getDsFileFrom() !=null && brcFileRequestVO.getDsFileFrom().length() > 0){
                brcFileRequestVO.setDsFileFrom(commonUtil.convertBase64Decode(brcFileRequestVO.getDsFileFrom()));
                nmFileUser = commonUtil.getLastIndexString(brcFileRequestVO.getDsFileFrom(), "/");
                extension = commonFileUpload.getFileExtension(nmFileUser);
                nmFile     = commonFileUpload.getImgFileName(nmCompShort,brcFileRequestVO.getNoReq(), noSeq) + "." + extension;
                dsPath     = commonFileUpload.getImgSavePath(nasPath);
                String fileFrom    = brcFileRequestVO.getDsFileFrom();
                String fileTo      = dsPath+nmFile;
                logger.debug("fileFrom>fileTo:"+fileFrom+":"+fileTo);
                commonUtil.copyFile(fileFrom, fileTo);
                callBack = "S";
            }else{
                nmFileUser = brcFileRequestVO.getFile().getOriginalFilename();        
                extension = commonFileUpload.getFileExtension(nmFileUser);
                nmFile = commonFileUpload.getImgFileName(nmCompShort,brcFileRequestVO.getNoReq(), noSeq) + "." + extension;
                dsPath = commonFileUpload.getImgSavePath(nasPath);
                callBack = commonFileUpload.uploadFile(dsPath, nmFile, brcFileRequestVO.getFile());
            }
            
            logger.debug("uploadFile callBack:"+callBack);
            if(callBack.substring(0,1).equals("S")) {
                brcFileRequestVO.setNo(noSeq);
                brcFileRequestVO.setNmFile(nmFile);
                brcFileRequestVO.setNmFileUser(nmFileUser);
                brcFileRequestVO.setDsPath(dsPath);
                brcFileService.insertBrcFile(brcFileRequestVO);
            }else{
                //에러처리
                throw new Exception(callBack);
            }
        } catch (Exception e) {
            brcFileRequestVO.setError(e);
            request.setAttribute("requestResultVO", brcFileRequestVO);
            mv.setViewName("forward:/brc/loan/select?searchNoReq=" + brcFileRequestVO.getNoReq());
            return mv;
        }
        mv.setViewName("redirect:/brc/loan/select?searchNoReq=" + brcFileRequestVO.getNoReq());
        return mv;
    }      
    
    /**
     * 상담자 접수정보 수정
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */    
    @RequestMapping(value = "/brc/loan/update", method = RequestMethod.POST  , produces={"application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody HashMap<String, String>  updateBrcLoanInfo(HttpServletRequest request, HttpServletResponse response, BrcLoanRequestVO brcLoanRequestVO)
            throws Exception {
        
        HashMap<String, String> result = new HashMap<String, String>();
        brcLoanRequestVO.setIdUpt(CommonSessionUtil.getIdUser());
        logger.debug("Call BrcLoanController updateBrcLoanInfo...");
        logger.debug("getNmCustom:" + brcLoanRequestVO.getNmCustom());
        String callBack = brcLoanService.updateBrcLoanInfo(brcLoanRequestVO);
        logger.debug("updateBrcLoanInfo callBack:"+callBack);
        if(callBack.substring(0,1).equalsIgnoreCase("S")) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("callBack", callBack);
            modelAndView.addObject("searchNoReq", brcLoanRequestVO.getSearchNoReq());
            logger.info("##############컨트롤러");
            logger.info(brcLoanRequestVO.getNoReq());
            logger.info(brcLoanRequestVO.getSearchNoReq());
            logger.info("dmPromiseYMD", brcLoanRequestVO.getDmPromiseYMD());
            logger.info("dmPromiseHH", brcLoanRequestVO.getDmPromiseHH());
            logger.info("dmPromiseMI", brcLoanRequestVO.getDmPromiseMI());
            result.put("result", "success");
        }else{
            //에러처리
            result.put("result", "fail");
            result.put("message", callBack);
        }           
        return result;

    }

    /**
     * 상담자 신규접수 팝업
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/brc/loanregist/select")
    public ModelAndView registPopup(HttpServletRequest request, HttpServletResponse response,BrcSearchRequestVO brcSearchRequestVO) throws Exception {
        //log
        logger.debug("Call BrcLoanController registPopup...");
        
        String regID = " ".equals(CommonSessionUtil.getIdUser()) ? brcSearchRequestVO.getIdReceive() : CommonSessionUtil.getIdUser();

        //return
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("regID", regID);      
        
        modelAndView.addObject("code704", commonCacheService.getStCodeList("704")); //접수경로
        modelAndView.addObject("code707", commonCacheService.getStCodeList("707")); //결혼구분
        modelAndView.addObject("code709", commonCacheService.getStCodeList("709")); //직업분류
        modelAndView.addObject("pdtList"  , commonCacheService.getStPdtList());       //상품
        modelAndView.addObject("emailList", commonCacheService.getEmailList());       //이메일
        modelAndView.addObject("screenList", commonCacheService.getStUserListScreen());       //심사자
        modelAndView.addObject("codeUser", commonCacheService.getStUserList()); //전체사용자
        modelAndView.addObject("requestVO", brcSearchRequestVO);      
        modelAndView.setViewName("/brc/brcLoanRegPop.pop");
        return modelAndView;
    }

    /**
     * 상담자 신규접수
     *
     * @param request
     * @param response
     * @param brcLoanRequestVO
     * @return
     * @throws Exception
     */
    @RequestMapping("/brc/loan/insert")
    public ModelAndView insertBrc(HttpServletRequest request, HttpServletResponse response, BrcLoanRequestVO brcLoanRequestVO) throws Exception {
        //log
        logger.debug("Call BrcLoanController insertBrc...");
        logger.debug("brcLoanRequestVO:"+brcLoanRequestVO);
        
        String resultCode = "";
        String regID = " ".equals(CommonSessionUtil.getIdUser()) ? brcLoanRequestVO.getIdReceive() : CommonSessionUtil.getIdUser();
        brcLoanRequestVO.setIdReg(regID);
        if(brcLoanRequestVO.getIdReg() == null || " ".equals(brcLoanRequestVO.getIdReg())){
            resultCode = "EMPTY_ID_REG";
        }else{
          //insert
          resultCode = brcLoanService.insertBrc(brcLoanRequestVO);
        }
        
        //return
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("resultCode", resultCode);
        modelAndView.setViewName("/brc/brcLoanRegPop.pop");
        return modelAndView;
    }
    
    /**
     * 재접수
     *
     * @param request
     * @param response
     * @param brcLoanRequestVO
     * @return
     * @throws Exception
     */
    @RequestMapping("/brc/loancopy/insert")
    public ModelAndView insertBrcCopy(HttpServletRequest request, HttpServletResponse response, BrcLoanRequestVO brcLoanRequestVO) throws Exception {
        //log
        logger.debug("Call BrcLoanController insertBrcCopy...");
        logger.debug("brcLoanRequestVO:"+brcLoanRequestVO);

        brcReAppService.brcReAppProcedure(brcLoanRequestVO.getNoReq());
        return new ModelAndView("redirect:/brc/loan/select?searchNoReq=" + brcLoanRequestVO.getNoReq());
    }
    
    /**
     * 이미지리스트 비동기 호출 
     *
     * @param request
     * @param response
     */
    @RequestMapping("/brc/imagelist/select")
    public ModelAndView imagelist(HttpServletRequest request, HttpServletResponse response,BrcImageListRequestVO brcImageListRequestVO) throws Exception {
        //super.LoginCheck(request, response);        
        
        // 팩스 리스트
        ModelAndView modelAndView = new ModelAndView();
        List<BrcImageListResponseVO> brcImageListResponseVOs = null;
        
        if(brcImageListRequestVO.getSearchKind() == null){
            brcImageListRequestVO.setSearchKind("fax");
        }
        if(brcImageListRequestVO.getSearchKind().equals("fax")){        //확인할것
            brcImageListResponseVOs = brcImageListService.getFaxList(brcImageListRequestVO);
        }else if(brcImageListRequestVO.getSearchKind().equals("mms")){
            brcImageListResponseVOs = brcImageListService.getMmsList(brcImageListRequestVO);
        }
        modelAndView.addObject("searchKind", brcImageListRequestVO.getSearchKind());
        modelAndView.addObject("imageList", brcImageListResponseVOs);       
        // 팩스번호 리스트
        Map<String, String> teamFaxList = commonBizService.getTeamFax(); // 팀팩스 
        modelAndView.addObject("teamFaxList", teamFaxList);
        logger.debug("teamFaxList.toString():"+teamFaxList.toString()); 
        
        modelAndView.setViewName("/brc/brcLoanAjaxImageList");
        return modelAndView;

    }

    /**
     * 연계검사팝업 
     *
     * @param request
     * @param response
     */
    @RequestMapping("/brc/search/select")
    public ModelAndView inBoundSearch(HttpServletRequest request, HttpServletResponse response,BrcSearchRequestVO brcSearchRequestVO) throws Exception {

        ModelAndView modelAndView = new ModelAndView();
        if("Y".equals(brcSearchRequestVO.getSearchConfirm()) ){
            
            LincusMemberVO lncusMemberInfo = null;
            
            // 린커스 ERP/UPS 조회인경우 검색파라미터 디비 조회해서 셋팅 
            if(brcSearchRequestVO.getSearchLincusOpt() != null &&  brcSearchRequestVO.getSearchLincusKey() != null  ){
                
                switch(brcSearchRequestVO.getSearchLincusOpt()){
                    case "ERP" :
                    case "ERP2" :
                    case "ERP3" :
                        if("GUA".equalsIgnoreCase(brcSearchRequestVO.getSearchLincusType())){
                            lncusMemberInfo = brcSearchService.getErpSuretyInfo(brcSearchRequestVO);                             
                        }else{
                            lncusMemberInfo = brcSearchService.getErpCustomInfo(brcSearchRequestVO); 
                        }
                    break;
                    case "UPS" :
                    case "UPS2" : 
                    case "UPS3" : 
                    case "GUARANTOR" : 
                        if("GUA".equalsIgnoreCase(brcSearchRequestVO.getSearchLincusType())){
                            lncusMemberInfo = brcSearchService.getUpsSuretyInfo(brcSearchRequestVO);                             
                        }else{
                            lncusMemberInfo = brcSearchService.getUpsCustomInfo(brcSearchRequestVO); 
                        }
                   break;
                }
                // 파라미터 전달
                if(lncusMemberInfo != null){
                    
                    // 고객정보창 보증인 연계검사시 주민번호만 검색
                    if("UPS2".equalsIgnoreCase(brcSearchRequestVO.getSearchLincusOpt()) && "GUA".equalsIgnoreCase(brcSearchRequestVO.getSearchLincusType())){
                        brcSearchRequestVO.setSearchNoCustomFirst(lncusMemberInfo.getSsn11());
                        brcSearchRequestVO.setSearchNoCustomSecond(lncusMemberInfo.getSsn12());
                    }else if("ERP2".equalsIgnoreCase(brcSearchRequestVO.getSearchLincusOpt()) && "GUA".equalsIgnoreCase(brcSearchRequestVO.getSearchLincusType())){
                        brcSearchRequestVO.setSearchNoCustomFirst(lncusMemberInfo.getSsn11());
                        brcSearchRequestVO.setSearchNoCustomSecond(lncusMemberInfo.getSsn12());
                    }else{
                        brcSearchRequestVO.setSearchNmCustom(lncusMemberInfo.getName());
                        brcSearchRequestVO.setSearchNoCustomFirst(lncusMemberInfo.getSsn11());
                        brcSearchRequestVO.setSearchNoCustomSecond(lncusMemberInfo.getSsn12());
                        brcSearchRequestVO.setSearchNoMobile1(lncusMemberInfo.getPh21()); // 핸드폰
                        brcSearchRequestVO.setSearchNoMobile2(lncusMemberInfo.getPh22());
                        brcSearchRequestVO.setSearchNoMobile3(lncusMemberInfo.getPh23());
                        brcSearchRequestVO.setSearchNoMobileSecond1(lncusMemberInfo.getPh81()); // 핸드폰2
                        brcSearchRequestVO.setSearchNoMobileSecond2(lncusMemberInfo.getPh82());
                        brcSearchRequestVO.setSearchNoMobileSecond3(lncusMemberInfo.getPh83());
                        brcSearchRequestVO.setSearchNoTel1(lncusMemberInfo.getPh11()); // 집전화
                        brcSearchRequestVO.setSearchNoTel2(lncusMemberInfo.getPh12());
                        brcSearchRequestVO.setSearchNoTel3(lncusMemberInfo.getPh13());
                        brcSearchRequestVO.setSearchNoComTel1(lncusMemberInfo.getPh61()); // 회사대표전화
                        brcSearchRequestVO.setSearchNoComTel2(lncusMemberInfo.getPh62());
                        brcSearchRequestVO.setSearchNoComTel3(lncusMemberInfo.getPh63());
                        brcSearchRequestVO.setSearchIP(lncusMemberInfo.getAppIP());
                    }
                }
            }
            modelAndView.addObject("lncusMemberInfo", lncusMemberInfo);//메모에 사용- 보증인은 SearchLincusKey 사용하면 안됨

            // 연계검사
            List<BrcSearchResponseVO> allList  = brcSearchService.getRelationSearchAll(brcSearchRequestVO);
            modelAndView.addObject("allList", allList);
            logger.debug("allList"+allList);
/*            // HP 해시 통합검색
            brcSearchRequestVO.setSearchNoMobileFull( brcSearchRequestVO.getSearchNoMobile1()+brcSearchRequestVO.getSearchNoMobile2()+brcSearchRequestVO.getSearchNoMobile3());
            List<BrcSearchResponseVO> hpList = null;
            if(brcSearchRequestVO.getSearchNoMobileFull().length() > 10){
                hpList = brcSearchService.getRelationHpSearch(brcSearchRequestVO);
            }
            modelAndView.addObject("hpList", hpList);
            
            // 주민번호 해시 통합검색
            brcSearchRequestVO.setSearchNoCustomFull( brcSearchRequestVO.getSearchNoCustomFirst()+brcSearchRequestVO.getSearchNoCustomSecond());
            List<BrcSearchResponseVO> juminHashList = null;
            if(brcSearchRequestVO.getSearchNoCustomFull().length() == 13){
               
                // 비로그인 접근이 있어 도메인 세션을 사용
                String cdCompany = CommonSessionUtil.getDomainCompany(request);
                logger.debug("@@@@@@@@@@@@cdCompany:"+cdCompany);
                brcSearchRequestVO.setCdCompany(cdCompany);
                juminHashList = brcSearchService.getRelationJuminSearch(brcSearchRequestVO);
            }
            modelAndView.addObject("juminHashList", juminHashList);*/
            
            // 통합해쉬
            brcSearchRequestVO.setSearchNoMobileFull( brcSearchRequestVO.getSearchNoMobile1()+brcSearchRequestVO.getSearchNoMobile2()+brcSearchRequestVO.getSearchNoMobile3());
            brcSearchRequestVO.setSearchNoCustomFull( brcSearchRequestVO.getSearchNoCustomFirst()+brcSearchRequestVO.getSearchNoCustomSecond());
            List<BrcSearchResponseVO> hashList = null;
            if(brcSearchRequestVO.getSearchNoCustomFull().length() == 13 || brcSearchRequestVO.getSearchNoMobileFull().length() > 10){
                brcSearchRequestVO.setSearchSsnHash(commonUtil.getEncryptSHA512(brcSearchRequestVO.getSearchNoCustomFull()));
                brcSearchRequestVO.setSearchHpHash(commonUtil.getEncryptSHA512(brcSearchRequestVO.getSearchNoMobileFull()));                
                hashList = brcSearchService.getRelationHashSearch(brcSearchRequestVO);
            }
            modelAndView.addObject("hashList", hashList);
            
            logger.debug("brcSearchRequestVO:"+brcSearchRequestVO);
            
            // 주의전화번호
            List<BrcSearchResponseVO> noticeList = null;
            noticeList = brcSearchService.getStNoticeTel(brcSearchRequestVO);        
            modelAndView.addObject("noticeList", noticeList);
        }
         
        modelAndView.addObject("requestVO", brcSearchRequestVO);
        modelAndView.setViewName("/brc/brcSearchPop.pop");
        return modelAndView;

    }
    
    /**
     * 접수메모/SMS 이력  비동기 호출 
     *
     * @param request
     * @param response
     */
    @RequestMapping("/brc/contact/select")
    public ModelAndView contactList(HttpServletRequest request, HttpServletResponse response,BrcContactRequestVO brcContactRequestVO) throws Exception {

        // 메모 리스트
        ModelAndView modelAndView = new ModelAndView();
       
        
        if("71201".equals(brcContactRequestVO.getCdContact())){ // 통화 
            // 메모이력 
            List<BrcContactResponseVO> contactList = brcContactService.getContactList(brcContactRequestVO);
            
            modelAndView.addObject("contactList", contactList);
            modelAndView.setViewName("/brc/brcLoanAjaxContactTel");
        }else if("71202".equals(brcContactRequestVO.getCdContact())){ // SMS
            
            // 고객정보조회
            BrcLoanRequestVO brcLoanRequestVO = new BrcLoanRequestVO();
            brcLoanRequestVO.setSearchNoReq(brcContactRequestVO.getSearchNoReq());
            BrcLoanInfoResponseVO loanInfo = brcLoanService.getBrcLoanInfo(brcLoanRequestVO);
          
            // 수신번호 
            List<BrcLoanInfoResponseVO>  rcvNumber = brcLoanService.getBrcLoanMobilePhone(brcLoanRequestVO);
            
            // 발송메세지  
            BrcSmsRequestVO brcSmsRequestVO = new BrcSmsRequestVO();
            brcSmsRequestVO.setSearchDiv("17501");
            List<BrcSmsResponseVO> smsMessage = brcSmsService.getSmsMessage(brcSmsRequestVO);
            
            // 발송번호 
            brcSmsRequestVO.setSearchRcvNo(commonBizService.getTeamCd()); // SMS 발신번호로 선택가능한 팀
            List<BrcSmsResponseVO> sendNumber = brcSmsService.getSendNumber(brcSmsRequestVO);
            
            // MMS수신을 위한 수신번호, 메세지no
            BrcSmsResponseVO mmsInfo = brcSmsService.getMmsInfo();
            
            // 발송이력 
            List<BrcContactResponseVO> contactList = brcContactService.getContactSmsList(brcContactRequestVO);
            
            modelAndView.addObject("loanInfo", loanInfo);  
            modelAndView.addObject("smsMessage", smsMessage);  
            modelAndView.addObject("rcvNumber", rcvNumber);  
            modelAndView.addObject("sendNumber", sendNumber);  
            modelAndView.addObject("contactList", contactList);
            modelAndView.addObject("mmsInfo", mmsInfo);
            modelAndView.setViewName("/brc/brcLoanAjaxContactSms");
        }
        return modelAndView;

    }

    /**
     * SMS 발송처리 
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/brc/contact/sendsms", method = RequestMethod.POST  , produces={"application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody HashMap<String, String>  contactSendSms(HttpServletRequest request, HttpServletResponse response,BrcSmsRequestVO brcSmsRequestVO,
            BrcContactRequestVO brcContactRequestVO) throws Exception {
        
        HashMap<String, String> result = new HashMap<String, String>();
        
        brcSmsRequestVO.setUsrId(commonBizService.getSmsUsrID());
        brcSmsRequestVO.setWorkerId(CommonSessionUtil.getIdUser());      
        logger.debug("brcSmsRequestVO.toString():"+brcSmsRequestVO.toString());        
        brcSmsService.sendSms(brcSmsRequestVO, brcContactRequestVO);        

        result.put("result", "success");
        
        //CommonUtil.sleepSeconds(2);
        return result;

    }
    
    /**
     * 린커스 메모이력 저장
     * 
     * @param request
     * @param response
     * @param brcContactRequestVO
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/brc/lincuscontact/insert", method = RequestMethod.POST  , produces={"application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody HashMap<String, String>  registLincsMemo(HttpServletRequest request, HttpServletResponse response, LincusCommunicationVO lincusCommunicationVO
            , BrcSearchRequestVO brcSearchRequestVO)
            throws Exception {

        HashMap<String, String> result = new HashMap<String, String>();
        try{            
            brcContactService.insertLincusCommunication(lincusCommunicationVO,brcSearchRequestVO);
            result.put("result", "success");
        }catch(Exception e){
            result.put("result", "fail");
            result.put("message", e.getMessage());
        }
        
        return result;
    }
    
    /**
     * 접수 메모이력 저장
     * 
     * @param request
     * @param response
     * @param brcContactRequestVO
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/brc/contact/insert", method = RequestMethod.POST  , produces={"application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody HashMap<String, String>  registMemo(HttpServletRequest request, HttpServletResponse response, BrcContactRequestVO brcContactRequestVO
            , BrcLoanRequestVO brcLoanRequestVO)
            throws Exception {
        brcContactService.insertContact(brcContactRequestVO);
        // 최종접촉이력 갱신
        
        brcContactService.updateContactDate(brcContactRequestVO.getNoReq());
        
        // 동의서 안내 메모인경우 
        if("stepup_71003".equals(brcContactRequestVO.getMemoStepFlag())){
            brcLoanRequestVO.setNoReq(brcContactRequestVO.getNoReq());
            brcLoanRequestVO.setCdStatus("71003");
            brcLoanService.updateCdStatus(brcLoanRequestVO);
        }
        HashMap<String, String> result = new HashMap<String, String>();

        result.put("result", "success");
        return result;
    }

    /**
     * 접수  메모이력  수정
     * 
     * @param request
     * @param response
     * @param brcContactRequestVO
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/brc/contact/update", method = RequestMethod.POST  , produces={"application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody HashMap<String, String>  modifyMemo(HttpServletRequest request, HttpServletResponse response, BrcContactRequestVO brcContactRequestVO)
            throws Exception {
        
        brcContactService.updateContact(brcContactRequestVO);
        logger.debug("@@@@@@@@brcContactRequestVO.getNoReq()"+brcContactRequestVO.getNoReq());
        // 최종접촉이력 갱신
        brcContactService.updateContactDate(brcContactRequestVO.getNoReq());
        HashMap<String, String> result = new HashMap<String, String>();

        result.put("result", "success");
        return result;
    }
    

    /**
     * 접수 메모이력 삭제
     * 
     * @param request
     * @param response
     * @param brcContactRequestVO
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/brc/contact/delete", method = RequestMethod.POST  , produces={"application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody HashMap<String, String>  removeMemo(HttpServletRequest request, HttpServletResponse response, BrcContactRequestVO brcContactRequestVO)
            throws Exception {
        brcContactService.deleteContact(brcContactRequestVO);
        HashMap<String, String> result = new HashMap<String, String>();

        result.put("result", "success");
        return result;
    }
    
    /**
     * 접수건실행
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */    
    @RequestMapping(value = "/bex/master/insert", method = RequestMethod.POST)
    public ModelAndView insertBexMaster(HttpServletRequest request, HttpServletResponse response, BexMasterRequestVO bexMasterRequestVO)
            throws Exception {
        logger.debug("Call BrcLoanController insertBexMaster...");
        bexMasterRequestVO.setIdReg(CommonSessionUtil.getIdUser());
        String callBack = bexMasterService.insertBex(bexMasterRequestVO);
        logger.debug("insertBexMaster callBack:"+callBack);
        if(callBack.substring(0,1).equals("S")) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("callBack", callBack);
        }else{
            //에러처리
        } 
   
        
        return new ModelAndView("redirect:/brc/loan/select?searchNoReq=" + bexMasterRequestVO.getNoReq());
    }     
}