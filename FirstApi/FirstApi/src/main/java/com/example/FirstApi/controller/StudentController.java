package com.example.FirstApi.controller;

import com.example.FirstApi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    StudentService s;
    @GetMapping("/name")
        public String Name(){
            return s.Name();
        }
    @GetMapping("/dept")
       public String Dept(){
           return s.Dept();
       }
    @GetMapping("/course")
       public String Course(){
           return s.Course();
    }
}
