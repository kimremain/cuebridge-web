package com.jcuesoft.cuebridge.common.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcuesoft.cuebridge.bex.service.BexMasterService;
import com.jcuesoft.cuebridge.bex.vo.BexMasterRequestVO;
import com.jcuesoft.cuebridge.brc.vo.BrcLoanAllRequestVO;
import com.jcuesoft.cuebridge.brc.vo.BrcLoanRequestVO;
import com.jcuesoft.cuebridge.common.dao.CommonBizDAO;
import com.jcuesoft.cuebridge.common.module.CommonSessionUtil;
import com.jcuesoft.cuebridge.common.vo.CommonBizBrcInfoLegalVO;
import com.jcuesoft.cuebridge.common.vo.CommonBizBrcSupplyVO;
import com.jcuesoft.cuebridge.common.vo.CommonBizSafekeyOfferVO;
import com.jcuesoft.cuebridge.common.vo.CommonBizVO;
import com.jcuesoft.cuebridge.common.vo.UpsVO;

@Service
public class CommonBizService extends BaseService {
    /**
     * logger
     */
    /*private Logger logger = LoggerFactory.getLogger(this.getClass());*/
    /*final protected static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());*/
    
    /**
     * commonSearchDAO
     */
    @Autowired
    private CommonBizDAO commonBizDAO;
    
    @Autowired
    private BexMasterService bexMasterService;        
  
    
    /**
     * BRC_LOAN Table 접수일련번호조회(NO_REQ)
     * 
     * @return
     * @throws Exception
     */
    public String getBrcLoanNoReq() throws Exception {
        logger.debug("Call CommonBizService getBrcLoanNoReq...");
        
        String brcLoanNoReq = commonBizDAO.getBrcLoanNoReq();
        
        //접수일련번호 null 처리 (YYYYMMDD0001)
        if (brcLoanNoReq==null || brcLoanNoReq.isEmpty()) {
            StringBuffer sb = new StringBuffer();
            sb.append(getDbTime("YYYYMMDD"));
            sb.append("-0001");
            brcLoanNoReq = sb.toString();
        }
        
        return brcLoanNoReq;
    }
    
    /**
     * BRC_SURETY Table 보증인일련번호조회(NO_SURETY)
     * 
     * @return
     * @throws Exception
     */
    public String getBrcSuretyNoSurety(String noReq) throws Exception {
        logger.debug("Call CommonBizService getBrcSuretyNoSurety...");
        
        String brcSuretyNoSurety = commonBizDAO.getBrcSuretyNoSurety(noReq);
        logger.debug("brcSuretyNoSurety");
        //접수일련번호 null 처리 (YYYYMMDD0001)
        if (brcSuretyNoSurety==null || brcSuretyNoSurety.isEmpty()) {
            StringBuffer sb = new StringBuffer();
            sb.append("001");
            brcSuretyNoSurety = sb.toString();
        }
        logger.debug("brcSuretyNoSurety:"+brcSuretyNoSurety);
        return brcSuretyNoSurety;
    }    
    
    /**
     * DB 시간조회
     * 
     * @param dateFormat
     * @return
     * @throws Exception
     */
    public String getDbTime(String dateFormat) throws Exception {
        logger.debug("Call CommonBizService getDbTime...");
        
        //dateFormat default 처리 (YYYYMMDD)
        if (dateFormat==null || dateFormat.isEmpty()) {
            dateFormat = "YYYYMMDD";
        }
        return commonBizDAO.getDbTime(dateFormat);
    }
    
    /**
     * 거래처 기본이미지URL
     */
    public String getStCustomerDsImgUrl(String cd_cooperate) throws Exception {
        logger.debug("Call CommonBizService getStCustomerDsImgUrl...");
        return commonBizDAO.getStCustomerDsImgUrl(cd_cooperate);
    }    

