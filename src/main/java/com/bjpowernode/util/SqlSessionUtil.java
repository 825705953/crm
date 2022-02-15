package com.bjpowernode.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {
//构造方法私有化，在工具类外没有必要创建工具类对象（静态方法直接用类名调用）
    private SqlSessionUtil(){}
    private static InputStream in;
    private static SqlSessionFactory factory;
    static {
        try {
            in = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        factory = new SqlSessionFactoryBuilder().build(in);
    }
//ThreadLocal 基于当前线程的存取机制，只要当前线程还在，里面保存的变量就在
//保证SqlSession只创建一个，当这个工具类被同时调用时，不会创建多个SqlSession
//确保事务生效
    private static ThreadLocal<SqlSession> t = new ThreadLocal<>();

    public static SqlSession getSession(){
        SqlSession session = t.get();
//如果ThreadLocal中没有SqlSession对象，那就创建一个（往往是第一次执行）；如果有，直接拿来用，确保只有一个SqlSession对象
        if (session == null){
            session = factory.openSession();
            t.set(session);
        }
        return session;
    }

//关闭SqlSession
    public static void sessionClose(SqlSession session){
        if (session != null){
            session.close();
//关闭SqlSession的同时，从ThreadLocal中移除SqlSession，因为线程并未被销毁（回到线程池中），必须将该线程中的SqlSession剥离，防止该线程再次被分配时造成SqlSession状态的混乱
            t.remove();
        }
    }
}
