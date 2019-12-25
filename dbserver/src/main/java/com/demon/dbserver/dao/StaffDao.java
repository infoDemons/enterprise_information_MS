package com.demon.dbserver.dao;

import com.demon.dbserver.bean.Staff;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StaffDao {

    @Select("select * from enterprise_main_staff where staff_name like '%${name}%' limit 1000")
    List<Staff> getStaffByName(@Param("name") String name);

    @Select("select * from enterprise_main_staff where enterprise_name like '%${name}%' limit 1000")
    List<Staff> getStaffByEnterprise(@Param("name") String name);

    @Delete("delete from enterprise_main_staff where staff_id = #{staffId} ")
    void deleteStaff(@Param("staffId") Integer staffId);

    @Update("update enterprise_main_staff set staff_name = '${staffName}', " +
            "owning_enterprise_number = ${owningEnterpriseNumber}, " +
            "position = '${position}' " +
            "where enterprise_id = ${originalEnterpriseId} and " +
            "staff_name = '${originalStaffName}' and " +
            "position = '${originalPosition}'")
    void updateStaff(@Param("originalEnterpriseId") Integer originalEnterpriseId,
                     @Param("originalStaffName") String originalStaffName,
                     @Param("originalPosition") String originalPosition,
                     @Param("staffName") String staffName,
                     @Param("owningEnterpriseNumber") Integer owningEnterpriseNumber,
                     @Param("position") String position);

}
