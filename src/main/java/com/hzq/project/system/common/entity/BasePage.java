package com.hzq.project.system.common.entity;

/**
 * Created by hzq on 16/9/27.
 */
public class BasePage {

    private Integer start;
    private Integer per = 20;
    private Integer current;

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getPer() {
        return per;
    }

    public void setPer(Integer per) {
        this.per = per;
        if (current == null) current = 1;
        setStart((current - 1) * per);
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }


    public final void setPage(Integer page) {
        if (page == null) page = 1;
        setPer(per);
        setStart((page - 1) * per);
        setCurrent(page);
    }
}
