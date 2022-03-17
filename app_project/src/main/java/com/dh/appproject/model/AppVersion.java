package com.dh.appproject.model;

public class AppVersion {
    private Long id;

    private String version;

    public AppVersion(Long id, String version) {
        this.id = id;
        this.version = version;
    }

    public AppVersion() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}