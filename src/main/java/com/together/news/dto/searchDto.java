package com.together.news.dto;

/**
 * 查询条件
 *
 * @author feng yanli
 * @time 2016/12/9 22:04
 */

public class SearchDto {
    //栏目编号
    private String categoryId;

    //栏目名称
    private String name;

    //文章标题
    private String title;

    // 关键词（名称、编号、助记码）
    private String keyword;

    // 页码
    private Integer pageNo;

    // 页面大小
    private Integer pageSize;

    // 开始数据
    private Integer offset;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
