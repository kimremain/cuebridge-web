package com.jcuesoft.cuebridge.common.pagination;

import java.util.Iterator;
import java.util.List;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class Page<VO extends BaseVO, PR extends PageRequest> extends BaseVO
        implements Iterable<VO> {

    private static final long serialVersionUID = 1L;

    private Integer rowCount;

    private List<VO> pageList;

    private boolean empty;

    private PR request;

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public List<VO> getPageList() {
        return pageList;
    }

    public void setPageList(List<VO> pageList) {
        this.pageList = pageList;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public PR getRequest() {
        return request;
    }

    public void setRequest(PR request) {
        this.request = request;
    }

    public Iterator<VO> iterator() {
        return pageList.iterator();
    }
}
