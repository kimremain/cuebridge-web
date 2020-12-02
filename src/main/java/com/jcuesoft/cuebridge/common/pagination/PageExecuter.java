package com.jcuesoft.cuebridge.common.pagination;

import java.util.List;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public interface PageExecuter<VO extends BaseVO, PR extends PageRequest> {

    Integer getRowCount(PR pageRequest);

    List<VO> getPageList(PR pageRequest);
}
