package com.mx.spring.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mx.spring.aop.Log;
import com.mx.spring.controller.request.UserRequest;
import com.mx.spring.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping("/getAll")
    public Object getAllUser(){
        PageHelper.startPage(0, 3);
        List<Map> list = userDAO.getAllUser();
        PageInfo<Map> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    //添加日志记录功能
    @RequestMapping("/addUser")
    //应该在service层使用
    @Transactional
    @Log(tableName = "user", param = {})
    public Object addUser(UserRequest userRequest){
        userDAO.addUser(userRequest);
//        int i = 1/0;
        return null;
    }

    @RequestMapping("/getException")
    public Object getException(){
        int i = 1/0;
        return i;
    }
}
