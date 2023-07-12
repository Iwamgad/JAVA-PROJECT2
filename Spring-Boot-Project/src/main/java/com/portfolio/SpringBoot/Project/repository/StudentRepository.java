package com.portfolio.SpringBoot.Project.repository;

import com.portfolio.SpringBoot.Project.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
