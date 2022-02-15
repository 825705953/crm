package com.bjpowernode.util;


public class ServiceFactory {
    //传递目标对象，得到代理对象
    public static Object getService(Object service){
        TransactionInvocationHandler tih = new TransactionInvocationHandler(service);
        return tih.getProxy();
    }
}
