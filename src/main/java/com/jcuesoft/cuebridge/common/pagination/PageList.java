package com.jcuesoft.cuebridge.common.pagination;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class PageList<E> extends ArrayList<E> implements Serializable {
    private static final long serialVersionUID = 1412759446332294208L;

    int limit = 10;
    int totalCount = 0;
    int page = 1;
    
    private Paginator paginator = new Paginator(limit, totalCount, page);

    public PageList() {
    }

    public PageList(Collection<? extends E> c) {
        super(c);
    }

    public PageList(Collection<? extends E> c, Paginator p) {
        super(c);
        this.paginator = p;
    }

    public PageList(Paginator p) {
        this.paginator = p;
    }

    /**
     * @return
     */
    public Paginator getPaginator() {
        return paginator;
    }

}
