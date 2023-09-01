package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration

public class StudentConfig {
    @Bean
        CommandLineRunner commandLineRunner(StudentRepository studentRepository){
            return args->{
                Student Vivek=new Student(1L,"Vivek Rana","vrana33325@gmail.com", LocalDate.of(2002, Month.JULY,3));
                Student Abhishek=new Student("Abhishek Rana","arana33325@gmail.com", LocalDate.of(1999, Month.JULY,3));
                studentRepository.saveAll(
                        List.of(Vivek,Abhishek)
                );
            };
        }
}
