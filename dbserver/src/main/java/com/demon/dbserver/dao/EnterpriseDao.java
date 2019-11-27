package com.demon.dbserver.dao;

import com.demon.dbserver.bean.Enterprise;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EnterpriseDao {

    @Select("select * from enterprise where enterprise_id = #{id}")
    Enterprise getEnterpriseById(Integer id);

    @Select("select * from enterprise where enterprise_name like '%${name}%'")
    List<Enterprise> getEnterpriseByName(@Param("name") String name);

    @Select("select * from enterprise limit #{num}, 10")
    List<Enterprise> getEnterprisesByPage(Integer num);

    @Select("select * from enterprise")
    List<Enterprise> getAllEnterprises();
}
