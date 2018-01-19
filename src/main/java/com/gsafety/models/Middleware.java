package com.gsafety.models;

public class Middleware {
    private int id;
    private String deployDirectory;
    private String domainAccount;
    private String domainName;
    private String domainPassword;
    private String installationManual;
    private String middlewareBrand;
    private String middlewarePort;
    private String middlewareUrl;
    private String remarks;
    private Deploy deploy;
    private Integer deployId;
    private Deploy deployByDeployId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeployDirectory() {
        return deployDirectory;
    }

    public void setDeployDirectory(String deployDirectory) {
        this.deployDirectory = deployDirectory;
    }

    public String getDomainAccount() {
        return domainAccount;
    }

    public void setDomainAccount(String domainAccount) {
        this.domainAccount = domainAccount;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getDomainPassword() {
        return domainPassword;
    }

    public void setDomainPassword(String domainPassword) {
        this.domainPassword = domainPassword;
    }

    public String getInstallationManual() {
        return installationManual;
    }

    public void setInstallationManual(String installationManual) {
        this.installationManual = installationManual;
    }

    public String getMiddlewareBrand() {
        return middlewareBrand;
    }

    public void setMiddlewareBrand(String middlewareBrand) {
        this.middlewareBrand = middlewareBrand;
    }

    public String getMiddlewarePort() {
        return middlewarePort;
    }

    public void setMiddlewarePort(String middlewarePort) {
        this.middlewarePort = middlewarePort;
    }

    public String getMiddlewareUrl() {
        return middlewareUrl;
    }

    public void setMiddlewareUrl(String middlewareUrl) {
        this.middlewareUrl = middlewareUrl;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public Middleware(int id, String deployDirectory, String domainAccount, String domainName, String domainPassword, String installationManual, String middlewareBrand, String middlewarePort, String middlewareUrl, String remarks, Deploy deploy, Integer deployId, Deploy deployByDeployId) {
        this.id = id;
        this.deployDirectory = deployDirectory;
        this.domainAccount = domainAccount;
        this.domainName = domainName;
        this.domainPassword = domainPassword;
        this.installationManual = installationManual;
        this.middlewareBrand = middlewareBrand;
        this.middlewarePort = middlewarePort;
        this.middlewareUrl = middlewareUrl;
        this.remarks = remarks;
        this.deploy = deploy;
        this.deployId = deployId;
        this.deployByDeployId = deployByDeployId;
    }

    public Middleware() {
    }
}
