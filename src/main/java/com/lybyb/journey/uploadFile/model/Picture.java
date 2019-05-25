package com.lybyb.journey.uploadFile.model;

import java.io.Serializable;
import java.util.Date;
/**
 * 图片实体类
 * @author liyanbo
 */
public class Picture implements Serializable{
    private Long id;
    private Long userId;
    private String name;
    private String url;
    private String description;
    private Date createTime;
    private Date modifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Picture() {
    }

    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
