package org.lanqiao.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Photo {
    private Integer photoId;

    private Integer userId;

    private String photoName;

    private String photoPower;

    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date photoTime;

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName == null ? null : photoName.trim();
    }

    public String getPhotoPower() {
        return photoPower;
    }

    public void setPhotoPower(String photoPower) {
        this.photoPower = photoPower == null ? null : photoPower.trim();
    }

    public Date getPhotoTime() {
        return photoTime;
    }

    public void setPhotoTime(Date photoTime) {
        this.photoTime = photoTime;
    }
}