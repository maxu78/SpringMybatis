package com.mx.spring.dao;

import com.mx.spring.controller.request.UserRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDAO {

    public List<Map> getAllUser();

    public void addUser(UserRequest userRequest);
}
