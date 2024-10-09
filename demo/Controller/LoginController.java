package com.example.demo.Controller;

import com.example.demo.PayLoad.ResponiseData;
import com.example.demo.PayLoad.SignUpRequest;
import com.example.demo.Service.IMP.LoginServiceIMP;
import com.example.demo.Utils.JwtUtilsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:63343")
@RestController
@RequestMapping("/login")
    public class LoginController {
    @Autowired
//            @Qualifier("tenBean");
    LoginServiceIMP loginServiceimp;
    @Autowired
    JwtUtilsHelper jwtUtilsHelper;
    @PostMapping("/sigmin")
    @CrossOrigin
    public ResponseEntity<?> sigmin(@RequestParam String email, @RequestParam String password) {
        ResponiseData respon = new ResponiseData();
        System.out.println(email+" "+" "+password);

        if(loginServiceimp.login(email, password)) {
            String token  =  jwtUtilsHelper.genarateToken(email);
            respon.setData(token);

        }else{
            respon.setData(false);
            respon.setIssuccess(false);
        }

        return new  ResponseEntity<>(respon, HttpStatus.OK);
    }
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignUpRequest signUpRequest) {
        ResponiseData respon = new ResponiseData();

      respon.setData(loginServiceimp.addUser(signUpRequest));

        return new  ResponseEntity<>(respon, HttpStatus.OK);
    }
//    @GetMapping("getalluser")
//    public ResponseEntity<?> getAllUsers() {
//        ResponiseData respon = new ResponiseData();
//        respon.setData(loginServiceimp.getAllUsers());
//        return new ResponseEntity<>(respon, HttpStatus.OK);
//    }
//    @PostMapping("/nhanle")
//    public ResponseEntity<?> nhanle(@RequestParam String Email) {
//        ResponiseData respon = new ResponiseData();
//        respon.setData(loginServiceimp.testEmail(Email));
//        return new  ResponseEntity<>(respon, HttpStatus.OK);
//    }

}
