package com.jcuesoft.cuebridge.common.pagination;

import java.util.Collections;
import java.util.List;

import com.jcuesoft.cuebridge.common.vo.BaseVO;

public class PageTemplate {

    /*
     * execute query for pagination set
     */
    public static <VO extends BaseVO, PR extends PageRequest> Page<VO, PR> execute(
            PR request, PageExecuter<VO, PR> pageExecuter) {

        // total count
        Integer rowCount = pageExecuter.getRowCount(request);
        request.setRowCount(rowCount);

        if (rowCount == null || 1 > rowCount) {
            return emptyPage(request);

        } else {
            // page per row
            // calculate maxpage
            int maxPage = (int) Math.ceil((double) request.getRowCount()
                    / request.getPagePerRow());

            // set request.curent page
            if (request.getCurrentPage() > maxPage) {
                request.setCurrentPage(maxPage);
            }

            // set request.start row
            request.setStartRow((request.getPagePerRow() * request
                    .getCurrentPage()) - request.getPagePerRow());

            request.setEndRow(request.getStartRow() + request.getPagePerRow());

            // set pagelist
            List<VO> pageList = pageExecuter.getPageList(request);

            Page<VO, PR> page = new Page<VO, PR>();

            page.setRequest(request);

            page.setRowCount(rowCount);

            page.setPageList(pageList);

            page.setEmpty(Boolean.FALSE);

            return page;
        }
    }

    /*
     * emptyPage
     */
    public static final <VO extends BaseVO, PR extends PageRequest> Page<VO, PR> emptyPage(
            PR request) {
        Page<VO, PR> emptyPage = new Page<VO, PR>();

        emptyPage.setEmpty(Boolean.TRUE);

        emptyPage.setRequest(request);

        emptyPage.setPageList(Collections.<VO> emptyList());

        return emptyPage;
    }

}
