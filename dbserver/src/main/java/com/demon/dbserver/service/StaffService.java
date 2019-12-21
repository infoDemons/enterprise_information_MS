package com.demon.dbserver.service;

import com.demon.dbserver.bean.Staff;

import java.util.List;

public interface StaffService {

    List<Staff> getStaffByName(String name);

    List<Staff> getStaffByEnterprise(String name);

}