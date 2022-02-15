package com.bjpowernode.test;

import com.bjpowernode.domain.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("appliction/json;charset=utf-8");
        System.out.println("欢迎使用servlet！");
        //验证异步操作
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

////        返回字符串
////        PrintWriter out = resp.getWriter();
////        out.print("Hello World");
////        //响应流不手动关闭也行，tomcat会帮你关（但仅限于响应流）
////        out.close();

        //返回json格式的数据
        //手动拼接json
        //{"id":,"name":"","age":}
        Student stu = new Student(1,"张三","1601");
        String str = "{\"id\":"+stu.getId()+",\"name\":\""+stu.getName()+"\",\"age\":"+stu.getClassroom()+"}";
        System.out.println(str);
        PrintWriter out = resp.getWriter();
        out.print(str);
    }
}
