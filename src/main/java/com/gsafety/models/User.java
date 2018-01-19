package com.gsafety.models;


import org.apache.commons.lang.StringUtils;

public class User {

    private int id;
    private String account;
    private String accountStatus;
    private String accountType;
    private String department;
    private String password;
    private String name;
    private String mobile;
    private String email;
    private String accessControl;

//    // 添加字符串数组和字符串互相转化的适配方法
//    public String[] getAccessControlArr(){
//        return this.accessControl.split(",");
//    }
//    public void setAccessControlArr(String[] accessControlArr){
//        this.accessControl= StringUtils.join(accessControlArr,",");
//    }

    public String getAccessControl() {
        return accessControl;
    }

    public void setAccessControl(String accessControl) {
        this.accessControl = accessControl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(int id, String account, String accountStatus, String accountType, String department, String password, String name, String email, String mobile,String accessControl) {
        this.id = id;
        this.account = account;
        this.accountStatus = accountStatus;
        this.accountType = accountType;
        this.department = department;
        this.password = password;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.accessControl=accessControl;
    }

    public User() {
    }
}
