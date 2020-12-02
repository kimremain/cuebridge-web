package com.jcuesoft.cuebridge.common.pagination;

import java.io.Serializable;

/**
 */
public class Paginator implements Serializable {
    private static final long serialVersionUID = -2429864663690465105L;

    private static final int DEFAULT_SLIDERS_COUNT = 7;

    // rowcount per page
    private int limit;

    // current page
    private int page;

    private int totalCount;

    public Paginator(int page, int limit, int totalCount) {
        super();
        this.limit = limit;
        this.totalCount = totalCount;
        this.page = computePageNo(page);
    }

    public int getPage() {
        return page;
    }

    public int getLimit() {
        return limit;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public boolean isFirstPage() {
        return page <= 1;
    }

    public boolean isLastPage() {
        return page >= getTotalPages();
    }

    public int getPrePage() {
        if (isHasPrePage()) {
            return page - 1;
        } else {
            return page;
        }
    }

    public int getNextPage() {
        if (isHasNextPage()) {
            return page + 1;
        } else {
            return page;
        }
    }

    public boolean isDisabledPage(int page) {
        return ((page < 1) || (page > getTotalPages()) || (page == this.page));
    }

    public boolean isHasPrePage() {
        return (page - 1 >= 1);
    }

    public boolean isHasNextPage() {
        return (page + 1 <= getTotalPages());
    }

    public int getStartRow() {
        if (getLimit() <= 0 || totalCount <= 0)
            return 0;
        return page > 0 ? (page - 1) * getLimit() + 1 : 0;
    }

    public int getEndRow() {
        return page > 0 ? Math.min(limit * page, getTotalCount()) : 0;
    }

    public int getOffset() {
        return page > 0 ? (page - 1) * getLimit() : 0;
    }

    public int getTotalPages() {
        if (totalCount <= 0) {
            return 0;
        }
        if (limit <= 0) {
            return 0;
        }

        int count = totalCount / limit;
        if (totalCount % limit > 0) {
            count++;
        }
        return count;
    }

    protected int computePageNo(int page) {
        return computePageNumber(page, limit, totalCount);
    }

    public Integer[] getSlider() {
        return slider(DEFAULT_SLIDERS_COUNT);
    }

    public Integer[] slider(int slidersCount) {
        return generateLinkPageNumbers(getPage(), (int) getTotalPages(),
                slidersCount);
    }

    private static int computeLastPageNumber(int totalItems, int pageSize) {
        if (pageSize <= 0)
            return 1;
        int result = (int) (totalItems % pageSize == 0 ? totalItems / pageSize
                : totalItems / pageSize + 1);
        if (result <= 1)
            result = 1;
        return result;
    }

    private static int computePageNumber(int page, int pageSize, int totalItems) {
        if (page <= 1) {
            return 1;
        }
        if (Integer.MAX_VALUE == page
                || page > computeLastPageNumber(totalItems, pageSize)) { // last
                                                                         // page
            return computeLastPageNumber(totalItems, pageSize);
        }
        return page;
    }

    private static Integer[] generateLinkPageNumbers(int currentPageNumber,
            int lastPageNumber, int count) {
        int avg = count / 2;

        int startPageNumber = currentPageNumber - avg;
        if (startPageNumber <= 0) {
            startPageNumber = 1;
        }

        int endPageNumber = startPageNumber + count - 1;
        if (endPageNumber > lastPageNumber) {
            endPageNumber = lastPageNumber;
        }

        if (endPageNumber - startPageNumber < count) {
            startPageNumber = endPageNumber - count;
            if (startPageNumber <= 0) {
                startPageNumber = 1;
            }
        }

        java.util.List<Integer> result = new java.util.ArrayList<Integer>();
        for (int i = startPageNumber; i <= endPageNumber; i++) {
            result.add(new Integer(i));
        }
        return result.toArray(new Integer[result.size()]);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Paginator");
        sb.append("{page=").append(page);
        sb.append(", limit=").append(limit);
        sb.append(", totalCount=").append(totalCount);
        sb.append('}');
        return sb.toString();
    }
}
