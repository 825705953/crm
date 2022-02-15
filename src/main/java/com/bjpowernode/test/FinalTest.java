package com.bjpowernode.test;

import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import com.bjpowernode.service.impl.StudentServiceImpl;
import com.bjpowernode.util.ServiceFactory;

import java.util.List;

public class FinalTest {
    public static void main(String[] args) {
        //获取业务层代理对象（统一处理事务）
        StudentService service = (StudentService) ServiceFactory.getService(new StudentServiceImpl());
        //使用代理对象调用业务层方法
//        Student s = new Student();
//        s.setId(10);
//        s.setName("xxx");
//        s.setClassroom("1001");
//        service.insert(s);
//        List<Student> stus = service.selectAll();
//        for (Student stu:stus){
//            System.out.println(stu);
//        }
//
//        Student s = new Student();
//        s.setName("y");
//        s.setClassroom("0");
//        List<Student> slist = service.selectWhere(s);
//        for (Student stu:slist){
//            System.out.println(stu);
//        }
        Integer[] idList = {1,2,3};
        List<Student> slist = service.selectForeach(idList);
        for(Student s:slist){
            System.out.println(s);
        }
    }
}
