package com.gsafety.models;

public class Db {
    private int id;
    private String dbAccount;
    private String dbBrand;
    private String dbDataFileLocation;
    private String dbInstallationManual;
    private String dbInstance;
    private String dbPassword;
    private String dbPort;
    private Deploy deploy;
    private Integer deployId;
    private Deploy deployByDeployId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDbAccount() {
        return dbAccount;
    }

    public void setDbAccount(String dbAccount) {
        this.dbAccount = dbAccount;
    }

    public String getDbBrand() {
        return dbBrand;
    }

    public void setDbBrand(String dbBrand) {
        this.dbBrand = dbBrand;
    }

    public String getDbDataFileLocation() {
        return dbDataFileLocation;
    }

    public void setDbDataFileLocation(String dbDataFileLocation) {
        this.dbDataFileLocation = dbDataFileLocation;
    }

    public String getDbInstallationManual() {
        return dbInstallationManual;
    }

    public void setDbInstallationManual(String dbInstallationManual) {
        this.dbInstallationManual = dbInstallationManual;
    }

    public String getDbInstance() {
        return dbInstance;
    }

    public void setDbInstance(String dbInstance) {
        this.dbInstance = dbInstance;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public String getDbPort() {
        return dbPort;
    }

    public void setDbPort(String dbPort) {
        this.dbPort = dbPort;
    }

    public Deploy getDeploy() {
        return deploy;
    }

    public void setDeploy(Deploy deploy) {
        this.deploy = deploy;
    }

    public Integer getDeployId() {
        return deployId;
    }

    public void setDeployId(Integer deployId) {
        this.deployId = deployId;
    }

    public Deploy getDeployByDeployId() {
        return deployByDeployId;
    }

    public void setDeployByDeployId(Deploy deployByDeployId) {
        this.deployByDeployId = deployByDeployId;
    }

    public Db(int id, String dbAccount, String dbBrand, String dbDataFileLocation, String dbInstallationManual, String dbInstance, String dbPassword, String dbPort, Deploy deploy, Integer deployId, Deploy deployByDeployId) {
        this.id = id;
        this.dbAccount = dbAccount;
        this.dbBrand = dbBrand;
        this.dbDataFileLocation = dbDataFileLocation;
        this.dbInstallationManual = dbInstallationManual;
        this.dbInstance = dbInstance;
        this.dbPassword = dbPassword;
        this.dbPort = dbPort;
        this.deploy = deploy;
        this.deployId = deployId;
        this.deployByDeployId = deployByDeployId;
    }

    public Db() {
    }
}

