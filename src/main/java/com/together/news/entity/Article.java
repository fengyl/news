package com.together.news.entity;


import javax.persistence.*;
import java.util.Date;

/**
 *文章实体
 *
 * @author feng yanli
 * @time 2016/11/11 9:52
 */
@Entity
@Table(name = "cms_article")
public class Article {

    //主键
    @Id
    private String id;

    //栏目编号
    @Column(name = "category_id")
    private String categoryId;

    //标题
    private String title;

    //文章内容
    private String content;

    // 栏目名称
    @Transient
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
