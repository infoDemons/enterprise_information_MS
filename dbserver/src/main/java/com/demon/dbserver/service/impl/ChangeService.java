package com.demon.dbserver.service;

import com.demon.dbserver.bean.Change;

import java.util.List;

public interface ChangeService {

    List<Change> getChangeByEnterpriseId(Integer enterpriseId);

    List<Change> getChangeByEnterpriseName(String enterpriseName);

    List<Change> getChangeByInformationChangeType(String changeType);

    List<Change> getAllChanges();

    boolean deleteChange(Integer changeId);

    boolean modifyChange(Integer changeId,
                            Integer enterpriseId,
                            String enterpriseName,
                            String changeDate,
                            String changeType,
                            String informationBefore,
                            String informationAfter,
                            String createDate);

}

