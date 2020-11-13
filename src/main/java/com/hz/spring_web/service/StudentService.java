package com.hz.spring_web.service;

import com.hz.spring_web.domain.Student;

import java.util.List;

public interface StudentService {

    int addStudent(Student student);

    List<Student> queryStudent();
}
