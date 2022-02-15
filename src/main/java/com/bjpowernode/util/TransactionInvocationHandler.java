package com.bjpowernode.util;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//动态代理，统一处理事务
public class TransactionInvocationHandler implements InvocationHandler {
    //目标对象
    private Object target;

    public TransactionInvocationHandler(Object target){
        this.target = target;
    }
    @Override
    //代理类方法，将事务提交作为切面（功能增强）
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj = null;
        SqlSession session = null;
        try{
            //获取SqlSession对象
            session = SqlSessionUtil.getSession();
            //处理业务逻辑(业务层类的业务方法，目标方法)
            obj = method.invoke(target,args);
            //处理业务逻辑完毕后，提交事务
            session.commit();
        }catch (Exception e){
            //发生异常，事务回滚
            session.rollback();
            e.printStackTrace();
        }finally {
            SqlSessionUtil.sessionClose(session);
        }
        return obj;
    }

    //创建代理对象
    public Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
    }
}
