package com.demon.dbserver.service.impl;

import com.demon.dbserver.bean.Staff;
import com.demon.dbserver.dao.StaffDao;
import com.demon.dbserver.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffDao staffDao;

    @Override
    public List<Staff> getStaffByName(String name) {
        return staffDao.getStaffByName(name);
    }

    @Override
    public List<Staff> getStaffByEnterprise(String name) {
        return staffDao.getStaffByEnterprise(name);
    }
}
