package com.example.exercise_1.model;

import java.util.List;

public class EmailBox {
    private String languages;
    private Integer pageSizes;
    private Boolean spamsFilter;
    private String signature;

    public EmailBox() {
    }
    public EmailBox(String languages, Integer pageSizes, Boolean spamsFilter, String signature) {
        this.languages = languages;
        this.pageSizes = pageSizes;
        this.spamsFilter = spamsFilter;
        this.signature = signature;
    }
    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public Integer getPageSizes() {
        return pageSizes;
    }

    public void setPageSizes(Integer pageSizes) {
        this.pageSizes = pageSizes;
    }

    public Boolean getSpamsFilter() {
        return spamsFilter;
    }

    public void setSpamsFilter(Boolean spamsFilter) {
        this.spamsFilter = spamsFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }


}
