package com.example.demo.Security;

import com.example.demo.Entity.Users;
import com.example.demo.Respository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    UserRespository userRespository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRespository.findByUserName(username);
        if(users == null){
            throw new UsernameNotFoundException("User not found");
        }
        return new User(username,users.getPassword(),new ArrayList<>());
    }
}
