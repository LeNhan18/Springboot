package com.example.demo.Service;

import com.example.demo.DTO.UsersDTO;
import com.example.demo.Entity.Users;
import com.example.demo.Respository.UserRespository;
import com.example.demo.Service.IMP.UserServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService implements UserServiceIMP {
    @Autowired
    UserRespository userRespository;

    @Override
    public List<UsersDTO> getAllUsers() {
        List<Users> listUsers = userRespository.findAll();
        List<UsersDTO> usersList = new ArrayList<>();
        for (Users user : listUsers) {
            UsersDTO userDTO = new UsersDTO();
            userDTO.setUserName(user.getUserName());
            userDTO.setEmail(user.getEmail());
            userDTO.setPassword(user.getPassword());
            usersList.add(userDTO);
        }
        return usersList;
    }
}
