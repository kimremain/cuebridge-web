package com.jcuesoft.cuebridge.bex.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jcuesoft.cuebridge.bex.vo.BexMasterRequestVO;
import com.jcuesoft.cuebridge.bex.vo.BexMasterResponseVO;
import com.jcuesoft.cuebridge.common.dao.BaseDAO;

@Repository
public class BexMasterDAO extends BaseDAO {
    /**
     * MAPPER_NAMESPACE
     */
    private static final String MAPPER_NAMESPACE = "com.jcuesoft.cuebridge.bex.dao.BexMasterDAO";

    public BexMasterDAO(){
        logger.debug("BexMasterDAO.logger:" + logger.getName());
    }

    /**
     * getExListAll
     * 
     * @param bexMasterRequestVO
     * @return
     * @throws Exception
     */
    public List<BexMasterResponseVO> getExListAll(BexMasterRequestVO bexMasterRequestVO) throws Exception {
        logger.debug("Call BexMasterDAO getExListAll...");
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getExListAll", bexMasterRequestVO);
    }

    public int insertBexMaster(BexMasterRequestVO bexMasterRequestVO) throws Exception {
        logger.debug("Call BexMasterDAO insertBexMaster...");
        return sqlSession.insert(MAPPER_NAMESPACE+ ".insertBexMaster", bexMasterRequestVO);
    }

    public int insertBexContact(BexMasterRequestVO bexMasterRequestVO) throws Exception {
        logger.debug("Call BexMasterDAO insertBexContact...");
        return sqlSession.insert(MAPPER_NAMESPACE+ ".insertBexContact", bexMasterRequestVO);
    }
    
    public int insertBexMaster(BexMasterRequestVO bexMasterRequestVO, EntityManager em) throws Exception {
        logger.debug("Call BexMasterDAO insertBexMaster...");
        String sql = "";
        Query q;
        
        sql = "" + "\r\n" +
                "INSERT INTO BEX_MASTER  " + "\r\n" +
                "( " + "\r\n" +
                "    NO,  " + "\r\n" +
                "    NO_REQ,  " + "\r\n" +
                "    NO_EX,  " + "\r\n" +
                "    CD_COOPERATE,  " + "\r\n" +
                "    NO_COOPERATE,  " + "\r\n" +
                "    NO_COOPERATE_ACT,  " + "\r\n" +
                "    NM_SCREEN_PATH,  " + "\r\n" +
                "    DM_COOPERATE,  " + "\r\n" +
                "    AM_COOPERATE,  " + "\r\n" +
                "    DS_COOPERATE,  " + "\r\n" +
                "    NM_SCREEN,  " + "\r\n" +
                "    AM_APP,  " + "\r\n" +
                "    CD_PDT,  " + "\r\n" +
                "    DM_REG,  " + "\r\n" +
                "    ID_REG " + "\r\n" +
                ") " + "\r\n" +
                "VALUES  " + "\r\n" +
                "( " + "\r\n" +
                "    BEX_MASTER_SEQ.NEXTVAL,  " + "\r\n" +
                "    ?1,  " + "\r\n" +                                          // #{noReq,jdbcType=VARCHAR}
                "    ?2, " + "\r\n" +                                           // #{noEx,jdbcType=VARCHAR}
                "    ?3,  " + "\r\n" +                                          // #{cdCooperate,jdbcType=VARCHAR}
                "    ?1 || '-' || ?2 ,   " + "\r\n" +                           // #{noReq,jdbcType=VARCHAR} || '-' || #{noEx,jdbcType=VARCHAR}
                "    NVL(?4, ' '),  " + "\r\n" +                                          // NVL(#{noCooperateAct,jdbcType=VARCHAR}, ' ')
                "    NVL(?5, ' '),  " + "\r\n" +                                          // NVL(#{nmScreenPath,jdbcType=VARCHAR}, ' ')
                "    ?6,  " + "\r\n" +                                          // NVL(#{dmCooperate,jdbcType=VARCHAR}, NULL)
                "    NVL(?7, 0),  " + "\r\n" +                                          // NVL(#{amCooperate,jdbcType=DECIMAL}, '0')
                "    NVL(?8, '최초실행 by system') ,  " + "\r\n" +                                          // '최초실행 by system'
                "    NVL(?9, '접수'), " + "\r\n" +                                           // '접수'
                "    (SELECT AM_CUSTOM FROM BRC_LOAN WHERE NO_REQ = ?1),  " + "\r\n" +          // #{noReq,jdbcType=VARCHAR}
                "    NVL(?10, ' '),  " + "\r\n" +                                         // NVL(#{cdPdt,jdbcType=VARCHAR}, ' ')
                "    SYSDATE,  " + "\r\n" +
                "    NVL(?11, ' ') " + "\r\n" +                                           // NVL(#{idReg,jdbcType=VARCHAR}, ' ')
                ") " + "\r\n" ;
        q= em.createNativeQuery(sql);
        q.setParameter(1, bexMasterRequestVO.getNoReq());
        q.setParameter(2, bexMasterRequestVO.getNoEx());
        q.setParameter(3, bexMasterRequestVO.getCdCooperate());
        q.setParameter(4, bexMasterRequestVO.getNoCooperateAct());
        q.setParameter(5, bexMasterRequestVO.getNmScreenPath());
        q.setParameter(6, bexMasterRequestVO.getDmCooperate());
        q.setParameter(7, bexMasterRequestVO.getAmCooperate());
        q.setParameter(8, bexMasterRequestVO.getDsCooperate());
        q.setParameter(9, bexMasterRequestVO.getNmScreen());
        q.setParameter(10, bexMasterRequestVO.getCdPdt());
        q.setParameter(11, bexMasterRequestVO.getIdReg());
        
        return commonJPAUtil.insertQuery(q);
    }

