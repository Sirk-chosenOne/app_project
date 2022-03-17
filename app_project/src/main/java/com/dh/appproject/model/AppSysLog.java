package com.dh.appproject.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class AppSysLog {
    private Long id;
//  方法
    private String method;
//  参数
    private String params;
//  用户ID
    private Long userId;
//  用户名称
    private String userName;
//  日志描述
    private String operation;
//  运行时间
    private Long runTime;
//  创建时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
//  IP地址
    private String ip;

    public AppSysLog(Long id, String method, String params, Long userId, String userName, String operation, Long runTime, Date createTime, String ip) {
        this.id = id;
        this.method = method;
        this.params = params;
        this.userId = userId;
        this.userName = userName;
        this.operation = operation;
        this.runTime = runTime;
        this.createTime = createTime;
        this.ip = ip;
    }

    public AppSysLog() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Long getRunTime() {
        return runTime;
    }

    public void setRunTime(Long runTime) {
        this.runTime = runTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}