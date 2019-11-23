package com.demon.dbserver.service;

import com.demon.dbserver.bean.Value;

import java.util.List;

/**
 * 用来处理价值观表相关的业务层接口
 */
public interface ValueService {

    List<Value> getAllValues();

    Value getValueById(Integer id);

    int getMaxId();

    boolean addValue(Value value);

    boolean updateValue(Value value);

    boolean deleteValue(Integer id);
}
