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
    public List<Enterprise> getEnterpriseByName(String name) {
        return enterpriseDao.getEnterpriseByName(name);
    }

    @Override
    public List<Enterprise> getEnterprisesByPage(Integer id) {
        return enterpriseDao.getEnterprisesByPage(id);
    }

    /**
     * 一次返回所有企业的数据
     * 测试使用
     * 日常不要调用
     * @return 所有企业信息
     */
    @Override
    public List<Enterprise> getAllEnterprises() {
        return enterpriseDao.getAllEnterprises();
    }
}
