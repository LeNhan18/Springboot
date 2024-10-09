package com.example.demo.Controller;


import com.example.demo.PayLoad.ResponiseData;
import com.example.demo.Service.IMP.CategoryServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("")
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryServiceIMP categoryServiceIMP;
    @GetMapping("")
    public ResponseEntity<?> getCategory() {
        ResponiseData data = new ResponiseData();
        data.setData(categoryServiceIMP.getCate());
        return new ResponseEntity<>(data, HttpStatus.OK);

     }

}
