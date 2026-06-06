package com.eduhub.eduhub_backend.controller;

import com.eduhub.eduhub_backend.component.Course;
import com.eduhub.eduhub_backend.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.MethodNotAllowedException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    List<Course> courseList=new ArrayList<>();
    // we can achieve this using static block
    public  CourseController(){
        courseList.add(new Course(1,"java",4));
        courseList.add(new Course(2,"python",4));
        courseList.add(new Course(3,"cpp",4));
        courseList.add(new Course(4,"adc",4));
        courseList.add(new Course(5,"mpes",4));

    }

    @GetMapping
    public ResponseEntity<List<Course>> getCourses(){
        return new ResponseEntity<>(courseList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public  ResponseEntity<Course> getCourseByCode(@PathVariable("id") int id){
        return courseList.stream().filter(c->c.getCourseCode()==id).findFirst().map(ResponseEntity::ok)
                .orElseThrow(()-> new ResourceNotFoundException("Course","CourseCode",id));
    }

    @GetMapping("{id}/query")
    public  ResponseEntity<Course> getCourseByPathAndQuery(@PathVariable("id") int id, @RequestParam String name){
        return courseList.stream().filter(c->c.getCourseCode()==id && c.getSubjectName().equalsIgnoreCase(name)).findFirst().map(ResponseEntity::ok)
                .orElseThrow(()-> new ResourceNotFoundException("Course","CourseCode",id));
    }

    @PostMapping("/add")
    public ResponseEntity addCourse(@RequestBody
                                    Course course){

        courseList.add(course);
        return ResponseEntity.accepted().body("Added");
    }


    @PutMapping("{id}/{updatedName}")
    public ResponseEntity updateCourse(@PathVariable("id") int id,
                                       @PathVariable("updatedName") String name ){

        Course course= courseList.stream().filter(c->c.getCourseCode()==id).findFirst()
                .orElseThrow(()-> new ResourceNotFoundException("Course","CourseCode",id));
        course.setSubjectName(name);
        return  ResponseEntity.ok(course);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity deleteCourse(@PathVariable("id") int id){
        Course course= courseList.stream().filter(c->c.getCourseCode()==id).findFirst()
                .orElseThrow(()-> new ResourceNotFoundException("Course","CourseCode",id));
        courseList.remove(course);
        return ResponseEntity.accepted().body("deleted");

    }
}