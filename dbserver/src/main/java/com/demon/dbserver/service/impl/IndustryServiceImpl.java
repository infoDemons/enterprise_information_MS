package com.demon.dbserver.service.impl;

import com.demon.dbserver.bean.Industry;
import com.demon.dbserver.dao.IndustryDao;
import com.demon.dbserver.service.IndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class IndustryServiceImpl implements IndustryService {
    @Autowired
    private IndustryDao industryDao;

    @Override
    public List<Industry> getAllIndustries() {
        return industryDao.getAllIndustries();
    }

}