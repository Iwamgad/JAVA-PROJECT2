package com.portfolio.SpringBoot.Project.repository;

import com.portfolio.SpringBoot.Project.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Student student =
                Student.builder()
                        .name("Kalab")
                        .age(27)
                        .email("kalab@gmail.com")
                        .dob(LocalDate.parse("2007-10-13"))
                        .build();

        entityManager.persist(student);
    }

    @Test
    public void whenFindById_thenReturnStudent(){
        Student student = studentRepository.findById(1L).get();
        assertEquals(student.getName(), "Kalab");
    }
}