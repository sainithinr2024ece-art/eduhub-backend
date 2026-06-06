package com.eduhub.eduhub_backend.controller;

import com.eduhub.eduhub_backend.component.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @GetMapping("student")
    public ResponseEntity<Student>getStudent(){
        Student student=new Student();
        return new ResponseEntity<>(student,HttpStatus.OK);
    }
    @GetMapping("students")
    public ResponseEntity<List<Student>>getStudents(){
        List<Student> studentList=new ArrayList<>();
        studentList.add(new Student());
        studentList.add(new Student());
        studentList.add(new Student());
        studentList.add(new Student());
        return new ResponseEntity<>(studentList,HttpStatus.OK);
    }
    //http://localhost:8080/1/Sai/Nithin
    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student>studentPathVariable(@PathVariable("id")int studentId,
                                                      @PathVariable("first")String firstname,
                                                      @PathVariable("last")String lastname){
        Student student=new Student(studentId,firstname,lastname);
        //return new ResponseEntity<>(student,HttpStatus.OK);
        return ResponseEntity.ok(student);
    }
//http://localhost:8080/query?Id=1&firstname="sai"&lastname="Nithin"
    @GetMapping("query")
    public ResponseEntity<Student>studentRequestVariable(@RequestParam int Id,
                                                         @RequestParam String firstname,
                                                         @RequestParam String lastname){
        Student student=new Student(Id,firstname,lastname);
        return ResponseEntity.ok(student);
    }
    @PostMapping("Create")
    public ResponseEntity<Student>createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }
    //http:localhost:8080/1/update
    @PutMapping("{id}/update")
    public ResponseEntity updateStudent(@PathVariable("id")int studentId,
                                        @RequestBody Student student){
        return ResponseEntity.accepted().body(student);
    }
    //http:localhost:8080/1/Delete
    @DeleteMapping("{id}/delete")
    public ResponseEntity deleteStudent(@PathVariable("id")int studentId){
        return ResponseEntity.accepted().body("Data removed successfully");
    }

}
