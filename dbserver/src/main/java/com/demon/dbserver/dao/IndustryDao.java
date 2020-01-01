package com.demon.dbserver.dao;

import com.demon.dbserver.bean.Industry;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IndustryDao {

    @Select("select industry as industryName, count(*) as enterpriseCount " +
            "from enterprise " +
            "group by industry " +
            "order by enterpriseCount desc")
    List<Industry> getAllIndustries();

}
