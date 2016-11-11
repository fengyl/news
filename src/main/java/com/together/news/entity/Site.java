package com.together.news.entity;

import javafx.scene.text.Text;

import javax.management.loading.PrivateClassLoader;
import javax.persistence.Column;
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

    private String logo;

    private String domain;

    private String description;

    private String keywords;

    private String theme;

    private Text copyright;

    @Column(name = "custom_index_view")
    private String customIndexView;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "create_date")
    private String createDate;

    @Column(name = "update_by")
    private String updateBy;

    @Column(name = "update_date")
    private String updateDate;

    private String remarks;

    @Column(name = "del_flag")
    private String delFlag;

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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Text getCopyright() {
        return copyright;
    }

    public void setCopyright(Text copyright) {
        this.copyright = copyright;
    }

    public String getCustomIndexView() {
        return customIndexView;
    }

    public void setCustomIndexView(String customIndexView) {
        this.customIndexView = customIndexView;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
