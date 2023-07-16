package com.portfolio.SpringBoot.Project.controller;

import com.portfolio.SpringBoot.Project.entity.Student;
import com.portfolio.SpringBoot.Project.error.StudentNotFoundException;
import com.portfolio.SpringBoot.Project.service.StudentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Logger
    private final Logger LOGGER = LoggerFactory.getLogger(Student.class);

    // Saves students to the database

    @PostMapping()
    public Student saveStudent(@Valid @RequestBody Student student){
        LOGGER.info("Inside saveStudent of Student Controller ");
        return studentService.saveStudent(student);
    }

    // Gets all the students from the database
    @GetMapping()
    public List<Student> getStudentList(){
        LOGGER.info("Inside getStudentList of Student Controller ");
        return studentService.getStudentList();
    }

    // Gets a student by ID

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") Long studentId)
            throws StudentNotFoundException {
        LOGGER.info("Inside getStudentById of Student Controller ");
        return studentService.getStudentById(studentId);
    }

    // Deletes a student by ID

    @DeleteMapping("/{id}")
    public String deleteStudentById(@PathVariable("id") Long studentId){
        LOGGER.info("Inside deleteStudentById of Student Controller ");
        studentService.deleteStudentById(studentId);
        return "Student deleted successfully !!!";
    }

    // Updates a student by Id

    @PutMapping("/{id}")
    public Student updateStudentById(@PathVariable("id") Long studentId,
                                     @RequestBody Student student){
        LOGGER.info("Inside updateStudentById of Student Controller ");
        return studentService.updateStudentById(studentId, student);
    }


    @GetMapping("/name/{name}")
    public Student getStudentByName(@PathVariable("name") String name){
        LOGGER.info("Inside getStudentByName of Student Controller ");
        return studentService.getStudentByName(name);
    }




}
