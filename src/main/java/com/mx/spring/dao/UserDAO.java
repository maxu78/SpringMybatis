package com.mx.spring.dao;

import com.mx.spring.controller.request.UserRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

//由于在MybatisMapperScannerConfig中配置了扫描类,所以此包下的均不要添加mapper注解
public interface UserDAO {

    public List<Map> getAllUser();

    public void addUser(UserRequest userRequest);
}
