package com.example.demo.student;

import jakarta.persistence.*;


import java.time.LocalDate;
import java.time.Period;

@Entity
@Table

public class Student {
    @Id
    @SequenceGenerator(
            name="student_sequence",
            sequenceName ="student_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy =  GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long Id;
    private String firstName;
    private String email;
    private LocalDate dob;
    @Transient
    private Integer age;

    public Student(Long id, String name, String email, LocalDate dob) {
        Id = id;
        this.firstName = name;
        this.email = email;
        this.dob = dob;

    }

    public Student(String name, String email, LocalDate dob) {
        this.firstName = name;
        this.email = email;
        this.dob = dob;

    }

    public Student() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge()
    {
       return Period.between(this.dob,LocalDate.now()).getYears();

    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", name='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
