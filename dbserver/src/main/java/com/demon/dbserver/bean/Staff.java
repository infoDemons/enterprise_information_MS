package com.demon.dbserver.bean;

import java.io.Serializable;

/**
 * 企业基本信息实体类
 *
 * @author wuruofan
 */

public class Staff implements Serializable {

    private Integer staffId;
    private Integer enterpriseId;
    private String enterpriseName;
    private String staffName;
    private Integer owningEnterpriseNumber;
    private String position;

    public Integer getEnterpriseId() { return enterpriseId; }

    public void setEnterpriseId(Integer enterpriseId) { this.enterpriseId = enterpriseId; }

    public String getEnterpriseName() { return enterpriseName; }

    public void setEnterpriseName(String enterpriseName) { this.enterpriseName = enterpriseName; }

    public String getStaffName() { return staffName; }

    public void setStaffName(String staffName) { this.staffName = staffName; }

    public Integer getOwningEnterpriseNumber() { return owningEnterpriseNumber; }

    public void setOwningEnterpriseNumber(Integer owningEnterpriseNumber) {
        this.owningEnterpriseNumber = owningEnterpriseNumber;
    }

    public String getPosition() { return position; }

    public void setPosition(String position) { this.position = position; }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }
}
