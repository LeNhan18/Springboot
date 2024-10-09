package com.example.demo.Controller;

import com.example.demo.Service.IMP.UserServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceIMP userServiceimp;
    @GetMapping("")
    public ResponseEntity<?> getAllUser() {
        return new  ResponseEntity<>(userServiceimp.getAllUsers(), HttpStatus.OK);
    }

}
