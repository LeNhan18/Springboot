package com.example.demo.Service;

import com.example.demo.DTO.RestaurantDTO;
import com.example.demo.Entity.Ratingres;
import com.example.demo.Entity.Restaurant;
import com.example.demo.Respository.RestaurantRepository;
import com.example.demo.Service.IMP.FileServiceIMP;
import com.example.demo.Service.IMP.RestaurantServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class RestaurantService implements RestaurantServiceIMP{
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    FileServiceIMP fileservice;
    @Override
    public boolean insertRestaurant(MultipartFile file, String title, String desc, boolean isfreeship, String address, String opendate, String subtitle) {
     boolean flag = false;
        try {
            boolean isSaveFilesuccess = fileservice.SaveFile(file);
            if (isSaveFilesuccess) {
                Restaurant restaurant = new Restaurant();
                restaurant.setTitle(title);
                restaurant.setAddress(address);
                restaurant.setDescs(desc);
                restaurant.setImage(file.getOriginalFilename());
                restaurant.setSubTitle(subtitle);
                restaurant.setFreeShip(isfreeship);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date openDate = formatter.parse(opendate);
                restaurant.setOpenDate(openDate);
                restaurantRepository.save(restaurant);
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("Error insert restaurant"+e.getMessage());
        }
        return flag;
    }

    @Override
    public List<RestaurantDTO> getRestaurants() {
        //khai báo một list restaurantDTO rỗng
        List<RestaurantDTO> restaurantDTOs = new ArrayList<>();
        //PageRequest yêu cầu xem admin lấy bao nhiêu dữ liệu
        //pageNumber số trang
        //pageSize dữ liệu muốn lấy
        PageRequest pageRequest = PageRequest.of(0, 6);
        //tạo ra Page restaurant tham chiếu đến tất cả phần tử
        //truyền dữ liệu vào page request
        //findall tự động query
        Page<Restaurant> restaurants=restaurantRepository.findAll(pageRequest);
        for (Restaurant restaurant : restaurants) {
            RestaurantDTO restaurantDTO = new RestaurantDTO();
            //Lấy ra tham số titile bên restaurantDTO và get giá trị phần tử ở  Entity
            restaurantDTO.setTitle(restaurant.getTitle());
            restaurantDTO.setImage(restaurant.getImage());
            restaurantDTO.setIsfreeship(restaurant.isFreeShip());
            restaurantDTO.setSubtitle(restaurant.getSubTitle());
            restaurantDTO.setRating(calculatorRating(restaurant.getListRatingres()));
            restaurantDTOs.add(restaurantDTO);
        }
        return restaurantDTOs;
    }
    public double calculatorRating(Set<Ratingres> listRating){
        double totalpoint =0;
        for(Ratingres ratingres : listRating){
            totalpoint +=ratingres.getRatePoint();

        }
        return totalpoint/listRating.size();


    }


}
