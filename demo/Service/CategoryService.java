package com.example.demo.Service;

import com.example.demo.DTO.CategoryDTO;
import com.example.demo.DTO.FoodDTO;
import com.example.demo.Entity.Category;
import com.example.demo.Entity.Food;
import com.example.demo.Respository.CategoryRepository;
import com.example.demo.Service.IMP.CategoryServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements CategoryServiceIMP {
    @Autowired
    CategoryRepository categoryRepository;
    public List<CategoryDTO> getCate(){
        PageRequest pageRequest = PageRequest.of(0, 2, Sort.by("id"));
        List<CategoryDTO> CateDTOs = new ArrayList<>();
        Page<Category> categoryPage = categoryRepository.findAll(pageRequest);
        for (Category category : categoryPage) {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setCategoryName(category.getNameCate());
            List<FoodDTO> menuDTO = new ArrayList<>();
            for(Food food: category.getFoodList())
            {
                FoodDTO foodDTO = new FoodDTO();
                foodDTO.setTitle(food.getTitle());
                foodDTO.setIsfreeship(food.isfreeship());
                foodDTO.setImage(food.getImage());
                menuDTO.add(foodDTO);

            }
            categoryDTO.setMenus(menuDTO);
            CateDTOs.add(categoryDTO);
        }
        return CateDTOs;
    }

}
