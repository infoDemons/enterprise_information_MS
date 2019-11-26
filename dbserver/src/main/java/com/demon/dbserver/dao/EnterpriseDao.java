package com.demon.dbserver.dao;

import com.demon.dbserver.bean.Enterprise;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EnterpriseDao {

    @Select("select * from enterprise where enterprise_id = #{id}")
    Enterprise getEnterpriseById(Integer id);

    @Select("select * from enterprise limit #{num}, 10")
    List<Enterprise> getEnterprisesByPage(Integer num);
}
