package org.lanqiao.entity;

import java.util.Date;

public class Work {
    private Integer workId;

    private Integer userId;

    private String workTitle;

    private String workDetaile;

    private String workTheme;

    private String copyright;

    private String workTag;

    private Date workTime;

    private Integer workHot;

    private String workCover;

    private Users users;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getWorkTitle() {
        return workTitle;
    }

    public void setWorkTitle(String workTitle) {
        this.workTitle = workTitle == null ? null : workTitle.trim();
    }

    public String getWorkDetaile() {
        return workDetaile;
    }

    public void setWorkDetaile(String workDetaile) {
        this.workDetaile = workDetaile == null ? null : workDetaile.trim();
    }

    public String getWorkTheme() {
        return workTheme;
    }

    public void setWorkTheme(String workTheme) {
        this.workTheme = workTheme == null ? null : workTheme.trim();
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright == null ? null : copyright.trim();
    }

    public String getWorkTag() {
        return workTag;
    }

    public void setWorkTag(String workTag) {
        this.workTag = workTag == null ? null : workTag.trim();
    }

    public Date getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Date workTime) {
        this.workTime = workTime;
    }

    public Integer getWorkHot() {
        return workHot;
    }

    public void setWorkHot(Integer workHot) {
        this.workHot = workHot;
    }

    public String getWorkCover() {
        return workCover;
    }

    public void setWorkCover(String workCover) {
        this.workCover = workCover == null ? null : workCover.trim();
    }
}