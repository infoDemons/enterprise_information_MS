package com.demon.dbserver.bean;

import java.io.Serializable;

/**
 * 变更类
 *
 * @author chenxinyi
 */

public class Change implements Serializable {

    private int changeId;
    private int enterpriseId;
    private String enterpriseName;
    private String changeDate;
    private String changeType;
    private String informationBefore;
    private String informationAfter;
    private String createDate;

    public int getChangeId() {
        return changeId;
    }

    public void setChangeId(int id) {
        this.changeId = id;
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

    public String getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(String changeDate) {
        this.changeDate = changeDate;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
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

