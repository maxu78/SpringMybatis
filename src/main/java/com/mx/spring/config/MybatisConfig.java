package com.mx.spring.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;


/**
 *  java代码配置mybatis
 */
@Configuration
@EnableTransactionManagement
public class MybatisConfig implements TransactionManagementConfigurer{

    @Autowired
    private DataSource dataSource;

    public MybatisConfig(){

    }

    /**
     * 配置sqlsessionfactory
     * @return
     */
    @Bean(name = {"sqlSessionFactory"})
    public SqlSessionFactory sqlSessionFactoryBean(){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //设置sqlSessionFactory数据源
        sqlSessionFactoryBean.setDataSource(dataSource);
        //获取mybatis配置文件解析器
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try{
            //配置mybatis的mapper xml文件位置
            sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:mybatis/mapper/**/*.xml"));
            //配置mybatis的总配置文件
            sqlSessionFactoryBean.setConfigLocation(resolver.getResource("classpath:mybatis/mybatis-config.xml"));
            return sqlSessionFactoryBean.getObject();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 配置sqlSessionTemplate
     * @param sqlSessionFactory
     * @return
     */
    @Bean(name = {"sqlSessionTemplate"})
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /**
     * 配置事务
     * @return
     */
    @Override
    @Bean(name = {"transactionManager"})
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
