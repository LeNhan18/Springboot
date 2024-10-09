package com.example.demo.Service.IMP;

import com.example.demo.DTO.RestaurantDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RestaurantServiceIMP {
    boolean insertRestaurant( MultipartFile file,
                              String title, String description,
                              boolean isfreeship,
                              String address,
                              String opendate,
                              String subtitle);
    List<RestaurantDTO> getRestaurants();
}

