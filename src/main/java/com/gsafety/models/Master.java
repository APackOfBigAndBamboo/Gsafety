package com.gsafety.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Master {

    private int id;
    private int cpuCores;
    private int cpuNum;
    private String masterAccount;
    private String masterIp;
    private String masterPassword;
    private int memory;
    private String onPremise;
    private int storageSpace;
    private String systemBrand;
    private String systemName;
    private Set<Deploy> deploys = new HashSet<Deploy>();
    private Collection<Deploy> deploysById;
    public Master() {
    }
    public Master(int id, int cpuCores, int cpuNum, String masterAccount, String masterIp, String masterPassword, int memory, String onPremise, int storageSpace, String systemBrand, String systemName, Set<Deploy> deploys, Collection<Deploy> deploysById) {
        this.id = id;
        this.cpuCores = cpuCores;
        this.cpuNum = cpuNum;
        this.masterAccount = masterAccount;
        this.masterIp = masterIp;
        this.masterPassword = masterPassword;
        this.memory = memory;
        this.onPremise = onPremise;
        this.storageSpace = storageSpace;
        this.systemBrand = systemBrand;
        this.systemName = systemName;
        this.deploys = deploys;
        this.deploysById = deploysById;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCpuCores() {
        return cpuCores;
    }

    public void setCpuCores(int cpuCores) {
        this.cpuCores = cpuCores;
    }

    public int getCpuNum() {
        return cpuNum;
    }

    public void setCpuNum(int cpuNum) {
        this.cpuNum = cpuNum;
    }

    public String getMasterAccount() {
        return masterAccount;
    }

    public void setMasterAccount(String masterAccount) {
        this.masterAccount = masterAccount;
    }

    public String getMasterIp() {
        return masterIp;
    }

    public void setMasterIp(String masterIp) {
        this.masterIp = masterIp;
    }

    public String getMasterPassword() {
        return masterPassword;
    }

    public void setMasterPassword(String masterPassword) {
        this.masterPassword = masterPassword;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public String getOnPremise() {
        return onPremise;
    }

    public void setOnPremise(String onPremise) {
        this.onPremise = onPremise;
    }

    public int getStorageSpace() {
        return storageSpace;
    }

    public void setStorageSpace(int storageSpace) {
        this.storageSpace = storageSpace;
    }

    public String getSystemBrand() {
        return systemBrand;
    }

    public void setSystemBrand(String systemBrand) {
        this.systemBrand = systemBrand;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public Set<Deploy> getDeploys() {
        return deploys;
    }

    public void setDeploys(Set<Deploy> deploys) {
        this.deploys = deploys;
    }

    public Collection<Deploy> getDeploysById() {
        return deploysById;
    }

    public void setDeploysById(Collection<Deploy> deploysById) {
        this.deploysById = deploysById;
    }


}
