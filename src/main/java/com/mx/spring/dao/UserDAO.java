package com.mx.spring.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDAO {

    public List<Map> getAllUser();
}
