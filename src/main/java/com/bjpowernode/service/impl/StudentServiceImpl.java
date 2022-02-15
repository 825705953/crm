package com.bjpowernode.service.impl;

import com.bjpowernode.dao.studentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import com.bjpowernode.util.SqlSessionUtil;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    @Override
    public Student selectStu(Integer id) {
        studentDao dao = SqlSessionUtil.getSession().getMapper(studentDao.class);
        return dao.selectStu(id);

    }

    @Override
    public List<Student> selectAll() {
        studentDao dao = SqlSessionUtil.getSession().getMapper(studentDao.class);
        return dao.selectAll();
    }

    @Override
    public int insert(Student student) {
        studentDao dao = SqlSessionUtil.getSession().getMapper(studentDao.class);
        return dao.insert(student);
    }

    @Override
    public List<Student> selectOne(String value) {
        studentDao dao = SqlSessionUtil.getSession().getMapper(studentDao.class);
        return dao.selectOne(value);
    }

    @Override
    public List<Student> selectWhere(Student student) {
        studentDao dao = SqlSessionUtil.getSession().getMapper(studentDao.class);
        return dao.selectWhere(student);
    }

    @Override
    public List<Student> selectForeach(Integer[] idList) {
        studentDao dao = SqlSessionUtil.getSession().getMapper(studentDao.class);
        return dao.selectForeach(idList);
    }
}
