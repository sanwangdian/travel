package org.lanqiao.entity;

import java.util.Date;

public class Video {
    private Integer videoId;

    private Integer userId;

    private Date uploadTime;

    private Byte isOnly;

    private String videoHot;

    private String videoTitle;

    private String videoUrl;

    private Integer videoSort;

    private String destination;

    private String videoLast;

    private String mainId;

    private Integer discussId;

    private String videoDetail;

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Byte getIsOnly() {
        return isOnly;
    }

    public void setIsOnly(Byte isOnly) {
        this.isOnly = isOnly;
    }

    public String getVideoHot() {
        return videoHot;
    }

    public void setVideoHot(String videoHot) {
        this.videoHot = videoHot == null ? null : videoHot.trim();
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle == null ? null : videoTitle.trim();
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    public Integer getVideoSort() {
        return videoSort;
    }

    public void setVideoSort(Integer videoSort) {
        this.videoSort = videoSort;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination == null ? null : destination.trim();
    }

    public String getVideoLast() {
        return videoLast;
    }

    public void setVideoLast(String videoLast) {
        this.videoLast = videoLast == null ? null : videoLast.trim();
    }

    public String getMainId() {
        return mainId;
    }

    public void setMainId(String mainId) {
        this.mainId = mainId == null ? null : mainId.trim();
    }

    public Integer getDiscussId() {
        return discussId;
    }

    public void setDiscussId(Integer discussId) {
        this.discussId = discussId;
    }

    public String getVideoDetail() {
        return videoDetail;
    }

    public void setVideoDetail(String videoDetail) {
        this.videoDetail = videoDetail == null ? null : videoDetail.trim();
    }
}