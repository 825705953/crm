package com.bjpowernode.test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestServlet02 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if ("/test02-select.do".equals(path)){
            select(req,resp);
        }else if ("/test02-delete.do".equals(path)){
            delete(req,resp);
        }else if ("/test02-update.do".equals(path)){
            update(req,resp);
        }else if ("/test02-add.do".equals(path)) {
            add(req,resp);
        }
    }

    private void select(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("查");
    }
    private void delete(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("删");
    }
    private void update(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("改");
    }
    private void add(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("增");
    }
}
