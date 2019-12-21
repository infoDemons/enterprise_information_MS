package com.demon.dbserver.service.impl;

import com.demon.dbserver.bean.Staff;
import com.demon.dbserver.dao.StaffDao;
import com.demon.dbserver.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


@Service
public class StaffServiceImpl implements StaffService {

    // 耗时操作使用线程池在子线程中完成
    private Executor executor = Executors.newSingleThreadExecutor();

    @Autowired
    private StaffDao staffDao;

    @Override
    public List<Staff> getStaffByName(String name) {
        List<Staff> res = staffDao.getStaffByName(name);
        return res;
    }

    @Override
    public List<Staff> getStaffByEnterprise(String name) {
        List<Staff> res = staffDao.getStaffByEnterprise(name);
        return res;
    }
}
