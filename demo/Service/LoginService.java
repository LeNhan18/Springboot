package com.example.demo.Service;

import com.example.demo.DTO.UsersDTO;
import com.example.demo.Entity.Roles;
import com.example.demo.Entity.Users;
import com.example.demo.PayLoad.SignUpRequest;
import com.example.demo.Respository.UserRespository;
import com.example.demo.Service.IMP.LoginServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class LoginService implements LoginServiceIMP {
    @Autowired
    UserRespository userrepository;
    @Autowired
    PasswordEncoder passwordEncoder;
//    @Override
//    public List<UsersDTO> testEmail(String email) {
//        List<UsersDTO> u = new ArrayList<>();
//        List<Users> list = userrepository.findByEmail(email);
//        for( Users user : list ){
//            UsersDTO userDTO = new UsersDTO();
//            userDTO.setEmail(user.getEmail());
//            u.add(userDTO);
//        }
//        return u;
//    }

    @Override
    public List<UsersDTO> getAllUsers() {
        //Truy xuất tất cả người dùng từ cơ sở dữ liệu thông qua userrepository.findAll().
        //Chuyển đổi các Usersthực thể thành UsersDTOdữ liệu trừu tượng nhạy cảm (như mật khẩu) và chỉ trả về thông tin cần thiết.
        List<Users> listUsers = userrepository.findAll();
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

    @Override
    public Boolean login(String email, String password) {
        /*
        Phương pháp này sử dụng tên người dùng và mật khẩu làm đầu vào.
         Nó lấy Usersđối tượng dựa trên tên người dùng bằng cách sử dụng userrepository.findByUserName(username).
        Nó được sử dụng PasswordEncoder.matches(password, listuser.getPassword())để kiểm tra xem mật khẩu được cung cấp có khớp với mật khẩu được mã hóa lưu trữ trong cơ sở dữ liệu hay không.
         */
       Users listuser = userrepository.findByEmail(email);
        return passwordEncoder.matches(password, listuser.getPassword());
    }

    @Override
    public Boolean addUser(SignUpRequest signUpRequest) {
        Roles role = new Roles();
        role.setId(signUpRequest.getRoleID());
        Users user = new Users();
        user.setUserName(signUpRequest.getFullName());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(signUpRequest.getPassword());
        user.setRole(role);
        try{
            userrepository.save(user);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    //Dependency enjection


}
