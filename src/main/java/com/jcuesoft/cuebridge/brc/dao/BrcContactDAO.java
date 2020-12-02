package com.jcuesoft.cuebridge.brc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jcuesoft.cuebridge.common.dao.BaseDAO;
import com.jcuesoft.cuebridge.common.vo.LincusCommunicationVO;
import com.jcuesoft.cuebridge.brc.vo.BrcContactRequestVO;
import com.jcuesoft.cuebridge.brc.vo.BrcContactResponseVO;

@Repository
public class BrcContactDAO extends BaseDAO {
    /**
     * MAPPER_NAMESPACE
     */
    private static final String MAPPER_NAMESPACE = "com.jcuesoft.cuebridge.brc.dao.contact";

  
    
    /**
     * getContactList
     * 
     * @param brcContactRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcContactResponseVO> getContactList(BrcContactRequestVO brcContactRequestVO) throws Exception {
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getContactList", brcContactRequestVO);
    }
    
    /**
     * getContactList
     * 
     * @param brcContactRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcContactResponseVO> getContactSmsList(BrcContactRequestVO brcContactRequestVO) throws Exception {
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getContactSmsList", brcContactRequestVO);
    }
    
    /**
     * 특정 접수번호의 이력만 추출 
     * 
     * @param brcContactRequestVO
     * @return
     * @throws Exception
     */
    public List<BrcContactResponseVO> getContactReqList(BrcContactRequestVO brcContactRequestVO) throws Exception {
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getContactReqList", brcContactRequestVO);
    }

    /**
     * getContactOne
     * 
     * @param brcContactRequestVO
     * @return
     * @throws Exception
     */
    public BrcContactResponseVO getContactOne(BrcContactRequestVO brcContactRequestVO) throws Exception {
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getContactOne", brcContactRequestVO);
    }
    
    /**
     * insertContact
     * 
     * @param brcContactRequestVO
     * @return
     * @throws Exception
     */
    public int insertLincusCommunication(LincusCommunicationVO lincusCommunicationVO) throws Exception {
        return sqlSession.insert(MAPPER_NAMESPACE + ".insertLincusCommunication", lincusCommunicationVO);
    }
    
    /**
     * insertContact
     * 
     * @param brcContactRequestVO
     * @return
     * @throws Exception
     */
    public int insertContact(BrcContactRequestVO brcContactRequestVO) throws Exception {
        return sqlSession.insert(MAPPER_NAMESPACE + ".insertContact", brcContactRequestVO);
    }
    
    /**
     * updateContactDate
     * 
     * @param brcContactRequestVO
     * @return
     * @throws Exception
     */
    public int updateContactDate(String noReq) throws Exception {
        return sqlSession.update(MAPPER_NAMESPACE + ".updateContactDate", noReq);
    }
    
    /**
     * update
     * 
     * @param brcContactRequestVO
     * @return
     * @throws Exception
     */
    public int updateContact(BrcContactRequestVO brcContactRequestVO) throws Exception {
        return sqlSession.update(MAPPER_NAMESPACE + ".updateContact", brcContactRequestVO);
    }

    /**
     * delete
     * 
     * @param brcContactRequestVO
     * @return
     * @throws Exception
     */
    public int deleteContact(BrcContactRequestVO brcContactRequestVO) throws Exception {
        return sqlSession.delete(MAPPER_NAMESPACE + ".deleteContact", brcContactRequestVO);
    }

    public List<BrcContactResponseVO> getContactListForTooltip(BrcContactRequestVO brcContactRequestVO) {
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getContactListForTooltip", brcContactRequestVO);
    }

   
}