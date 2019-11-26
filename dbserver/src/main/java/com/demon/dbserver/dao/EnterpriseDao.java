package com.demon.dbserver.dao;

import com.demon.dbserver.bean.Enterprise;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EnterpriseDao {

    @Select("select * from enterprise where enterprise_id = #{id}")
    Enterprise getEnterpriseById(Integer id);
}