    /**
     * BEX_MASTER Table 실행일련번호조회(NO_EX)
     * 
     * @return
     * @throws Exception
     */    
    public String getBexMasterNoEx(String noReq) throws Exception {
        logger.debug("Call CommonBizService getBexMasterNoEx...");
        
        String bexMasterNoEx = commonBizDAO.getBexMasterNoEx(noReq);
        if (bexMasterNoEx==null || bexMasterNoEx.isEmpty()) {
            StringBuffer sb = new StringBuffer();
            sb.append("001");
            bexMasterNoEx = sb.toString();
        }
        
        return bexMasterNoEx;
    }
    
    /**
     * BEX_MASTER Table 실행일련번호조회(NO_EX)
     * 
     * @return
     * @throws Exception
     */    
    public String getBexMasterNoEx(String noReq, EntityManager em) throws Exception {
        logger.debug("Call CommonBizService getBexMasterNoEx...");
        
        String bexMasterNoEx = commonBizDAO.getBexMasterNoEx(noReq,em);
        if (bexMasterNoEx==null || bexMasterNoEx.isEmpty()) {
            StringBuffer sb = new StringBuffer();
            sb.append("001");
            bexMasterNoEx = sb.toString();
        }
        
        return bexMasterNoEx;
    }    
    
    /**
     * UPS 비대면관리대장 생성
     * 
     * @return
     * @throws Exception
     * 
     * 거절처리시 noReq=BRC_LOAN.NO_REQ, ynBex="N", cdCooperateBex="", upsNo=""
     * 실행처리시 noReq=BRC_LOAN.NO_REQ, ynBex="Y", cdCooperateBex=실행거래처코드, upsNo=실행시채번한 UPS_NO
     */
    public String procUpsMeberListInoutTm(String noReq, String ynBex, String cdCooperateBex, String upsNo) throws Exception {
        logger.debug("Call CommonBizService procUpsMeberListInoutTm...");
        String callback = "Success";
        UpsVO upsVO = new UpsVO();

        upsVO = commonBizDAO.selectBrcLoanForUpsVO(noReq);
        String cntUps = commonBizDAO.selectMemberListInoutTm(upsVO);
        String ynSameCdCooperate; 
        upsVO.setIdReg(upsVO.getIdScreen());
        
        if(ynBex.equals("Y")){
            if(cdCooperateBex.equals(upsVO.getCdCooperate())){
                ynSameCdCooperate = "Y";
            }else{
                ynSameCdCooperate = "N";
            }            
            if(ynSameCdCooperate.equals("Y") && ynBex.equals("Y")){
                upsVO.setUpsNo(upsNo);
            }            
        }
        
        if(upsVO.getCdPath().equals("70404")){
            upsVO.setCdKind("52002");
            upsVO.setDtAgreeInfo(upsVO.getDtCbAgree());
        }else{
            upsVO.setCdKind("52001");
            upsVO.setDtAgreeInfo(upsVO.getDmReg());
        }
        
        if(cntUps.equals("1")){
            commonBizDAO.updateMemberListInoutTm(upsVO);
        }else{
            commonBizDAO.insertMemberListInoutTm(upsVO);
        }
        
        return callback;
    }    
    
    /**
     * SMS 발송문장조회 
     * 
     * @param BrcSmsRequestVO
     * @return
     * @throws Exception
     */ 
    public String getSmsMessage(CommonBizVO commonBizVO) throws Exception {
        return commonBizDAO.getSmsMessage(commonBizVO);
    }
    
    /**
     * 고객정보 
     * 
     * @param BrcSmsRequestVO
     * @return
     * @throws Exception
     */ 
    public CommonBizVO getCustomInfo(String brcLonaNoReq) throws Exception {
        return commonBizDAO.getCustomInfo(brcLonaNoReq);
    }
    
    /**
     * 개인팩스번호
     * 
     * @param BrcSmsRequestVO
     * @return
     * @throws Exception
     */ 
    public CommonBizVO getPersonalFax() throws Exception {
        return commonBizDAO.getPersonalFax(CommonSessionUtil.getIdUser());
    }
    
