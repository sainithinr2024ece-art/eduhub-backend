package com.example.FirstApi.service;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class HelloService {
    @GetMapping("/")
    public String greet(){
        return "Hi frnds";
    }
    @GetMapping("/about")
    public String aboutus(){
        return "Student";
    }
    @GetMapping("/about/contact")
    public String contact(){
        return "Phone no:9761285867";
    }
}
