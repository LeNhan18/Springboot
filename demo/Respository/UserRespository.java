package com.example.demo.Respository;

import com.example.demo.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //đưa lên IOC
public interface UserRespository extends JpaRepository<Users,Integer> {
    /*
    * select * users where username "" and password""
    * */
    List<Users> findByUserNameAndPassword(String username, String password);
    Users findByUserName(String username);
     Users findByEmail(String email);
}