    /**
     * 법인별 대표 팀팩스번호
     * 
     * @return array
     * @throws Exception
     */ 
    public Map<String, String>  getTeamFax() throws Exception {
        //Map<String, String> faxList = new ValueComparableMap<String, String>(Ordering.natural());
        TreeMap<String, String> faxList = new TreeMap(Collections.reverseOrder());

        if(CommonSessionUtil.getFaxNo() != null && CommonSessionUtil.getFaxNo().trim().length() >= 1){
            faxList.put(CommonSessionUtil.getFaxNo(), "개인팩스("+CommonSessionUtil.getFaxNo()+")");
        }
        
        if("S".equals(CommonSessionUtil.getCdCompany())){
            faxList.put("05049815414", "접수1팀(050-4981-5414)");
            faxList.put("05048474933", "홈페이지팀(050-4847-4933)");
            faxList.put("05048474932", "콜센터(050-4847-4932)");
            faxList.put("05048474950", "신용1팀(050-4847-4950)");
        }else if("Y".equals(CommonSessionUtil.getCdCompany())){
            faxList.put("05048414969", "접수1팀(050-4841-4969)");
        }else if("M".equals(CommonSessionUtil.getCdCompany())){
            faxList.put("05048414974", "접수1팀(050-4847-4974)");
        }

        return faxList;
    }
    
    static <K, V extends Comparable<? super V>> List<Entry<K, V>> entriesSortedByValues(Map<K, V> map) {

        List<Entry<K, V>> sortedEntries = new ArrayList<Entry<K, V>>(map.entrySet());

        Collections.sort(sortedEntries, new Comparator<Entry<K, V>>() {
            @Override
            public int compare(Entry<K, V> e1, Entry<K, V> e2) {
                return e2.getValue().compareTo(e1.getValue());
            }
        });

        return sortedEntries;
    } 
    
    /**
     * 법인별  UPS 팀코드 
     * 
     * @return array
     * @throws Exception
     */ 
    public String[]  getTeamCd() throws Exception {
        
        String[] teamCd = new String[2];

        if("Y".equals(CommonSessionUtil.getCdCompany())){
            teamCd[0] =  "Y1";
            teamCd[1] =  "Y1004";
        }else if("S".equals(CommonSessionUtil.getCdCompany())){
            teamCd[0] =  "S1";
            teamCd[1] =  "S1010";
        }else if("M".equals(CommonSessionUtil.getCdCompany())){
            //teamCd[0] =  "M1";
            teamCd[0] =  "M1010";
        }
        return teamCd;
    }
    
    /**
     * 법인별  SMS아이디
     * 
     * @return array
     * @throws Exception
     */ 
    public String  getSmsUsrID() throws Exception {
        
        String usrID = "";

        if("Y".equals(CommonSessionUtil.getCdCompany())){
            usrID =  "4255";
        }else if("S".equals(CommonSessionUtil.getCdCompany())){
            usrID =  "4252";
        }else if("M".equals(CommonSessionUtil.getCdCompany())){
            usrID =  "4251";
        }
        return usrID;
    }    
    
    public int updateBatchBrcLoan(BrcLoanRequestVO brcLoanRequestVO) throws Exception {
        logger.debug("Call CommonBizService updateBatchBrcLoan...");
        // 거절일경우 비대면 저장
        if("71007".equals(brcLoanRequestVO.getUpdateCdStatus())){           
            String[] updateBatchNo =  brcLoanRequestVO.getUpdateBatchNo(); 
            for(int i = 0; i < updateBatchNo.length ; i++ ){
                procUpsMeberListInoutTm(updateBatchNo[i],"N","","");  
            }
        }        
        
        return commonBizDAO.updateBatchBrcLoan(brcLoanRequestVO);
    }
    
