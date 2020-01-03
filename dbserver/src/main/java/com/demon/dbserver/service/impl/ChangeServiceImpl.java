package com.demon.dbserver.service.impl;



import com.demon.dbserver.bean.Change;
import com.demon.dbserver.dao.ChangeDao;
import com.demon.dbserver.service.ChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ChangeServiceImpl implements ChangeService {

    @Autowired
    private ChangeDao changeDao;

    @Override
    public List<Change> getChangeByEnterpriseId(Integer enterpriseId) {
        return changeDao.getChangeByEnterpriseId(enterpriseId);
    }

    @Override
    public List<Change> getChangeByEnterpriseName(String enterpriseName) {
        return changeDao.getChangeByEnterpriseName(enterpriseName);
    }

    @Override
    public List<Change> getAllChanges() {
        return changeDao.getAllChanges();
    }

    @Override
    public boolean deleteChange(Integer enterpriseInformationChangeId) {
        try {
            changeDao.deleteChange(enterpriseInformationChangeId);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean modifyChange(Integer enterpriseInformationChangeId,
                            Integer enterpriseId,
                            String enterpriseName,
                            String informationChangeDate,
                            String informationChangeType,
                            String informationBefore,
                            String informationAfter,
                            String createDate) {
        try {
            changeDao.modifyChange(enterpriseInformationChangeId, enterpriseId, enterpriseName, informationChangeDate, informationChangeType, informationBefore, informationAfter, createDate);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

}
