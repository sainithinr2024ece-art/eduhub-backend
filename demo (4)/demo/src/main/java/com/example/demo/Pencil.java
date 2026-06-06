package com.example.demo;

import org.springframework.stereotype.Component;

@Component("Pencil")
public class Pencil implements  Writer{

    public void write(){
        System.out.println("write by pencil");
    }

}