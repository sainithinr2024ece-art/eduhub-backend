package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Student {
    int age;

//    Pen p;
//    @Autowired
//    Student(Pen p){
//        this.p=p;
//    }
    //Setter Injection
//    Pen p;
//    @Autowired
//    public void setP(Pen p){
//        this.p=p;
//    }
    @Autowired
    @Qualifier("Pencil")
    Writer w;
    void writes(){
        w.write();
    }
    public void study(){
        System.out.println("I am  doing engineering");
    }
}
