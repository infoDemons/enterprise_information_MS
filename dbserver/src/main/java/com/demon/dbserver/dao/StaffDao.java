package com.demon.dbserver.dao;

import com.demon.dbserver.bean.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StaffDao {

    @Select("select * from enterprise_main_staff where staff_name like '%${name}%' limit 1000")
    List<Staff> getStaffByName(@Param("name") String name);

    @Select("select * from enterprise_main_staff where enterprise_name like '%${name}%' limit 1000")
    List<Staff> getStaffByEnterprise(@Param("name") String name);

}
