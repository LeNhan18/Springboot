package com.example.demo.Service.IMP;

import com.example.demo.DTO.FoodDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

public interface MenuServiceIMP {
    boolean insertMenu(MultipartFile file,String tiltle
            ,boolean isfreeship);
    List<FoodDTO> getMenu = new ArrayList<>();
}
