package com.demon.dbserver.bean;

import java.io.Serializable;

/**
 * 变更类
 *
 * @author chenxinyi
 */

public class Change implements Serializable {

    private int enterpriseInformationChangeId;
    private int enterpriseId;
    private String enterpriseName;
    private String informationChangeDate;
    private String informationChangeType;
    private String informationBefore;
    private String informationAfter;
    private String createDate;

    public int getEnterpriseInformationChangeId() {
        return enterpriseInformationChangeId;
    }

    public void setEnterpriseInformationChangeId(int id) {
        this.enterpriseInformationChangeId = id;
    }

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getInformationChangeDate() {
        return informationChangeDate;
    }

    public void setInformationChangeDate(String informationChangeDate) {
        this.informationChangeDate = informationChangeDate;
    }

    public String getInformationChangeType() {
        return informationChangeType;
    }

    public void setInformationChangeType(String informationChangeType) {
        this.informationChangeType = informationChangeType;
    }

    public String getInformationBefore() {
        return informationBefore;
    }

    public void setInformationBefore(String informationBefore) {
        this.informationBefore = informationBefore;
    }

    public String getInformationAfter() {
        return informationAfter;
    }

    public void setInformationAfter(String informationAfter) {
        this.informationAfter = informationAfter;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

}

