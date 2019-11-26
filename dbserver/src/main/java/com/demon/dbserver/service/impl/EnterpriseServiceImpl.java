package com.demon.dbserver.service.impl;

import com.demon.dbserver.bean.Enterprise;
import com.demon.dbserver.dao.EnterpriseDao;
import com.demon.dbserver.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    @Autowired
    private EnterpriseDao enterpriseDao;

    @Override
    public Enterprise getEnterpriseById(Integer id) {
        return enterpriseDao.getEnterpriseById(id);
    }

    @Override
    public List<Enterprise> getEnterprisesByPage(Integer id) {
        return enterpriseDao.getEnterprisesByPage(id);
    }
}
