package com.demon.dbserver.service;

import com.demon.dbserver.bean.Change;

import java.util.List;

public interface ChangeService {

    List<Change> getChangeByEnterpriseId(Integer enterpriseId);

    List<Change> getChangeByEnterpriseName(String enterpriseName);

    List<Change> getAllChanges();

    int getMaxEnterpriseInformationChangeId();

    boolean deleteChange(Integer changeId);

    boolean addChange(Change change);

    boolean modifyChange(Integer enterpriseInformationChangeId,
                            Integer enterpriseId,
                            String enterpriseName,
                            String informationChangeDate,
                            String informationChangeType,
                            String informationBefore,
                            String informationAfter,
                            String createDate);

}

