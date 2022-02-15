package com.bjpowernode.test;

import com.bjpowernode.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class mybatisTest {
    public static void main(String[] args) {
        InputStream in = null;

        //获取SqlSession对象
        try {
            in = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactoryBuilder bulider = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = bulider.build(in);
        SqlSession session = factory.openSession();
//        session.insert("com.bjpowernode.dao.studentDao.insertStu",new Student(5,"LT","1601"));
        List<Student> stus = session.selectList("com.bjpowernode.dao.studentDao.selectAll");
        for (Student stu:stus) {
            System.out.println(stu);
        }
        session.update("com.bjpowernode.dao.studentDao.update",new Student(5,"刃下心","0000"));
        session.delete("com.bjpowernode.dao.studentDao.delete",1);
        session.commit();
        session.close();
    }
}
