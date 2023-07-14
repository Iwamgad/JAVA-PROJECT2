package com.portfolio.SpringBoot.Project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Please Add The Student Name")
    @Length(min=3)
    private String name;
    private String email;
    private LocalDate dob;
    private Integer age;

//    public Student() {
//    }
//
//    public Student(Long id,
//                   String name,
//                   String email,
//                   LocalDate dob,
//                   Integer age) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.dob = dob;
//        this.age = age;
//    }
//
//    public Student(String name,
//                   String email,
//                   LocalDate dob,
//                   Integer age) {
//        this.name = name;
//        this.email = email;
//        this.dob = dob;
//        this.age = age;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public LocalDate getDob() {
//        return dob;
//    }
//
//    public void setDob(LocalDate dob) {
//        this.dob = dob;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", dob=" + dob +
//                ", age=" + age +
//                '}';
//    }
}
