package com.dh.appproject.model;

public class AppCentent {
    private Long id;

    private String url;

    private String pictureName;

    private Long uploadId;

    private String isitvalid;

    public AppCentent(Long id, String url, String pictureName, Long uploadId, String isitvalid) {
        this.id = id;
        this.url = url;
        this.pictureName = pictureName;
        this.uploadId = uploadId;
        this.isitvalid = isitvalid;
    }

    public AppCentent() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public Long getUploadId() {
        return uploadId;
    }

    public void setUploadId(Long uploadId) {
        this.uploadId = uploadId;
    }

    public String getIsitvalid() {
        return isitvalid;
    }

    public void setIsitvalid(String isitvalid) {
        this.isitvalid = isitvalid;
    }
}