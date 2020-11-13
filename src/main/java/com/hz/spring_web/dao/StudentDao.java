package com.hz.spring_web.dao;

import com.hz.spring_web.domain.Student;

import java.util.List;

public interface StudentDao {

    int insertStudent(Student student);

    List<Student> selectStudents();
}
