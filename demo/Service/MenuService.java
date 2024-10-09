package com.example.demo.Service;

import com.example.demo.DTO.FoodDTO;
import com.example.demo.Entity.Food;
import com.example.demo.Respository.MenuRepository;
import com.example.demo.Service.IMP.MenuServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService implements MenuServiceIMP {
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    FileService fileService;
    @Override
    public boolean insertMenu(MultipartFile file, String tiltle, boolean isfreeship) {
        boolean flag = false;
        try{
            boolean isSucessFile = fileService.SaveFile(file);
            if(isSucessFile){
                Food f = new Food();
                f.setTitle(tiltle);
                f.setImage(file.getOriginalFilename());
                menuRepository.save(f);
                flag = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    public List<Food> getMenu(){
        List<Food> menu = menuRepository.findAll();
        List<FoodDTO> foodDTOS = new ArrayList<>();
        PageRequest pageRequest = PageRequest.of(0, 8);
        Page<Food> foodPage = menuRepository.findAll(pageRequest);
        for (FoodDTO foodDTO : foodDTOS) {
            Food food = new Food();
            food.setTitle(foodDTO.getTitle());
            food.setImage(foodDTO.getImage());
            food.setfreeship(foodDTO.isIsfreeship());
            menu.add(food);
        }
        return menu;
    }
}
