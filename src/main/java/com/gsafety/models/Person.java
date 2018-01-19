package com.gsafety.models;

public class Person {


    private int id;
    private String cEmail;
    private String cMobile;
    private String cName;
    private String cDepartment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public String getCmobile() {
        return cMobile;
    }

    public void setCmobile(String cMobile) {
        this.cMobile = cMobile;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcDepartment() {
        return cDepartment;
    }

    public void setcDepartment(String cDepartment) {
        this.cDepartment = cDepartment;
    }

    public Person(int id, String cEmail, String cMobile, String cName, String cDepartment) {
        this.id = id;
        this.cEmail = cEmail;
        this.cMobile = cMobile;
        this.cName = cName;
        this.cDepartment = cDepartment;
    }

    public Person() {
    }

}
