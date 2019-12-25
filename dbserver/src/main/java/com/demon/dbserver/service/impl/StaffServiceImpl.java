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

    @Override
    public boolean deleteStaff(Integer staffId) {
        try {
            staffDao.deleteStaff(staffId);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean modifyStaff(Integer originalEnterpriseId, String originalStaffName, String originalPosition,
                                String staffName, Integer owningEnterpriseNumber, String position) {
        try {
            staffDao.updateStaff(originalEnterpriseId, originalStaffName, originalPosition,
                                 staffName, owningEnterpriseNumber, position);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }
}
