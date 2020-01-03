package com.demon.dbserver.bean;


import java.io.Serializable;

/**
 * 商标注册类
 *
 * @author chenxinyi
 */

public class Trademark implements Serializable {

    private int trademarkId;
    private int enterpriseId;
    private String applicantName;
    private String trademarkAddress;
    private String trademarkName;
    private int registrationNumber;
    private String classification;
    private String trademarkStatus;
    private String trademarkProcess;
    private int popularity;

    public int getTrademarkId() {
        return trademarkId;
    }

    public void setTrademarkId(int trademarkId) {
        this.trademarkId = trademarkId;
    }

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getTrademarkAddress() {
        return trademarkAddress;
    }

    public void setTrademarkAddress(String trademarkAddress) {
        this.trademarkAddress = trademarkAddress;
    }

    public String getTrademarkName() {
        return trademarkName;
    }

    public void setTrademarkName(String trademarkName) {
        this.trademarkName = trademarkName;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(Integer registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getTrademarkStatus() {
        return trademarkStatus;
    }

    public void setTrademarkStatus(String trademarkStatus) {
        this.trademarkStatus = trademarkStatus;
    }

    public String getTrademarkProcess() {
        return trademarkProcess;
    }

    public void setTrademarkProcess(String trademarkProcess) {
        this.trademarkProcess = trademarkProcess;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }
}
