package com.gsafety.models;


public class Deploy {
    private int id;
    private String browser;
    private String contact;
    private String deploymentInterfacePeople;
    private String deploymentServices;
    private String industry;
    private String manual;
    private byte[] script;
    private int storageSpace;
    private String systemStatus;
    private String systemSynopsis;
    private String url;
    private String systemName;
    private byte[] picture;


    public Deploy() {
    }

    public Deploy(int id, String browser, String contact, String deploymentInterfacePeople, String deploymentServices, String industry, String manual, byte[] script, int storageSpace,
                  String systemStatus, String systemSynopsis, String url,String systemName,byte[] picture) {
        this.id = id;
        this.browser = browser;
        this.contact = contact;
        this.deploymentInterfacePeople = deploymentInterfacePeople;
        this.deploymentServices = deploymentServices;
        this.industry = industry;
        this.manual = manual;
        this.script = script;
        this.storageSpace = storageSpace;
        this.systemStatus = systemStatus;
        this.systemSynopsis = systemSynopsis;
        this.url = url;
        this.systemName=systemName;
        this.picture=picture;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDeploymentInterfacePeople() {
        return deploymentInterfacePeople;
    }

    public void setDeploymentInterfacePeople(String deploymentInterfacePeople) {
        this.deploymentInterfacePeople = deploymentInterfacePeople;
    }

    public String getDeploymentServices() {
        return deploymentServices;
    }

    public void setDeploymentServices(String deploymentServices) {
        this.deploymentServices = deploymentServices;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getManual() {
        return manual;
    }

    public void setManual(String manual) {
        this.manual = manual;
    }

    public byte[] getScript() {
        return script;
    }

    public void setScript(byte[] script) {
        this.script = script;
    }

    public int getStorageSpace() {
        return storageSpace;
    }

    public void setStorageSpace(int storageSpace) {
        this.storageSpace = storageSpace;
    }

    public String getSystemStatus() {
        return systemStatus;
    }

    public void setSystemStatus(String systemStatus) {
        this.systemStatus = systemStatus;
    }

    public String getSystemSynopsis() {
        return systemSynopsis;
    }

    public void setSystemSynopsis(String systemSynopsis) {
        this.systemSynopsis = systemSynopsis;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String syetemName) {
        this.systemName = syetemName;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

}
