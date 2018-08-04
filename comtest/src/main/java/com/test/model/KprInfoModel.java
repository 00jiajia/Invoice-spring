package com.test.model;

public class KprInfoModel {

    private String name;
    private String password;
    //密码答案
    private String passAnswer;
    //密保问题Id
    private int passQuestionId;
    //登录姓名
    private String loginName;
    //角色
    private int roleId;
    //头像图片地址
    private String imgUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassAnswer() {
        return passAnswer;
    }

    public void setPassAnswer(String passAnswer) {
        this.passAnswer = passAnswer;
    }

    public int getPassQuestionId() {
        return passQuestionId;
    }

    public void setPassQuestionId(int passQuestionId) {
        this.passQuestionId = passQuestionId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }



}
