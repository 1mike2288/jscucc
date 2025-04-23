package com.wj.jscucc.util;



import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.wj.jscucc.entity.Admin;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/*
 * 使用AOP记录异常日志
 */

@Component
@Aspect
public class ExceptionLogger {

    @Resource
    HttpServletRequest request;

    //环绕通知
    @Around("within(com.wj.jscucc..*)")
    public Object log(ProceedingJoinPoint p) {
        Object obj = null;
        String str="";
        try {

            obj = p.proceed();

        } catch (Throwable e) {
            Admin admin = (Admin)request.getSession().getAttribute("admin");
            if(admin!=null) {
                String account = admin.getAccount();

                str="账号:"+account+",";
            }
            //获取ip地址
            String ip = request.getRemoteHost();
            String time = TimeUtil.getTimeNow();
            //获取出现异常的类名
            String className = p.getTarget().getClass().getName();
            //获取出现异常的方法名称
            String methodName = p.getSignature().getName();
            str=str+"ip:"+ip+",时间:"+time+
                    ",\n异常类名:"+className+",\n异常方法:"+methodName+
                    ",\n异常类型:"+e.toString();

            System.out.println(str);
            //记录完日志之后，将异常跑出，
            //由ExceptionResolver继续处理
            throw new RuntimeException(e);
        }
        //目标组件的返回值，用来找转发页面
        return obj;
    }

}
