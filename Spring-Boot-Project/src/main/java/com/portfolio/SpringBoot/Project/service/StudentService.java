package com.portfolio.SpringBoot.Project.service;

import com.portfolio.SpringBoot.Project.entity.Student;
import com.portfolio.SpringBoot.Project.error.StudentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {

   public Student saveStudent(Student student);

   public List<Student> getStudentList();

   public Student getStudentById(Long studentId) throws StudentNotFoundException;


   public void deleteStudentById(Long studentId);

   public Student updateStudentById(Long studentId, Student student);

   public Student getStudentByName(String name);
}
