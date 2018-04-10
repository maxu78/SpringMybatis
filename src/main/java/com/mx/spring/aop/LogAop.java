package com.mx.spring.aop;

import com.mx.spring.aop.request.LogRequest;
import com.mx.spring.dao.LogDAO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Configuration
@Aspect
public class LogAop {

    @Autowired
    private LogDAO logDAO;

    @Pointcut("@annotation(com.mx.spring.aop.Log)")
    public void pointCut(){}

    @After("pointCut()")
    public void recordLog(JoinPoint jp){
        MethodSignature methodSignature = (MethodSignature) jp.getSignature();
        Method method = methodSignature.getMethod();
        Log log = method.getAnnotation(Log.class);
        if(log != null){
            //获取taskId
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            String taskId = sdf.format(new Date());
            //获取参数
            String[] param = log.param();
            String table = log.tableName();
            String detail = "";
            for(String single : param){
                detail += single + ",";
            }
            if(detail != null && detail.length()>0){
                detail = detail.substring(0, detail.length()-1);
                detail += " ||| ";
            }

            //记录入参
            detail += Arrays.toString(jp.getArgs());

            LogRequest logRequest = new LogRequest();
            logRequest.setTaskId(taskId);
            logRequest.setTableName(table);
            logRequest.setDetail(detail);
            logDAO.addLog(logRequest);
        }
    }
}
