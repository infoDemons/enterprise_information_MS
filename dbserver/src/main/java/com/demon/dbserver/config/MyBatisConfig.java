package com.demon.dbserver.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 */
@Configuration
@MapperScan({"com.demon.dbserver.dao"})
public class MyBatisConfig {
}
