package cn.mjrj.myproject.utils;

import java.util.List;

public class Pager {
    //当前页
    private int page =1;
    //每页的记录数
    private int pageSize = 3;
    //总的记录数
    private long rows;
    //数据
    private List<Object> dates;
    //上一页
    private int prev;
    //下一页
    private int next;
    //是否首页
    private boolean first;
    //是否尾页
    private boolean last;
    //开始的记录
    private int beginRow;
    //总页数
    private int pages;

    public Pager() {
    }

    public Pager(int page, int pageSize) {
        setPage(page);
        setPageSize(pageSize);
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        if(page <= 1){
            page = 1;
        }
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if(pageSize < 1){
            pageSize = 3;
        }
        this.pageSize = pageSize;
    }

    public long getRows() {
        return rows;
    }

    public void setRows(long rows) {
        if (rows < 0){
            rows = 0;
        }
        this.rows = rows;

        pages =new Long( rows/pageSize).intValue();
        if (pages * pageSize <rows){
            pages = pages +1;
        }
        if (page >pages){
            page = pages;
        }
        setPage(page);
        beginRow = (page-1)*pageSize;
        if(page==1){
            first = true;
        }else {
            first = false;
        }
        if (page == pages){
            last = true;
        }else {
            last = false;
        }
        prev = page -1;
        if (prev<1){
            prev = 1;
        }

        next = page +1;
        if (next > pages){
            next = pages;
            if (next ==0){
                next = 1;
            }
        }
    }

    public List<Object> getDates() {
        return dates;
    }

    public void setDates(List<Object> dates) {this.dates = dates;}

    public int getPrev() {
        return prev;
    }

    public int getNext() {
        return next;
    }

    public boolean isFirst() {
        return first;
    }

    public boolean isLast() {
        return last;
    }

    public int getBeginRow() {
        return beginRow;
    }

    public int getPages() {
        return pages;
    }
}

