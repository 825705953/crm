package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;

import java.util.List;

public interface studentDao {
    Student selectStu(Integer id);
    List<Student> selectAll();
    int insert(Student student);
    int update(Integer id);
    int delete(Integer id);
    //like模糊查询
    List<Student> selectOne(String value);
    List<Student> selectWhere(Student student);
    List<Student> selectForeach(Integer[] idList);
}
