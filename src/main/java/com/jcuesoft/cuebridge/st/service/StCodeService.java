package com.jcuesoft.cuebridge.st.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcuesoft.cuebridge.common.module.CommonSessionUtil;
import com.jcuesoft.cuebridge.common.service.BaseService;
import com.jcuesoft.cuebridge.st.dao.StCodeDAO;
import com.jcuesoft.cuebridge.st.vo.StCodeRequestVO;
import com.jcuesoft.cuebridge.st.vo.StCodeResponseVO;

@Service
public class StCodeService extends BaseService {
    /**
     * stCodeDAO
     */
    @Autowired
    private StCodeDAO stCodeDAO;

    /**
     * getCodeList
     * 
     * @param StCodeRequestVO
     * @return
     * @throws Exception
     */
    public List<StCodeResponseVO> getCodeList(StCodeRequestVO stCodeRequestVO) throws Exception {
        return stCodeDAO.getCodeList(stCodeRequestVO);
    }

    /**
     * getCodeOne
     * 
     * @param StCodeRequestVO
     * @return
     * @throws Exception
     */
    public StCodeResponseVO getCodeOne(StCodeRequestVO stCodeRequestVO) throws Exception {
        return stCodeDAO.getCodeOne(stCodeRequestVO);
    }
    

    /**
     * insert
     * 
     * @param StCodeRequestVO
     * @return
     * @throws Exception
     */
    public int insertCode(StCodeRequestVO stCodeRequestVO) throws Exception {
        stCodeRequestVO.setIdReg(CommonSessionUtil.getIdUser());
        
        StCodeResponseVO codeRow = this.getCodeOne(stCodeRequestVO);
        if(codeRow == null){
            return stCodeDAO.insertCode(stCodeRequestVO);
        }else{
            throw new Exception("이미 존재하는 코드 입니다. ");
        }
        
    }

    /**
     * updateCode
     * 
     * @param stCodeRequestVO
     * @return
     * @throws Exception
     */
    public int updateCode(StCodeRequestVO stCodeRequestVO) throws Exception {
        stCodeRequestVO.setIdUpt(CommonSessionUtil.getIdUser());
        return stCodeDAO.updateCode(stCodeRequestVO);
    }

    /**
     * updateCodeOrder
     * 
     * @param stCodeRequestVO
     * @return
     * @throws Exception
     */
    public int updateCodeOrder(StCodeRequestVO stCodeRequestVO) throws Exception {
        stCodeRequestVO.setIdUpt(CommonSessionUtil.getIdUser());
        
        String[] codeNoArr =  stCodeRequestVO.getChangeOrderCodeNo(); 
        String[] orderNumArr =  stCodeRequestVO.getChangeOrderNum();

        for(int i=0 ; i < codeNoArr.length ; i++){
            stCodeRequestVO.setQryChangeOrderNum(orderNumArr[i]);   //변경순서 
            stCodeRequestVO.setQryChangeOrderCodeNo(codeNoArr[i]); // 변경할 코드번호 -where 
            stCodeDAO.updateCodeOrder(stCodeRequestVO);
        }
        return 1;
    }

    /**
     * delete
     * 
     * @param stCodeRequestVO
     * @return
     * @throws Exception
     */
    public int deleteCode(StCodeRequestVO stCodeRequestVO) throws Exception {
        return stCodeDAO.deleteCode(stCodeRequestVO);
    }
}