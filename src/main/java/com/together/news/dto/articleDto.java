package com.together.news.dto;

/**
 * @author feng yanli
 * @time 2016/12/18 19:17
 */

public class ArticleDto {

    //文章id
    private String id;

    //栏目编号
    private String categoryId;

    //栏目名称
    private String name;

    //文章标题
    private String title;

    //文章内容
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
