package com.example.demo.Service.IMP;

import com.example.demo.DTO.UsersDTO;
import com.example.demo.PayLoad.SignUpRequest;

import java.util.List;
public interface LoginServiceIMP {
    List<UsersDTO> getAllUsers();
    Boolean login(String email, String password);
    Boolean addUser(SignUpRequest signUpRequest);
//    List<UsersDTO> testEmail(String email);
}
