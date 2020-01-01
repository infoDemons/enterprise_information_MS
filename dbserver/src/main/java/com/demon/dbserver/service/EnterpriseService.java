package com.demon.dbserver.service;

import com.demon.dbserver.bean.Enterprise;

import java.util.List;

public interface EnterpriseService {

    Enterprise getEnterpriseById(Integer id);

    List<Enterprise> getEnterpriseByIds(List<Integer> ids);

    List<Enterprise> getEnterpriseByName(String name);

    List<Enterprise> getEnterpriseByNameLike(String name);

    List<Enterprise> getEnterprisesByPage(Integer id);

    List<Enterprise> getAllEnterprises();

    List<String> getAllFormOfBusinessEnterprise();

    List<Enterprise> getEnterpriseByAdvancedSearch(Integer id, String name, String industry, String form);

    boolean deleteEnterpriseById(Integer id);

    boolean updateEnterprise(Enterprise enterprise);
}
