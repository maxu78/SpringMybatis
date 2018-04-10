package com.mx.spring.dao;

import com.mx.spring.aop.request.LogRequest;
import org.apache.ibatis.annotations.Mapper;

public interface LogDAO {
    public void addLog(LogRequest logRequest);
}
