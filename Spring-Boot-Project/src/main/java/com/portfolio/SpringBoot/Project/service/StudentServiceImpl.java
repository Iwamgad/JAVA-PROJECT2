package com.portfolio.SpringBoot.Project.service;

import com.portfolio.SpringBoot.Project.entity.Student;
import com.portfolio.SpringBoot.Project.error.StudentNotFoundException;
import com.portfolio.SpringBoot.Project.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getStudentList() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long studentId) throws StudentNotFoundException {

        Optional<Student> student = studentRepository.findById(studentId);

        if(!student.isPresent()){
            throw new StudentNotFoundException("Student Not Available");
        }

        return student.get();
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student updateStudentById(Long studentId, Student student) {
        Student studentDB = studentRepository.findById(studentId).get();

        if(Objects.nonNull(student.getName()) &&
                !"".equalsIgnoreCase(student.getName())){
            studentDB.setName(student.getName());
        }

        if(Objects.nonNull(student.getEmail()) &&
                !"".equalsIgnoreCase(student.getEmail())){
            studentDB.setEmail(student.getEmail());
        }

        if(Objects.nonNull(student.getDob()) &&
                !"".equalsIgnoreCase(student.getDob().toString())){
            studentDB.setDob(student.getDob());
        }

        if(Objects.nonNull(student.getAge()) &&
                !"".equalsIgnoreCase(student.getAge().toString())){
            studentDB.setAge(student.getAge());
        }
        return studentRepository.save(studentDB);
    }

    // No predefined method available in out JPA repository it should be written by us
    @Override
    public Student getStudentByName(String name) {return studentRepository.findByNameIgnoreCase(name);}



}
