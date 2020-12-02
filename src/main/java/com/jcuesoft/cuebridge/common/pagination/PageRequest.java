package com.jcuesoft.cuebridge.common.pagination;

public class PageRequest {

    private static final long serialVersionUID = 1L;

    private static Integer DEFAULT_CURRENT_PAGE = 1;

    private static Integer DEFAULT_PAGE_PER_ROW = 10;

    private static Integer DEFAULT_ROW_COUNT = 0;

    private Integer currentPage = PageRequest.DEFAULT_CURRENT_PAGE;

    private Integer pagePerRow = PageRequest.DEFAULT_PAGE_PER_ROW;

    private Integer rowCount = PageRequest.DEFAULT_ROW_COUNT;

    private Integer startRow;

    private Integer endRow;

    // private List<>

    // private LIst<SearchVO searchVO> searchVO;

    /**
     * 
     * @param currentPage
     */
    public PageRequest(Integer currentPage) {
        this(currentPage, PageRequest.DEFAULT_PAGE_PER_ROW);
    }

    /**
     * 
     * @param currentPage
     * @param pagePerRow
     */
    private PageRequest(Integer currentPage, Integer pagePerRow) {
        setCurrentPage(currentPage);
        setPagePerRow(pagePerRow);

        setStartRow((currentPage - 1) * pagePerRow + 1);
        setEndRow(currentPage * pagePerRow);
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPagePerRow() {
        return pagePerRow;
    }

    public void setPagePerRow(Integer pagePerRow) {
        this.pagePerRow = pagePerRow;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public Integer getEndRow() {
        return endRow;
    }

    public void setEndRow(Integer endRow) {
        this.endRow = endRow;
    }

}
