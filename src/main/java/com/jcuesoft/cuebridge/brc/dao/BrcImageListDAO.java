package com.jcuesoft.cuebridge.brc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jcuesoft.cuebridge.brc.vo.BrcImageListRequestVO;
import com.jcuesoft.cuebridge.brc.vo.BrcImageListResponseVO;
import com.jcuesoft.cuebridge.common.dao.BaseDAO;

@Repository
public class BrcImageListDAO extends BaseDAO {
    /**
     * MAPPER_NAMESPACE
     */
    private static final String MAPPER_NAMESPACE = "com.jcuesoft.cuebridge.brc.dao.BrcImageListDAO";
    
    public BrcImageListDAO(){
        logger.debug("BrcImageListDAO.logger:" + logger.getName());
    }

    public List<BrcImageListResponseVO> getFaxList(BrcImageListRequestVO brcImageListRequestVO) throws Exception {
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getFaxList", brcImageListRequestVO);
    }
    
    public List<BrcImageListResponseVO> getMmsList(BrcImageListRequestVO brcImageListRequestVO) throws Exception {
        return sqlSession.selectList(MAPPER_NAMESPACE + ".getMmsList", brcImageListRequestVO);
    }
        

   
}