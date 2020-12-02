package com.jcuesoft.cuebridge.brc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jcuesoft.cuebridge.brc.vo.BrcSmsRequestVO;
import com.jcuesoft.cuebridge.brc.vo.BrcSmsResponseVO;
import com.jcuesoft.cuebridge.common.dao.BaseDAO;

@Repository
public class BrcSmsDAO extends BaseDAO {
    /**
     * MAPPER_NAMESPACE
     */
    private static final String MAPPER_NAMESPACE = "com.jcuesoft.cuebridge.brc.dao.sms";
    
    /**
     * getSmsMessage
     * 
     * @param brcContactRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcSmsResponseVO> getSmsMessage(BrcSmsRequestVO brcSmsRequestVO) throws Exception {
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getSmsMessage", brcSmsRequestVO);
    }
    
    /**
     * getSmsMessage
     * 
     * @param brcContactRequestVO
     * @return
     * @throws Exception
     */
    public BrcSmsResponseVO getSmsMessageOne(BrcSmsRequestVO brcSmsRequestVO) throws Exception {
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getSmsMessageOne", brcSmsRequestVO);
    }
   
   
    /**
     * getSmsMessage
     * 
     * @param brcContactRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcSmsResponseVO> getSendNumber(BrcSmsRequestVO brcSmsRequestVO) throws Exception {
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getSendNumber", brcSmsRequestVO);
    }    
    
    public String getSmsSeq() throws Exception {
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getSmsSeq");
    }
    
    public String getMmsSeq() throws Exception {
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getMmsSeq");
    }    
    
    /**
     * insertSms
     * 
     * @param brcContactRequestVO
     * @return
     * @throws Exception
     */
    public int insertSms(BrcSmsRequestVO brcSmsRequestVO) throws Exception {
        return sqlSession.insert(MAPPER_NAMESPACE + ".insertSms", brcSmsRequestVO);
    }
    
    public int insertMms(BrcSmsRequestVO brcSmsRequestVO) throws Exception {
        return sqlSession.insert(MAPPER_NAMESPACE + ".insertMms", brcSmsRequestVO);
    }   
    
    /**
     * getMmsInfo
     * 
     * @param brcContactRequestVO
     * @return
     * @throws Exception
     */
    public BrcSmsResponseVO getMmsInfo() throws Exception {
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getMmsInfo");
    }

}