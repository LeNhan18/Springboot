package com.example.demo.DTO;

import lombok.Data;

import java.util.List;
@Data
public class CategoryDTO {
    private String categoryName;
    private List<FoodDTO> menus ;



}
