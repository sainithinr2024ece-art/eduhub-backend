package com.example.FirstApi.controller;

import com.example.FirstApi.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    HelloService s;
    @GetMapping("/")
    public String greet(){
        return s.greet();
    }
    @GetMapping("/about")
    public String aboutus(){
        return s.aboutus();
    }
    @GetMapping("/about/contact")
    public String contact(){
        return s.contact();
    }

}
