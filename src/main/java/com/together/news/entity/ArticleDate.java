package com.together.news.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.soap.Text;

/**
 * 文章详表
 *
 * @author feng yanli
 * @time 2016/11/11 10:02
 */
@Entity
@Table(name = "cms_article_date")
public class ArticleDate {
    //主键
    @Id
    private String id;

    //文章内容
    private Text content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Text getContent() {
        return content;
    }

    public void setContent(Text content) {
        this.content = content;
    }
}
