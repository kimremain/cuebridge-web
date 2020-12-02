package com.jcuesoft.cuebridge.bex.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jcuesoft.cuebridge.bex.vo.BexToUpsVO;
import com.jcuesoft.cuebridge.brc.vo.BrcFileResponseVO;
import com.jcuesoft.cuebridge.brc.vo.BrcSuretyResponseVO;
import com.jcuesoft.cuebridge.common.dao.BaseDAO;

@Repository
public class BexToUpsDAO extends BaseDAO {
    
    private static final String MAPPER_NAMESPACE = "com.jcuesoft.cuebridge.bex.dao.BexToUpsDAO";
    
    public BexToUpsDAO(){
        logger.debug("BexToUpsDAO.logger:" + logger.getName());
    }

    public List<BrcFileResponseVO> getBrcFileList(BexToUpsVO bexToUpsVO) throws Exception{
        logger.debug("Call BexToUpsDAO getBrcFileList...");
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getBrcFileList", bexToUpsVO);
    }    
    
    public String getMemberListNoSeq(BexToUpsVO bexToUpsVO)  throws Exception{
        logger.debug("Call BexToUpsDAO getMemberListNoSeq...");
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getMemberListNoSeq", bexToUpsVO);
    }
    
    public String getStPdtIdPdtUid(BexToUpsVO bexToUpsVO)  throws Exception{
        logger.debug("Call BexToUpsDAO getStPdtIdPdtUid...");
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getStPdtIdPdtUid", bexToUpsVO);
    }
    
    public String getAddloanNoSeq(BexToUpsVO bexToUpsVO)  throws Exception{
        logger.debug("Call BexToUpsDAO getAddloanNoSeq...");
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getAddloanNoSeq", bexToUpsVO);
    }    

    public int insertMemberList(BexToUpsVO bexToUpsVO)  throws Exception{
        logger.debug("Call BexToUpsDAO insertMemberList...");
        return sqlSession.insert(MAPPER_NAMESPACE+ ".insertMemberList", bexToUpsVO);
    }

    public int insertMemberListExtra(BexToUpsVO bexToUpsVO)  throws Exception{
        logger.debug("Call BexToUpsDAO insertMemberListExtra...");
        return sqlSession.insert(MAPPER_NAMESPACE+ ".insertMemberListExtra", bexToUpsVO);
    }

    public int insertGuarantor(BexToUpsVO bexToUpsVO)  throws Exception{
        logger.debug("Call BexToUpsDAO insertGuarantor...");
        return sqlSession.insert(MAPPER_NAMESPACE+ ".insertGuarantor", bexToUpsVO);
    }

    public int insertGuarantorExtra(BexToUpsVO bexToUpsVO)  throws Exception{
        logger.debug("Call BexToUpsDAO insertGuarantorExtra...");
        return sqlSession.insert(MAPPER_NAMESPACE+ ".insertGuarantorExtra", bexToUpsVO);
    }

    public int insertCommunication(BexToUpsVO bexToUpsVO)  throws Exception{
        logger.debug("Call BexToUpsDAO insertCommunication...");
        return sqlSession.insert(MAPPER_NAMESPACE+ ".insertCommunication", bexToUpsVO);
    }

    public int insertLoanCertify(BexToUpsVO bexToUpsVO)  throws Exception{
        logger.debug("Call BexToUpsDAO insertLoanCertify...");
        return sqlSession.insert(MAPPER_NAMESPACE+ ".insertLoanCertify", bexToUpsVO);
    }

    public int insertDataImg(BexToUpsVO bexToUpsVO)  throws Exception{
        logger.debug("Call BexToUpsDAO insertDataImg...");
        return sqlSession.insert(MAPPER_NAMESPACE+ ".insertDataImg", bexToUpsVO);
    }

    public String getGuarantorNoSeq(BexToUpsVO bexToUpsVO)  throws Exception{
        logger.debug("Call BexToUpsDAO getGuarantorNoSeq...");
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getGuarantorNoSeq", bexToUpsVO);
    }

    public String getDataImgNoSeq(BexToUpsVO bexToUpsVO) throws Exception{
        logger.debug("Call BexToUpsDAO getDataImgNoSeq...");
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getDataImgNoSeq", bexToUpsVO);
    }
    
    public String getAgentLevelNoSeq(BexToUpsVO bexToUpsVO) throws Exception{
        logger.debug("Call BexToUpsDAO getAgentLevelNoSeq...");
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getAgentLevelNoSeq", bexToUpsVO);
    }    

    public List<BrcSuretyResponseVO> getSuretyList(BexToUpsVO bexToUpsVO) {
        logger.debug("Call BexToUpsDAO getSuretyList...");
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getSuretyList", bexToUpsVO);
    }

    public int insertAddloan(BexToUpsVO bexToUpsVO) {
        logger.debug("Call BexToUpsDAO insertAddloan...");
        return sqlSession.insert(MAPPER_NAMESPACE+ ".insertAddloan", bexToUpsVO);
    }
    
    public int insertAgentLevel(BexToUpsVO bexToUpsVO) {
        logger.debug("Call BexToUpsDAO insertAgentLevel...");
        return sqlSession.insert(MAPPER_NAMESPACE+ ".insertAgentLevel", bexToUpsVO);
    }    
    
    public String selectErpMemberListNo(BexToUpsVO bexToUpsVO) {
        logger.debug("Call BexToUpsDAO selectErpMemberListNo...");
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".selectErpMemberListNo", bexToUpsVO);
    }    

}
