package com.apps.courseAdmissionManagementBackEndApp.dao;

import java.util.List;

import com.apps.courseAdmissionManagementBackEndApp.dto.Student;

public interface StudentDao {
public Student saveStudent(Student student);
public Student getStudentById(Long studentId);
public Student deleteStudent(Long studentId);
public Student updateStudent(Student student);
public List<Student> getStudents();
}
