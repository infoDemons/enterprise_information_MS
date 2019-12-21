package com.demon.dbserver.bean;

/**
 * 企业基本信息实体类
 *
 * @author wuruofan
 */

public class Staff {
    private int enterpriseId;
    private String enterpriseName;
    private String staffName;
    private int owningEnterpriseNumber;
    private String position;

    public int getEnterpriseId() { return enterpriseId; }

    public void setEnterpriseId(int enterpriseId) { this.enterpriseId = enterpriseId; }

    public String getEnterpriseName() { return enterpriseName; }

    public void setEnterpriseName(String enterpriseName) { this.enterpriseName = enterpriseName; }

    public String getStaffName() { return staffName; }

    public void setStaffName(String staffName) { this.staffName = staffName; }

    public int getOwningEnterpriseNumber() { return owningEnterpriseNumber; }

    public void setOwningEnterpriseNumber(int owningEnterpriseNumber) {
        this.owningEnterpriseNumber = owningEnterpriseNumber;
    }

    public String getPosition() { return position; }

    public void setPosition(String position) { this.position = position; }
}
