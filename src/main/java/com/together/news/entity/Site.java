package com.together.news.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 站点实体
 *
 * @author feng yanli
 * @time 2016/11/4 15:27
 */
@Table(name = "t_site")
@Entity
public class Site {
    //主键
    @Id
    private Integer id;

    //站点名称
    private String name;

    //站点标题
    private String title;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
