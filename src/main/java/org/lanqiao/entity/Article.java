package org.lanqiao.entity;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Article {
    @Field(value = "Article_id")
    private Integer articleId;

    @Field(value = "user_id")
    private Integer userId;

    @Field(value = "id_best")
    private String idBest;

    @Field(value = "hot")
    private String hot;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Field(value = "article_time")
    private Date articleTime;

    @Field(value = "article_address")
    private String articleAddress;

    @Field(value = "article_local")
    private String articleLocal;

    @Field(value = "article_img")
    private String articleImg;

    @Field(value = "article_face")
    private String articleFace;

    @Field(value = "article_content")
    private String articleContent;

    @Field(value = "article_title")
    private String articleTitle;

    private Users users;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIdBest() {
        return idBest;
    }

    public void setIdBest(String idBest) {
        this.idBest = idBest == null ? null : idBest.trim();
    }

    public String getHot() {
        return hot;
    }

    public void setHot(String hot) {
        this.hot = hot == null ? null : hot.trim();
    }

    public Date getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(Date articleTime) {
        this.articleTime = articleTime;
    }

    public String getArticleAddress() {
        return articleAddress;
    }

    public void setArticleAddress(String articleAddress) {
        this.articleAddress = articleAddress == null ? null : articleAddress.trim();
    }

    public String getArticleLocal() {
        return articleLocal;
    }

    public void setArticleLocal(String articleLocal) {
        this.articleLocal = articleLocal == null ? null : articleLocal.trim();
    }

    public String getArticleImg() {
        return articleImg;
    }

    public void setArticleImg(String articleImg) {
        this.articleImg = articleImg == null ? null : articleImg.trim();
    }

    public String getArticleFace() {
        return articleFace;
    }

    public void setArticleFace(String articleFace) {
        this.articleFace = articleFace == null ? null : articleFace.trim();
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent == null ? null : articleContent.trim();
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }
}