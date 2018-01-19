package com.gsafety.models;

public class Gis {
    private int id;
    private String gisBrand;
    private String gisPort;
    private String gisUrl;
    private String mapService;
    private String sliceFilePosition;
    private String softwareInstallationPosition;
    private String systemInformation;
    private Deploy deploy;
    private Integer deployId;
    private Deploy deployByDeployId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGisBrand() {
        return gisBrand;
    }

    public void setGisBrand(String gisBrand) {
        this.gisBrand = gisBrand;
    }

    public String getGisPort() {
        return gisPort;
    }

    public void setGisPort(String gisPort) {
        this.gisPort = gisPort;
    }

    public String getGisUrl() {
        return gisUrl;
    }

    public void setGisUrl(String gisUrl) {
        this.gisUrl = gisUrl;
    }

    public String getMapService() {
        return mapService;
    }

    public void setMapService(String mapService) {
        this.mapService = mapService;
    }

    public String getSliceFilePosition() {
        return sliceFilePosition;
    }

    public void setSliceFilePosition(String sliceFilePosition) {
        this.sliceFilePosition = sliceFilePosition;
    }

    public String getSoftwareInstallationPosition() {
        return softwareInstallationPosition;
    }

    public void setSoftwareInstallationPosition(String softwareInstallationPosition) {
        this.softwareInstallationPosition = softwareInstallationPosition;
    }

    public String getSystemInformation() {
        return systemInformation;
    }

    public void setSystemInformation(String systemInformation) {
        this.systemInformation = systemInformation;
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

    public Gis(int id, String gisBrand, String gisPort, String gisUrl, String mapService, String sliceFilePosition, String softwareInstallationPosition, String systemInformation, Deploy deploy, Integer deployId, Deploy deployByDeployId) {
        this.id = id;
        this.gisBrand = gisBrand;
        this.gisPort = gisPort;
        this.gisUrl = gisUrl;
        this.mapService = mapService;
        this.sliceFilePosition = sliceFilePosition;
        this.softwareInstallationPosition = softwareInstallationPosition;
        this.systemInformation = systemInformation;
        this.deploy = deploy;
        this.deployId = deployId;
        this.deployByDeployId = deployByDeployId;
    }

    public Gis() {
    }
}
