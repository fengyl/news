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

}
