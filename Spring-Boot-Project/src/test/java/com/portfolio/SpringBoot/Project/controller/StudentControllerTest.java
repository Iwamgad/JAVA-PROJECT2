package com.portfolio.SpringBoot.Project.controller;

import com.portfolio.SpringBoot.Project.entity.Student;
import com.portfolio.SpringBoot.Project.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    private Student student;

    @BeforeEach
    void setUp(){
        student = Student.builder()
                .name("Kalab")
                .age(27)
                .email("kalab@gmail.com")
                .dob(LocalDate.parse("2007-10-13"))
                .id(1L)
                .build();
    }

    @Test
    void saveStudent() throws Exception {
        Student inputStudent = Student.builder()
                .name("Kalab")
                .email("kalab@gmail.com")
                .age(27)
                .dob(LocalDate.parse("2007-10-13"))
                .build();

        Mockito.when(studentService.saveStudent(inputStudent))
                .thenReturn(student);

        mockMvc.perform(post("/api/v1/student")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"name\":\"Kalab\",\n" +
                        "\t\"email\":\"kalab@gmail.com\",\n" +
                        "\t\"dob\": \"2007-10-13\",\n" +
                        "\t\"age\": 27\n" +
                        "}"))
                .andExpect(status().isOk());
    }

    @Test
    void getStudentById() throws Exception {
        Mockito.when(studentService.getStudentById(1L))
                .thenReturn(student);

        mockMvc.perform(get("/api/v1/student/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(student.getName()));
    }
}