    public int insertBexContact(BexMasterRequestVO bexMasterRequestVO, EntityManager em) throws Exception {
        logger.debug("Call BexMasterDAO insertBexContact...");
        String sql = "";
        Query q;
        
        sql = "" + "\r\n" +
                "INSERT INTO BEX_CONTACT                                                                                  " + "\r\n" +
                "( " + "\r\n" +
                "    NO            , " + "\r\n" +
                "    NO_REQ        , " + "\r\n" +
                "    NO_EX         , " + "\r\n" +
                "    NO_CONTACT_SEQ, " + "\r\n" +
                "    DS_COOPERATE  , " + "\r\n" +
                "    NM_SCREEN  ,             " + "\r\n" +
                "    DM_REG        , " + "\r\n" +
                "    ID_REG         " + "\r\n" +
                ") " + "\r\n" +
                "VALUES " + "\r\n" +
                "( " + "\r\n" +
                "    BEX_CONTACT_SEQ.NEXTVAL            , " + "\r\n" +
                "    ?1        , " + "\r\n" +                                                           // #{noReq,jdbcType=VARCHAR}
                "    ?2         , " + "\r\n" +                                                          // #{noEx,jdbcType=VARCHAR}
                "    (SELECT LPAD(NVL(MAX(NO_CONTACT_SEQ), '0')+1, 3, '0') " + "\r\n" +
                "    FROM BEX_CONTACT " + "\r\n" +
                "    WHERE NO_REQ = ?1 AND NO_EX = ?2) ,  " + "\r\n" +                  // #{noReq,jdbcType=VARCHAR} #{noEx,jdbcType=VARCHAR}
                "    SUBSTRB(NVL(?8, ' '), 1, 200)         , " + "\r\n" +                       // #{dsCooperate,jdbcType=VARCHAR}
                "    NVL(?9, ' ')         , " + "\r\n" +                                                // #{nmScreen,jdbcType=VARCHAR}
                "    SYSDATE        , " + "\r\n" +
                "    NVL(?11, ' ') " + "\r\n" +                                                          // #{idReg,jdbcType=VARCHAR}
                ") " + "\r\n" ;
        q= em.createNativeQuery(sql);
        q.setParameter(1, bexMasterRequestVO.getNoReq());
        q.setParameter(2, bexMasterRequestVO.getNoEx());
        q.setParameter(8, bexMasterRequestVO.getDsCooperate());
        q.setParameter(9, bexMasterRequestVO.getNmScreen());
        q.setParameter(11, bexMasterRequestVO.getIdReg());        
        
        return commonJPAUtil.insertQuery(q);
    }    

    public List<BexMasterResponseVO> getBexMasterList(BexMasterRequestVO bexMasterRequestVO) throws Exception{
        logger.debug("Call BexMasterDAO getBexMasterList...");
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getBexMasterList", bexMasterRequestVO);
    }

    public int updateBexMaster(BexMasterRequestVO bexMasterRequestVO) {
        logger.debug("Call BexMasterDAO updateBexMaster...");
        return sqlSession.update(MAPPER_NAMESPACE+ ".updateBexMaster", bexMasterRequestVO);
    }

    public BexMasterResponseVO getBexMasterOne(BexMasterRequestVO bexMasterRequestVO) {
        logger.debug("Call BexMasterDAO getBexMasterOne...");
        return sqlSession.selectOne(MAPPER_NAMESPACE + ".getBexMasterOne", bexMasterRequestVO);
    }
}