package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service

public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository= studentRepository;
    }
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional=studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()) {
            throw new IllegalStateException("Email Taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists=   studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("student with id "+ studentId+" does not exist");

        }
        studentRepository.deleteById(studentId);

    }
    @Transactional

    public void updateStudent(Long studentid, String name, String email) {
        Student student= studentRepository.findById(studentid).orElseThrow(()->new IllegalStateException("student with id "+studentid+" does not exist"));
        if(name !=null && student.getFirstName()!=name)
            student.setFirstName(name);
        if(email!=null && studentRepository.findStudentByEmail(email).isPresent()!=true)
            student.setEmail(email);
            else if (studentRepository.findStudentByEmail(email).isPresent()!=false) {
                throw new IllegalStateException("email already exists");

        }

    }
}
