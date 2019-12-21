package com.demon.dbserver.es;

import com.demon.dbserver.dao.EnterpriseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class ElasticSearchInitializer implements ApplicationRunner {

    @Autowired
    private EnterpriseDao enterpriseDao;

    @Autowired
    private EnterpriseBriefRepository enterpriseBriefRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        List<Enterprise> enterprises = enterpriseDao.getAllEnterprises();
//        enterpriseBriefRepository.deleteAll();
//        int i = 0;
//        System.out.println(enterprises.size());
//        for (Enterprise enterprise : enterprises) {
//            EnterpriseBrief enterpriseBrief = new EnterpriseBrief(
//                    enterprise.getEnterpriseId(), enterprise.getEnterpriseName());
//            System.out.println(i);
//            i++;
//            enterpriseBriefRepository.index(enterpriseBrief);
//        }
    }
}
