package com.mx.spring.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler
    public Object processException(Exception e){
        System.out.println("捕获到了异常!!!!");
        e.printStackTrace();
        Map map = new HashMap();
        map.put("status", "500");
        map.put("data", stackTraceToString(e));
        return map;
    }

    public static String stackTraceToString(Throwable e) {
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            return sw.toString();
        } catch (Exception var3) {
            return "bad stack2string";
        }
    }
}
