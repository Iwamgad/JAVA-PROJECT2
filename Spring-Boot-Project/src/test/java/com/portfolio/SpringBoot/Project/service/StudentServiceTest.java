package com.portfolio.SpringBoot.Project.service;

import com.portfolio.SpringBoot.Project.entity.Student;
import com.portfolio.SpringBoot.Project.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceTest {
    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        Student student =
                Student.builder()
                        .name("Kalab")
                        .age(27)
                        .email("kalab@gmail.com")
                        .dob(LocalDate.parse("2007-10-13"))
                        .id(2L)
                        .build();

        Mockito.when(studentRepository.findByNameIgnoreCase("Kalab"))
                .thenReturn(student);
    }

    @Test
    @DisplayName("Get Data Based on Valid Student name")
    public void whenValidStudentName_thenStudentShouldBeFound(){
        String studentName = "Kalab";
        Student found =
                studentService.getStudentByName(studentName);
        assertEquals(studentName, found.getName());
    }
}