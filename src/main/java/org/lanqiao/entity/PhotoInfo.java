package org.lanqiao.entity;

public class PhotoInfo {
    private Integer photoContentId;

    private Integer photoId;

    private String photoContentUrl;

    public Integer getPhotoContentId() {
        return photoContentId;
    }

    public void setPhotoContentId(Integer photoContentId) {
        this.photoContentId = photoContentId;
    }

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public String getPhotoContentUrl() {
        return photoContentUrl;
    }

    public void setPhotoContentUrl(String photoContentUrl) {
        this.photoContentUrl = photoContentUrl == null ? null : photoContentUrl.trim();
    }
}