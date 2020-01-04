package com.demon.dbserver.dao;

import com.demon.dbserver.bean.Trademark;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TrademarkDao {

    @Select("select * from trademark where enterprise_id = #{enterpriseId}")
    List<Trademark> getTrademarkByEnterpriseId(@Param("enterpriseId") Integer enterpriseId);

    @Select("select * from trademark where applicant like '%${applicant}%' limit 1000")
    List<Trademark> getTrademarkByApplicant(@Param("applicant") String applicant);

    @Select("select * from trademark where trademark_name like '%${trademarkName}%' limit 1000")
    List<Trademark> getTrademarkByTrademarkName(@Param("trademarkName") String trademarkName);

    @Select("select * from trademark where registration_number like '%${registrationNumber}%' limit 1000")
    List<Trademark> getTrademarkByRegistrationNumber(@Param("registrationNumber") Integer registrationNumber);

    @Select("select * from trademark")
    List<Trademark> getAllTrademarks();

    @Select("select max(trademark_id) from trademark")
    int getMaxTrademarkId();

    @Insert("insert into trademark values (#{trademarkId}, #{enterpriseId}, #{applicant}, #{trademarkAddress}, #{trademarkName}, #{registrationNumber}, #{classification}, #{trademarkStatus}, #{trademarkProcess})")
    void addTrademark(Trademark trademark);


    @Delete("delete from trademark where trademark_id = #{trademarkId} ")
    void deleteTrademark(@Param("trademarkId") Integer trademarkId);

    @Update("update trademark set trademark_name = #{trademarkName}, " +
            "applicant = #{applicant}, " +
            "trademark_address = #{trademarkAddress}, " +
            "registration_number = #{registrationNumber}, " +
            "classification = #{classification}, " +
            "trademark_status = #{trademarkStatus}, " +
            "trademark_process = #{trademarkProcess} " +
            "where trademark_id = #{trademarkId}")
    void modifyTrademark(@Param("trademarkId") Integer trademarkId,
                            @Param("applicant") String applicantName,
                            @Param("trademarkAddress") String trademarkAddress,
                            @Param("trademarkName") String trademarkName,
                            @Param("registrationNumber") Integer registrationNumber,
                            @Param("classification") String classification,
                            @Param("trademarkStatus") String trademarkStatus,
                            @Param("trademarkProcess") String trademarkProcess);

}