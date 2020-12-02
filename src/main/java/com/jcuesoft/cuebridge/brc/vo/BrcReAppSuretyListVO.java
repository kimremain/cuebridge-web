package com.jcuesoft.cuebridge.brc.vo;

import java.math.BigDecimal;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class BrcReAppSuretyListVO extends BaseVO{

    /**
     * 
     */
    private static final long serialVersionUID = 554011382107643893L;
    
    private BigDecimal no;
    
    private String noReq;
    
    private String noSurety;

    public BigDecimal getNo() {
        return no;
    }

    public void setNo(BigDecimal no) {
        this.no = no;
    }

    public String getNoReq() {
        return noReq;
    }

    public void setNoReq(String noReq) {
        this.noReq = noReq;
    }

    public String getNoSurety() {
        return noSurety;
    }

    public void setNoSurety(String noSurety) {
        this.noSurety = noSurety;
    }
    
}
    