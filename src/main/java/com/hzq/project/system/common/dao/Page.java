package com.hzq.project.system.common.dao;

/**
 * Created by hzq on 16/9/19.
 */

import java.io.Serializable;

public class Page implements Serializable {
    public static final String ASC = "asc";
    public static final String DESC = "desc";
    protected int page = 1;
    protected int current = 1;
    protected int per = 20;
    protected String orderBy = null;
    protected String order = null;
    protected boolean autoCount = true;
    protected long count = -1L;
    private static int MAX_PER = 20;

    public Page() {
    }

    public Page(int per, int current) {
        this.per = per;
        this.current = current;
    }

    public Page(int per) {
        this.per = per;
    }

    public int getCurrent() {
        return this.current;
    }

    public void setCurrent(int current) {
        this.current = current;
        if(current < 1) {
            this.current = 1;
        }

        this.setPage(current);
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(int page) {
        this.page = page;
        if(page < 1) {
            this.page = 1;
        }

        this.current = page;
    }

    public Page current(int theCurrent) {
        this.setCurrent(theCurrent);
        return this;
    }

    public int getPer() {
        return this.per;
    }

    public void setPer(int per) {
        this.per = per;
    }

    public Page per(int thePer) {
        this.setPer(thePer);
        return this;
    }

    public int offset() {
        if(this.per <= 0) {
            throw new IllegalArgumentException("[per] must great than zero");
        } else {
            return (this.current - 1) * this.per;
        }
    }

    public boolean autoCount() {
        return this.autoCount;
    }

    public void disableAutoCount(boolean autoCount) {
        this.autoCount = autoCount;
    }

    public long getCount() {
        return this.count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getPages() {
        if(this.count < 0L) {
            return -1L;
        } else {
            long pageCount = this.count / (long)this.per;
            if(this.count % (long)this.per > 0L) {
                ++pageCount;
            }

            return pageCount;
        }
    }

    public int maxPer() {
        return MAX_PER;
    }

}
