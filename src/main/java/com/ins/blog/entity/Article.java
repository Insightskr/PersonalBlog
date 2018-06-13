package com.ins.blog.entity;

import java.util.Date;

public class Article {
    private Integer id;

    private String name;

    private Date commitDate;

    private String tag;

    private Date updateDate;

    private Integer authorId;

    private Victor author;

    private String context;

    public Article() {
    }

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
        this.name = name == null ? null : name.trim();
    }

    public Date getCommitDate() {
        return commitDate;
    }

    public void setCommitDate(Date commitDate) {
        this.commitDate = commitDate;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", commitDate=" + commitDate +
                ", tag='" + tag + '\'' +
                ", updateDate=" + updateDate +
                ", authorId=" + authorId +
                ", context='" + context + '\'' +
                '}';
    }

    public Victor getAuthor() {
        return author;
    }

    public void setAuthor(Victor author) {
        this.author = author;
    }
}