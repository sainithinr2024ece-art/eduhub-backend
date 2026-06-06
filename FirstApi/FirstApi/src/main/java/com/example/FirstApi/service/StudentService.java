package com.example.FirstApi.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class StudentService {
    @GetMapping("/name")
    public String Name(){
        return "Sai Nithin";
    }
    @GetMapping("/dept")
    public String Dept(){
        return "ECE";
    }
    @GetMapping("/course")
    public String Course(){
        return "spring-boot";
    }
}
