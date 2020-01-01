package com.demon.dbserver.bean;

import java.io.Serializable;

/**
 * 行业信息类
 *
 * @author wuruofan
 */
public class Industry implements Serializable {


    private String industryName;
    private Integer enterpriseCount;

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public Integer getEnterpriseCount() {
        return enterpriseCount;
    }

    public void setEnterpriseCount(Integer enterpriseCount) {
        this.enterpriseCount = enterpriseCount;
    }

}
