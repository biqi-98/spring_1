package com.lagou.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/*
    事务管理器工具类：包含：开启事务、提交事务、回滚事务、释放资源
     通知类
 */
@Component("TranManager")
@Aspect //表明该类为切面类
public class TranManager {

    @Autowired
    private ConnectionUtils connectionUtils;


        @Around("execution(* com.lagou.servlet.impl.ArticleServiceImpl.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws SQLException {

        Object proceed = null;
        try {
            // 开启手动事务
            connectionUtils.getThreadConnection().setAutoCommit(false);
            // 切入点方法执行
            proceed = pjp.proceed();

            // 手动提交事务
            connectionUtils.getThreadConnection().commit();

        } catch (Throwable throwable) {
            throwable.printStackTrace();
            // 手动回滚事务
            connectionUtils.getThreadConnection().rollback();

        } finally {
            // 将手动事务恢复成自动事务
            connectionUtils.getThreadConnection().setAutoCommit(true);
            // 将连接归还到连接池
            connectionUtils.getThreadConnection().close();
            // 解除线程绑定
            connectionUtils.removeThreadConnection();

        }


        return  proceed;
    }

    public void begin() {
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void commit() {
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void rollback() {
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void release() {
        try {
            connectionUtils.getThreadConnection().setAutoCommit(true);
            connectionUtils.getThreadConnection().close();
            connectionUtils.removeThreadConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


