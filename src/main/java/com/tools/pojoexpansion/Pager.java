package com.tools.pojoexpansion;

import java.util.List;

/**
 * @author lk
 * 2018/12/31 12:24
 */
public class Pager<T> {

    /**
     * 数据总数
     */
    private Integer totalNum;

    /**
     * 总页数
     */
    private Integer totalPage;

    /**
     * 每页数据量大小
     */
    private Integer pageSize;

    /**
     * 当前页
     */
    private Integer currentPage;

    /**
     * 页面数据
     */
    private List<T> dateList;

    /**
     * 当前数据位置 = 当前页 * 每页数据量大小
     */
    private Integer currentPosition;

    /**
     * 是否存在下一页
     */
    private Boolean hasNextPage;

    public Pager(Integer pageSize, Integer currentPage, Integer totalNum) {
        setPageSize(pageSize);
        setCurrentPage(currentPage);
        setTotalNum(totalNum);
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage() {
        if (totalNum % pageSize == 0) {
            this.totalPage = totalNum / pageSize;
        } else {
            this.totalPage = totalNum / pageSize + 1;
        }
        setHasNextPage();
    }

    public void setCurrentPosition(Integer currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Boolean getHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage() {
        if (totalPage > currentPage + 1) {
            this.hasNextPage = true;
        } else {
            this.hasNextPage = false;
        }
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
        setTotalPage();
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
        setCurrentPosition();
    }

    public List<T> getDateList() {
        return dateList;
    }

    public void setDateList(List<T> dateList) {
        this.dateList = dateList;
    }

    public Integer getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition() {
        this.currentPosition = currentPage * pageSize;
    }
}
