package com.bjpowernode.service;

import com.bjpowernode.dao.studentDao;
import com.bjpowernode.domain.Student;

import java.util.List;

public interface StudentService {
    Student selectStu(Integer id);
    List<Student> selectAll();
    int insert(Student student);
    List<Student> selectOne(String value);
    List<Student> selectWhere(Student student);
    List<Student> selectForeach(Integer[] idList);
}
