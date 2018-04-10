package com.mx.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用aop处理返回
 */
@Configuration
@Aspect
public class DataAop {

    @Pointcut("execution(* com.mx..*.controller..* (..))")
    public void pointCut(){}

    @Around("pointCut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        Object obj = pjp.proceed();
        Map map = new HashMap();
        map.put("status", "ok");
        map.put("data", obj);
        return map;
    }
}
