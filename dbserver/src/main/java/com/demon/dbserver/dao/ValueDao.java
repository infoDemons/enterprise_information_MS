package com.demon.dbserver.dao;


import com.demon.dbserver.bean.Value;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 处理价值观那张表的 dao
 */
@Mapper
public interface ValueDao {

    @Select("select * from value")
    List<Value> getAllValues();

    @Select("select * from value where id = #{id}")
    Value getValueById(Integer id);

    @Select("select max(id) from value")
    int getMaxId();

    @Insert("insert into value values (#{id}, #{name}, #{explanation})")
    void addValue(Value value);

    @Delete("delete from value where id = #{id}")
    void deleteValue(Integer id);

    @Update("update value set name = #{name}, explanation = #{explanation} where id = #{id}")
    void updateValue(Value value);
}
