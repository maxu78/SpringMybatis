package com.mx.spring.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter(MybatisConfig.class)
public class MybatisMapperScannerConfig {

    public MybatisMapperScannerConfig(){

    }

    /**
     * 重新定义扫描dao接口文件
     * @return
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        //设置自动扫描的dao包名
        mapperScannerConfigurer.setBasePackage("com.mx.spring.dao");
        return mapperScannerConfigurer;
    }
}
