package org.lanqiao.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Users {
    private Integer userId;

    private String userRickname;

    private String userPassw;

    private String userPhone;

    private String userName;

    private String userSex;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date userBirthday;

    private String userAddress;

    private String userPicaddress;

    private String userSign;

    private String userImg;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserRickname() {
        return userRickname;
    }

    public void setUserRickname(String userRickname) {
        this.userRickname = userRickname == null ? null : userRickname.trim();
    }

    public String getUserPassw() {
        return userPassw;
    }

    public void setUserPassw(String userPassw) {
        this.userPassw = userPassw == null ? null : userPassw.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress == null ? null : userAddress.trim();
    }

    public String getUserPicaddress() {
        return userPicaddress;
    }

    public void setUserPicaddress(String userPicaddress) {
        this.userPicaddress = userPicaddress == null ? null : userPicaddress.trim();
    }

    public String getUserSign() {
        return userSign;
    }

    public void setUserSign(String userSign) {
        this.userSign = userSign == null ? null : userSign.trim();
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg == null ? null : userImg.trim();
    }
}