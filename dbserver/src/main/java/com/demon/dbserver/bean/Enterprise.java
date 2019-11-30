package com.demon.dbserver.bean;


/**
 * 企业基本信息实体类
 * @author  lixinyang
 */
public class Enterprise {
    
    private int enterpriseId;
    private String unifiedSocialCreditIdentifier;
    private String enterpriseName;
    private String registeredCapital;
    private String paidInCapital;
    private String businessScope;
    private String legalRepresentative;
    private String industry;
    private String telephoneNumber;
    private String email;
    private String registeredAddress;
    private String formOfBusinessEnterprise;
    private String businessRegistrationNumber;
    private String registrationAuthority;
    private String businessStatus;
    private int popularity;

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getUnifiedSocialCreditIdentifier() {
        return unifiedSocialCreditIdentifier;
    }

    public void setUnifiedSocialCreditIdentifier(String unifiedSocialCreditIdentifier) {
        this.unifiedSocialCreditIdentifier = unifiedSocialCreditIdentifier;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(String registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public String getPaidInCapital() {
        return paidInCapital;
    }

    public void setPaidInCapital(String paidInCapital) {
        this.paidInCapital = paidInCapital;
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegisteredAddress() {
        return registeredAddress;
    }

    public void setRegisteredAddress(String registeredAddress) {
        this.registeredAddress = registeredAddress;
    }

    public String getFormOfBusinessEnterprise() {
        return formOfBusinessEnterprise;
    }

    public void setFormOfBusinessEnterprise(String formOfBusinessEnterprise) {
        this.formOfBusinessEnterprise = formOfBusinessEnterprise;
    }

    public String getBusinessRegistrationNumber() {
        return businessRegistrationNumber;
    }

    public void setBusinessRegistrationNumber(String businessRegistrationNumber) {
        this.businessRegistrationNumber = businessRegistrationNumber;
    }

    public String getRegistrationAuthority() {
        return registrationAuthority;
    }

    public void setRegistrationAuthority(String registrationAuthority) {
        this.registrationAuthority = registrationAuthority;
    }

    public String getBusinessStatus() {
        return businessStatus;
    }

    public void setBusinessStatus(String businessStatus) {
        this.businessStatus = businessStatus;
    }

    public boolean adjust() {
        String oldIndustry = industry;
        industry = industry.replace("\n", "");
        return !oldIndustry.equals(industry);
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }
}
