package com.demon.dbserver.dao;

import com.demon.dbserver.bean.Change;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ChangeDao {



    @Select("select * from enterprise_information_change where enterprise_id = #{enterpriseId}")
    List<Change> getChangeByEnterpriseId(@Param("enterpriseId") Integer enterpriseId);

    @Select("select * from enterprise_information_change where enterprise_name like '%${enterpriseName}%' limit 1000")
    List<Change> getChangeByEnterpriseName(@Param("enterpriseName") String enterpriseName);

    @Select("select * from enterprise_information_change")
    List<Change> getAllChanges();

    @Delete("delete from enterprise_information_change where enterprise_information_change_id = #{enterpriseInformationChangeId} ")
    void deleteChange(@Param("enterpriseInformationChangeId") Integer enterpriseInformationChangeId);

    @Update("update enterprise_information_change set enterprise_id = #{enterpriseId}, " +
            "enterprise_name = #{enterpriseName}, " +
            "information_change_date = #{informationChangeDate}, " +
            "information_change_type = #{informationChangeType}, " +
            "information_before = #{informationBefore}, " +
            "information_after = #{informationAfter}, " +
            "create_date = #{createDate} " +
            "where enterprise_information_change_id = #{enterpriseInformationChangeId}")
    void modifyChange(@Param("enterpriseInformationChangeId") Integer enterpriseInformationChangeId,
                            @Param("enterpriseId") Integer enterpriseId,
                            @Param("enterpriseName") String enterpriseName,
                            @Param("informationChangeDate") String informationChangeDate,
                            @Param("informationChangeType") String informationChangeType,
                            @Param("informationBefore") String informationBefore,
                            @Param("informationAfter") String informationAfter,
                            @Param("createDate") String createDate);


}