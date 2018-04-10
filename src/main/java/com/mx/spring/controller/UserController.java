package com.mx.spring.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mx.spring.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
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
}
