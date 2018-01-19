package com.gsafety.models;

import java.util.List;

public class Systems {
 private String name;
 private String industry;
 private String status;
 private String supporter;
 private String url;
 private String type;
 private String summary;
 private List screenshots;
 private List manual;
 private List script;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSupporter() {
        return supporter;
    }

    public void setSupporter(String supporter) {
        this.supporter = supporter;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List getScreenshots() {
        return screenshots;
    }

    public void setScreenshots(List screenshots) {
        this.screenshots = screenshots;
    }

    public List getManual() {
        return manual;
    }

    public void setManual(List manual) {
        this.manual = manual;
    }

    public List getScript() {
        return script;
    }

    public void setScript(List script) {
        this.script = script;
    }

    public Systems() {
    }

    public Systems(String name, String industry, String status, String supporter, String url, String type, String summary, List screenshots, List manual, List script) {
        this.name = name;
        this.industry = industry;
        this.status = status;
        this.supporter = supporter;
        this.url = url;
        this.type = type;
        this.summary = summary;
        this.screenshots = screenshots;
        this.manual = manual;
        this.script = script;
    }
}
