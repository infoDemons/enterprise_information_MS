package com.demon.dbserver.service.impl;

import com.demon.dbserver.bean.Industry;
import com.demon.dbserver.dao.IndustryDao;
import com.demon.dbserver.service.IndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class IndustryServiceImpl implements IndustryService {
    @Autowired
    private IndustryDao industryDao;

    @Override
    public List<Industry> getAllIndustries() {
        return industryDao.getAllIndustries();
    }

}