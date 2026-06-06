package com.eduhub.eduhub_backend.controller;

import com.eduhub.eduhub_backend.component.User;
import com.eduhub.eduhub_backend.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    static ArrayList<User> userList = new ArrayList<>();

    static {
        userList.add(new User(1, "jeeva", "jsikhi"));
        userList.add(new User(2, "sanjay", "hii"));
        userList.add(new User(3, "raj", "hello8"));
        userList.add(new User(4, "gopal", "65the"));
        userList.add(new User(5, "prabhu", "jai10"));
    }

    // GET ALL USERS
    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    // GET USER BY ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id) {

        return userList.stream()
                .filter(c -> c.getUserId() == id)
                .findFirst()
                .map(ResponseEntity::ok)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User", "UserId", id));
    }

    // GET USER BY ID AND QUERY PARAM
    @GetMapping("/{id}/query")
    public ResponseEntity<User> getUserByPathAndQuery(
            @PathVariable("id") int id,
            @RequestParam String name) {

        return userList.stream()
                .filter(c ->
                        c.getUserId() == id &&
                                c.getUserName().equalsIgnoreCase(name))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User",
                                "UserId & UserName",
                                id));
    }

    // ADD USER
    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user) {

        userList.add(user);

        return ResponseEntity.ok("User Added Successfully");
    }

    // UPDATE USER
    @PutMapping("/{id}/{updatedName}")
    public ResponseEntity<User> updateUser(
            @PathVariable("id") int id,
            @PathVariable("updatedName") String name) {

        User user = userList.stream()
                .filter(c -> c.getUserId() == id)
                .findFirst()
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User",
                                "UserId",
                                id));

        user.setUserName(name);

        return ResponseEntity.ok(user);
    }

    // DELETE USER
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {

        User user = userList.stream()
                .filter(c -> c.getUserId() == id)
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException("can't delete"));

        userList.remove(user);

        return ResponseEntity.ok("Deleted Successfully");
    }
}