package com.together.news.entity;


import com.together.news.dto.ArticleDto;

import javax.persistence.*;
import java.lang.reflect.Field;

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

    /**
     * 从dto构造
     *
     * @param articleDto
     * @return
     */
    public Article constructFromDto(ArticleDto articleDto) {
        Class thisClass = this.getClass();
        Class dtoClass = articleDto.getClass();
        Field[] thisFields = thisClass.getDeclaredFields();
        for (Field field : thisFields) {
            try {
                Field dtoField;
                try {
                    dtoField = dtoClass.getDeclaredField(field.getName());
                } catch (NoSuchFieldException e) {
                    dtoField = null;
                }
                Object value = null;
                if (dtoField != null) {
                    boolean needToRest = !dtoField.isAccessible();
                    dtoField.setAccessible(true);
                    value = dtoField.get(articleDto);
                    if (needToRest) {
                        dtoField.setAccessible(false);
                    }
                }
                if (value != null) {
                    boolean needToRest = !field.isAccessible();
                    field.setAccessible(true);
                    field.set(this, value);
                    if (needToRest) {
                        field.setAccessible(false);
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
