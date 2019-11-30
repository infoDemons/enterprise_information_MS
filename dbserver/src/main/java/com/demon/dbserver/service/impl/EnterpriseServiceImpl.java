package com.demon.dbserver.service.impl;

import com.demon.dbserver.bean.Enterprise;
import com.demon.dbserver.dao.EnterpriseDao;
import com.demon.dbserver.es.EnterpriseBriefRepository;
import com.demon.dbserver.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;


@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    // 耗时操作使用线程池在子线程中完成
    private Executor executor = Executors.newSingleThreadExecutor();

    @Autowired
    private EnterpriseDao enterpriseDao;

    @Autowired
    private EnterpriseBriefRepository enterpriseBriefRepository;

    @Override
    public Enterprise getEnterpriseById(Integer id) {
        updateEnterprisePopularity(id);
        return enterpriseDao.getEnterpriseById(id);
    }

    @Override
    public List<Enterprise> getEnterpriseByIds(List<Integer> ids) {
        updateEnterprisePopularity(ids);
        return enterpriseDao.getEnterpriseByIds(ids);
    }


    @Override
    public List<Enterprise> getEnterpriseByName(String name) {
        List<Enterprise> res = enterpriseDao.getEnterpriseByName(name);
        updateEnterprisePopularity(mapIds(res));
        return res;
    }

    @Override
    public List<Enterprise> getEnterpriseByNameLike(String name) {
        List<Integer> enterpriseNameLikeIds = enterpriseBriefRepository
                .findByEnterpriseNameLike(name)
                .stream()
                .map(enterpriseBrief -> enterpriseBrief.getId())
                .collect(Collectors.toList());
        updateEnterprisePopularity(enterpriseNameLikeIds);
        return enterpriseDao.getEnterpriseByIds(enterpriseNameLikeIds);
    }

    @Override
    public List<Enterprise> getEnterprisesByPage(Integer num) {
        List<Enterprise> res = enterpriseDao.getEnterprisesByPage(num);
        updateEnterprisePopularity(mapIds(res));
        return res;
    }

    /**
     * 一次返回所有企业的数据
     * 测试使用
     * 日常不要调用
     *
     * @return 所有企业信息
     */
    @Override
    public List<Enterprise> getAllEnterprises() {
        return enterpriseDao.getAllEnterprises();
    }

    private List<Integer> mapIds(List<Enterprise> enterprises) {
        return enterprises.stream()
                .map(enterprise -> enterprise.getEnterpriseId())
                .collect(Collectors.toList());
    }

    private void updateEnterprisePopularity(List<Integer> ids) {
        if (ids.isEmpty()) {
            return;
        }
        executor.execute(new Runnable() {
            @Override
            public void run() {
                enterpriseDao.updateEnterprisePopularityByIds(ids);
            }
        });
    }

    private void updateEnterprisePopularity(Integer id) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                enterpriseDao.updateEnterprisePopularityById(id);
            }
        });
    }
}