    public String excuteBatchBex(BrcLoanAllRequestVO brcLoanAllRequestVO) throws Exception {
        String infoMsg = "";
        logger.debug("Call CommonBizService excuteBatchBex...");
        logger.debug("brcLoanAllRequestVO:"+brcLoanAllRequestVO.toString());
        
        BexMasterRequestVO bexMasterRequestVO = new BexMasterRequestVO();
        bexMasterRequestVO.setCdCooperate(brcLoanAllRequestVO.getExcuteCdCooperate());
        bexMasterRequestVO.setIdReg(CommonSessionUtil.getIdUser());
        for(String noReq : brcLoanAllRequestVO.getUpdateBatchNo()){
            logger.debug(noReq);
            bexMasterRequestVO.setNoReq(noReq);
            infoMsg = infoMsg + "접수번호[" + noReq + "] 처리결과 : " + bexMasterService.insertBex(bexMasterRequestVO) + "\r\n";

            //String callBack = bexMasterService.insertBex(bexMasterRequestVO);
        }
        logger.debug("excuteBatchBex infoMsg:"+infoMsg);
        return infoMsg;
    }    
    
    public HashMap<String, String> setSmsMessage(CommonBizVO commonBizVO) throws Exception{
        HashMap<String, String> result = new HashMap<String, String>();
        
        if(!commonBizVO.getMessageKind().equals("sms")){
            result.put("result", "false");
            result.put("message", "메세지 생성중 오류가 발생했습니다.");
            return result;
        }
        
        logger.debug("getSmsMessage(commonBizVO):"+getSmsMessage(commonBizVO));
        String sourceMsg = getSmsMessage(commonBizVO);
        String destMsg = replaceSmsMessage(commonBizVO.getBrcLonaNoReq(), commonBizVO.getRcvName(), sourceMsg);
        logger.debug("destMsg:"+destMsg);
        result.put("result", "success");
        result.put("message", destMsg);
        logger.debug("치환메세지" + destMsg); 
        
        return result;
    }
    
    public String replaceSmsMessage(String noReq, String rcvName, String sourceMsg) throws Exception{
        String destMsg = sourceMsg;
        
        // 고객정보조회
        CommonBizVO   custInfo = getCustomInfo(noReq); 
        
        if(rcvName.equals("")){
            logger.debug("sourceMsg:"+sourceMsg);
            destMsg = destMsg.replace("[이름]",custInfo.getNmCustom());
            logger.debug("destMsg:"+destMsg);
        }else{
           // 파라미터로 넘긴 수신자명 사용 
            destMsg = destMsg.replace("[이름]",rcvName);
            logger.debug("destMsg:"+destMsg);
        }
        destMsg = destMsg.replace("[심사자]",custInfo.getNmScreen());
        logger.debug("destMsg:"+destMsg);
        destMsg = destMsg.replace("[발신자]",CommonSessionUtil.getNmUser());
        logger.debug("destMsg:"+destMsg);
        
        // 개인팩스번호 조회  
        CommonBizVO fax = getPersonalFax();
        destMsg = destMsg.replace("[개인팩스번호]", fax.getNoFax());
        logger.debug("destMsg:"+destMsg);
        
        return destMsg;
    }

    // 고객정보 적법수집
    public CommonBizBrcInfoLegalVO getBrcInfoLegal(String noReq)throws Exception{
        logger.debug("Call CommonBizService getBrcInfoLegal...");        
        CommonBizBrcInfoLegalVO commonBizBrcInfoLegalVO;         
        commonBizBrcInfoLegalVO = null;
        commonBizBrcInfoLegalVO = commonBizDAO.getBrcInfoLegal(noReq);
        
        return commonBizBrcInfoLegalVO;
    }
    
    // 고객정보 적법수집
    public List<CommonBizBrcSupplyVO> getBrcSupply(String noReq)throws Exception{
        logger.debug("Call CommonBizService getBrcSupply...");        
        List<CommonBizBrcSupplyVO> commonBizBrcSupplyVO;         
        commonBizBrcSupplyVO = null;
        commonBizBrcSupplyVO = commonBizDAO.getBrcSupply(noReq);
        
        return commonBizBrcSupplyVO;
    }    

    public CommonBizSafekeyOfferVO getSafekeyOffer(String noReq) throws Exception{
        logger.debug("Call CommonBizService CommonBizSafekeyOfferVO...");
        return commonBizDAO.getSafekeyOffer(noReq);
    }
    
    
}