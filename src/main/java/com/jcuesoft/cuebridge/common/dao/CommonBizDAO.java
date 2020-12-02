package com.jcuesoft.cuebridge.common.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jcuesoft.cuebridge.brc.vo.BrcLoanRequestVO;
import com.jcuesoft.cuebridge.common.vo.CommonBizBrcInfoLegalVO;
import com.jcuesoft.cuebridge.common.vo.CommonBizBrcSupplyVO;
import com.jcuesoft.cuebridge.common.vo.CommonBizSafekeyOfferVO;
import com.jcuesoft.cuebridge.common.vo.CommonBizVO;
import com.jcuesoft.cuebridge.common.vo.UpsVO;

@Repository
public class CommonBizDAO extends BaseDAO {
    /**
     * MAPPER_NAMESPACE
     */
    private static final String MAPPER_NAMESPACE = "com.jcuesoft.cuebridge.common.dao.CommonBizDAO";
    
    /**
     * BRC_LOAN Table 접수일련번호조회(NO_REQ)
     * 
     * @return
     * @throws Exception
     */
    public String getBrcLoanNoReq() throws Exception {
        logger.debug("Call CommonBizDAO getBrcLoanNoReq...");
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getBrcLoanNoReq");
    }
    
    /**
     * BRC_SURETY Table 보증인일련번호조회(NO_SURETY)
     * 
     * @return
     * @throws Exception
     */    
    public String getBrcSuretyNoSurety(String noReq) {
        logger.debug("Call CommonBizDAO getBrcSuretyNoSurety...");
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getBrcSuretyNoSurety", noReq);
    }    
    
    /**
     * DB 시간조회
     * 
     * @param dateFormat
     * @return
     * @throws Exception
     */
    public String getDbTime(String dateFormat) throws Exception {
        logger.debug("Call CommonBizDAO getDbTime...");
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getDbTime", dateFormat);
    }

    public String getBexMasterNoEx(String noReq) throws Exception  {
        logger.debug("Call CommonBizDAO getBexMasterNoEx...");
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getBexMasterNoEx", noReq);
    }
    
    public String getBexMasterNoEx(String noReq, EntityManager em) throws Exception  {
        logger.debug("Call CommonBizDAO getBexMasterNoEx...");
        String sql = "";
        Query q;        
        sql = "" + "\r\n" +
                "SELECT " + "\r\n" +
                "    LPAD(NO_EX+1, 3, '0')  AS NO_EX " + "\r\n" +
                "FROM " + "\r\n" +
                "    BEX_MASTER " + "\r\n" +
                "WHERE " + "\r\n" +
                "        NO_REQ = ?1 " + "\r\n" +
                "        AND " + "\r\n" +
                "    NO_EX = (SELECT MAX(NO_EX) FROM BEX_MASTER WHERE NO_REQ = ?1) " + "\r\n" +
                "FOR UPDATE     " + "\r\n" ;
        q= em.createNativeQuery(sql);
        q.setParameter(1, noReq);        
        String noEx = (String) commonJPAUtil.selectOneQuery(q);

        return noEx;
    }    
    
    /**
     * 비대면관리대장
     * 
     * @return
     * @throws Exception
     */    
    public UpsVO selectBrcLoanForUpsVO(String noReq) throws Exception{
        logger.debug("Call CommonBizDAO selectBrcLoanForUpsVO...");
        return sqlSession.selectOne(MAPPER_NAMESPACE+ ".selectBrcLoanForUpsVO", noReq);
    }
    
    public String selectMemberListInoutTm(UpsVO upsVO) throws Exception{
        logger.debug("Call CommonBizDAO selectMemberListInoutTm...");
        return sqlSession.selectOne(MAPPER_NAMESPACE+ ".selectMemberListInoutTm", upsVO);
    }
    
    public String selectYnSameCdCooperate(UpsVO upsVO) throws Exception{
        logger.debug("Call CommonBizDAO selectYnSameCdCooperate...");
        return sqlSession.selectOne(MAPPER_NAMESPACE+ ".selectYnSameCdCooperate", upsVO);
    }
    
    public int updateMemberListInoutTm(UpsVO upsVO) throws Exception{
        logger.debug("Call CommonBizDAO updateMemberListInoutTm...");
        return sqlSession.update(MAPPER_NAMESPACE+ ".updateMemberListInoutTm", upsVO);
    }
    
    public int insertMemberListInoutTm(UpsVO upsVO) throws Exception{
        logger.debug("Call CommonBizDAO insertMemberListInoutTm...");
        return sqlSession.update(MAPPER_NAMESPACE+ ".insertMemberListInoutTm", upsVO);
    }
    
    /**
     * getSmsMessage
     * 
     * @param commonBizVO
     * @return
     * @throws Exception
     */
    public String getSmsMessage(CommonBizVO commonBizVO) throws Exception {
        logger.debug("Call CommonBizDAO getSmsMessage...");
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getSmsMessage", commonBizVO);
    }
    
    /**
     * getCustomInfo
     * 
     * @param commonBizVO
     * @return
     * @throws Exception
     */
    public CommonBizVO getCustomInfo(String brcLonaNoReq) throws Exception {
        logger.debug("Call CommonBizDAO getCustomInfo...");
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getCustomInfo", brcLonaNoReq);
    }
    
    /**
     * getSmsMessage
     * 
     * @param commonBizVO
     * @return
     * @throws Exception
     */
    public CommonBizVO getPersonalFax(String idScreen) throws Exception {
        logger.debug("Call CommonBizDAO getPersonalFax...");
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getPersonalFax", idScreen);
    }

    
    public int updateBatchBrcLoan(BrcLoanRequestVO brcLoanRequestVO) {
        logger.debug("Call CommonBizDAO updateBatchBrcLoan...");
        return sqlSession.update(MAPPER_NAMESPACE + ".updateBatchBrcLoan", brcLoanRequestVO);
    }

    public String getStCustomerDsImgUrl(String cd_cooperate) {
        logger.debug("Call CommonBizDAO getStCustomerDsImgUrl...");
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getStCustomerDsImgUrl", cd_cooperate);
    }

    public CommonBizBrcInfoLegalVO getBrcInfoLegal(String noReq) {
        logger.debug("Call CommonBizDAO getBrcInfoLegal...");
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getBrcInfoLegal", noReq);
    }
    
    public List<CommonBizBrcSupplyVO> getBrcSupply(String noReq) {
        logger.debug("Call CommonBizDAO getBrcSupply...");
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getBrcSupply", noReq);
    }

    public CommonBizSafekeyOfferVO getSafekeyOffer(String noReq) {
        logger.debug("Call CommonBizDAO getSafekeyOffer...");
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getSafekeyOffer", noReq);
    }
   

}