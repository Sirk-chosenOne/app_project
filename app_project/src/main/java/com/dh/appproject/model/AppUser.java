package com.dh.appproject.model;

import java.util.Date;

public class AppUser {
//  主键id
    private Long id;
//  用户账号
    private String userAccount;
//  用户名称
    private String userName;
//  用户密码
    private String userPassword;
//  用户性别
    private String sex;
//  出生年月
    private Date birthday;
//  所属国家
    private String country;
//  所属地区
    private String region;
//  收获地址
    private String address;
//  头像图片储存地址
    private String pictureAddress;
//  创建时间
    private Date createDate;
//  是否有效
    private String isitvalid;

    public AppUser(Long id, String userAccount, String userName, String userPassword, String sex, Date birthday, String country, String region, String address, String pictureAddress, Date createDate, String isitvalid) {
        this.id = id;
        this.userAccount = userAccount;
        this.userName = userName;
        this.userPassword = userPassword;
        this.sex = sex;
        this.birthday = birthday;
        this.country = country;
        this.region = region;
        this.address = address;
        this.pictureAddress = pictureAddress;
        this.createDate = createDate;
        this.isitvalid = isitvalid;
    }

    public AppUser() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPictureAddress() {
        return pictureAddress;
    }

    public void setPictureAddress(String pictureAddress) {
        this.pictureAddress = pictureAddress;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getIsitvalid() {
        return isitvalid;
    }

    public void setIsitvalid(String isitvalid) {
        this.isitvalid = isitvalid;
    }
}