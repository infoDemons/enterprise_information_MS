package com.demon.dbserver.service;

import com.demon.dbserver.bean.Staff;

import java.util.List;

public interface StaffService {

    List<Staff> getStaffByName(String name);

    List<Staff> getStaffByEnterprise(String name);

    boolean deleteStaff(Integer enterpriseId, String staffName, String position);

    boolean modifyStaff(Integer originalEnterpriseId, String originalStaffName, String originalPosition,
                        String staffName, Integer owningEnterpriseNumber, String position);

}