package com.jcuesoft.cuebridge.brc.ctrl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.jcuesoft.cuebridge.brc.service.BrcContactService;
import com.jcuesoft.cuebridge.brc.service.BrcLoanAllService;
import com.jcuesoft.cuebridge.brc.service.BrcMisscallService;
import com.jcuesoft.cuebridge.brc.vo.BrcContactRequestVO;
import com.jcuesoft.cuebridge.brc.vo.BrcContactResponseVO;
import com.jcuesoft.cuebridge.brc.vo.BrcLoanAllRequestVO;
import com.jcuesoft.cuebridge.brc.vo.BrcLoanAllResponseVO;
import com.jcuesoft.cuebridge.brc.vo.BrcLoanRequestVO;
import com.jcuesoft.cuebridge.brc.vo.BrcMisscallResponseVO;
import com.jcuesoft.cuebridge.common.module.CommonSessionUtil;
import com.jcuesoft.cuebridge.common.pagination.Order;
import com.jcuesoft.cuebridge.common.pagination.PageBounds;
import com.jcuesoft.cuebridge.common.pagination.PageList;
import com.jcuesoft.cuebridge.common.service.CommonBizService;
import com.jcuesoft.cuebridge.common.service.CommonCacheService;
import com.jcuesoft.cuebridge.web.ctrl.BaseController;

@Controller
public class BrcLoanAllController extends BaseController  {
    
    /**
     * brcLoanService
     */
    @Autowired
    private BrcLoanAllService brcLoanAllService;

    @Autowired
    private BrcContactService brcContactService;
    
    @Autowired
    private BrcMisscallService brcMisscallService;

    /**
     * commonSearchService
     */
    @Autowired
    private CommonCacheService commonCacheService;
    
    @Autowired
    private CommonBizService commonBizService;     

    
    /**
     * 전체 접수 리스트 BRC03
     *
     * @param request
     * @param response
     */
    @RequestMapping("/brc/loanall/select")
    public ModelAndView mainView(HttpServletRequest request, HttpServletResponse response,
            BrcContactRequestVO brcContactRequestVO,
            @ModelAttribute("brcLoanAllRequestVO") BrcLoanAllRequestVO brcLoanAllRequestVO,
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "25") int limit,
            @RequestParam(required = false, defaultValue = "DM_RECEIVE") String sort,
            @RequestParam(required = false, defaultValue = "DESC") String dir
            ) throws Exception {
        
        
        //DM_RECEIVE DESC 
        
        // 로그인 & 권한체크
        /*super.LoginCheck(request,response);*/
        
        ModelAndView modelAndView = new ModelAndView();
        
        // 코드조회 
        modelAndView.addObject("code131", commonCacheService.getStCodeList("131")); //취소사유
        modelAndView.addObject("code132", commonCacheService.getStCodeList("132")); //거절사유
        modelAndView.addObject("code710", commonCacheService.getStCodeList("710")); //접수상태
        modelAndView.addObject("code703", commonCacheService.getStCodeList("703")); //실행거래처
        modelAndView.addObject("code704", commonCacheService.getStCodeList("704")); //접수경로
        modelAndView.addObject("code719", commonCacheService.getStCodeListWithBlank("719")); //모집분류
        modelAndView.addObject("codeUser", commonCacheService.getStUserListScreen()); //사용자 코드
        
        // 미스콜 건수 
        BrcMisscallResponseVO misscall = brcMisscallService.getMisscallCount();
        modelAndView.addObject("misscall", misscall);
        
        // 접수리스트 
        PageBounds pageBounds = new PageBounds(page, limit);
        pageBounds.getOrders().add(Order.create(sort, dir));
        
        PageList<BrcLoanAllResponseVO> pageList = brcLoanAllService.getLoanAllPageList(brcLoanAllRequestVO,pageBounds);
        modelAndView.addObject("pageList", pageList);

        // 리스트 내  접수메모 이력조회
        if(brcLoanAllRequestVO.getSearchContactNoReq() != ""){
            brcContactRequestVO.setSearchContactNoReq(brcLoanAllRequestVO.getSearchContactNoReq().split(","));
            logger.debug("##### getSearchContactNoReq "+brcContactRequestVO.getSearchContactNoReq());
            List<BrcContactResponseVO> contactList = brcContactService.getContactReqList(brcContactRequestVO);
            modelAndView.addObject("contactList", contactList);
        }
        
        // 상태별 건수조회
        BrcLoanAllResponseVO statusCount = brcLoanAllService.getLoanStatusCount(brcLoanAllRequestVO);
        modelAndView.addObject("statusCount", statusCount);
        
        // 20분전 시간 
       /* Calendar cal = Calendar.getInstance();
        cal.add(cal.MINUTE, -20);
        Date sirenDate = new Date(cal.getTimeInMillis()); // Date(long date)
        modelAndView.addObject("sirenDate", sirenDate);*/
                
        modelAndView.addObject("requestVO", brcLoanAllRequestVO);
        modelAndView.setViewName("/brc/brcLoanAllV.tiles");
        return modelAndView;

    }
    
    
    /**
     * 접수상태/상담자 일괄변경 
     * 
     * @param request
     * @param response
     * @param stGroupCodeRequestVO
     * @return
     * @throws Exception
     
    @RequestMapping(value = "/brc/loanall/updatebatch", method = RequestMethod.POST)
    public ModelAndView modifyGroupCode(HttpServletRequest request, HttpServletResponse response, BrcLoanAllRequestVO brcLoanAllRequestVO)
            throws Exception {
        brcLoanAllService.updateBatch(brcLoanAllRequestVO);
        return new ModelAndView("redirect:/brc/loanall/select?searchCdStatus="+brcLoanAllRequestVO.getSearchCdStatus());
    }*/
    
    /**
     * 상담자 접수정보 수정
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */    
    @RequestMapping(value = "/brc/loanall/updatebatch", method = RequestMethod.POST  , produces={"application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody HashMap<String, String>  updateLoanAll(HttpServletRequest request, HttpServletResponse response, BrcLoanAllRequestVO brcLoanAllRequestVO, BrcLoanRequestVO brcLoanRequestVO)
            throws Exception {
        logger.debug("Call BrcLoanAllController updateLoanAll...");
        
        brcLoanRequestVO.setIdUpt(CommonSessionUtil.getIdUser());
        HashMap<String, String> result = new HashMap<String, String>();
        
        if(brcLoanAllRequestVO.getUpdateKind().equals("brc")){
            logger.debug("Call BrcLoanAllController updateLoanAll brc logic...");
            try{
                commonBizService.updateBatchBrcLoan(brcLoanRequestVO);
                result.put("result", "success");
            }catch(Exception e) {
                result.put("result", "fail");
                result.put("message",  e.getMessage());
            }
        }else if(brcLoanAllRequestVO.getUpdateKind().equals("bex")){
            logger.debug("Call BrcLoanAllController updateLoanAll bex logic...");
            
            String infoMsg = "";
            try{
                infoMsg = commonBizService.excuteBatchBex(brcLoanAllRequestVO);
                result.put("result", "success");
                result.put("message",  infoMsg);
            }catch(Exception e) {
                result.put("result", "fail");
                result.put("message",  e.getMessage());
            }            
        }

        return result;

    }
    
}