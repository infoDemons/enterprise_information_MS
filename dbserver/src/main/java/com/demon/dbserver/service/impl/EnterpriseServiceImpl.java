package com.demon.dbserver.service.impl;

import com.demon.dbserver.bean.Enterprise;
import com.demon.dbserver.dao.EnterpriseDao;
import com.demon.dbserver.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    @Autowired
    private EnterpriseDao enterpriseDao;

    @Override
    public Enterprise getEnterpriseById(Integer id) {
        Enterprise enterprise = enterpriseDao.getEnterpriseById(id);
        System.out.println(enterprise.adjust());
        return enterprise;
    }
}
