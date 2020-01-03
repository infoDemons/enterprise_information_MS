package com.demon.dbserver.dao;

import com.demon.dbserver.bean.Trademark;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TrademarkDao {

    @Select("select * from trademark where enterprise_id = #{enterpriseId}")
    List<Trademark> getTrademarkByEnterpriseId(@Param("enterpriseId") Integer enterpriseId);

    @Select("select * from trademark where applicant like '%${applicantName}%' limit 1000")
    List<Trademark> getTrademarkByApplicant(@Param("applicantName") String applicantName);

    @Select("select * from trademark where trademark_name like '%${trademarkName}%' limit 1000")
    List<Trademark> getTrademarkByTrademarkName(@Param("trademarkName") String trademarkName);

    @Select("select * from trademark where registration_number = #{registrationNumber}")
    List<Trademark> getTrademarkByRegistrationNumber(@Param("registrationNumber") Integer registrationNumber);

    @Select("select * from trademark")
    List<Trademark> getAllTrademarks();

    @Delete("delete from trademark where trademark_id = #{trademarkId} ")
    void deleteTrademark(@Param("trademarkId") Integer trademarkId);

    @Update("update trademark set trademark_name = #{trademarkName}, " +
            "applicant = #{applicantName}, " +
            "trademark_address = #{trademarkAddress}, " +
            "registration_number = #{registrationNumber}, " +
            "classification = #{classification}, " +
            "trademark_status = #{trademarkStatus}, " +
            "trademark_process = #{trademarkProcess}, " +
            "where trademark_id = #{trademarkId}")
    void modifyTrademark(@Param("trademarkId") Integer trademarkId,
                            @Param("applicantName") String applicantName,
                            @Param("trademarkAddress") String trademarkAddress,
                            @Param("trademarkName") String trademarkName,
                            @Param("registrationNumber") Integer registrationNumber,
                            @Param("classification") String classification,
                            @Param("trademarkStatus") String trademarkStatus,
                            @Param("trademarkProcess") String trademarkProcess);

}