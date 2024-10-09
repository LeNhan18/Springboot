package com.example.demo.Controller;

import com.example.demo.PayLoad.ResponiseData;
import com.example.demo.Service.IMP.FileServiceIMP;
import com.example.demo.Service.IMP.RestaurantServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/res")
// tạo đường dẫn /res
public class RestaurantController {
    @Autowired
    FileServiceIMP fileservice;
    @Autowired
    RestaurantServiceIMP restaurantservice;
    @Autowired
    RestaurantServiceIMP restaurantserviceimp;

    @PostMapping("/nhanle")
    public ResponseEntity<ResponiseData> nhanle(@RequestParam MultipartFile file) {
        ResponiseData data = new ResponiseData();
        boolean issuccess = fileservice.SaveFile(file);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
    //lấy ra danh sách các restaurant
    @GetMapping()
    public ResponseEntity<ResponiseData> getHomeRestaurant() {
        ResponiseData data = new ResponiseData();
        data.setData(restaurantserviceimp.getRestaurants());
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

// truyền tham số vào restaurant
    @PostMapping("/lethanhnhan")
    public ResponseEntity<?> CreateRestaurant(@RequestParam MultipartFile file,
           @RequestParam String title, @RequestParam String desc,
           @RequestParam boolean isfreeship,
           @RequestParam String address,
           @RequestParam String opendate,
           @RequestParam String subtitle) {
    ResponiseData respon = new ResponiseData();
    boolean issuccess = restaurantservice.insertRestaurant(file,title,desc, isfreeship, address, opendate, subtitle);
    respon.setData(issuccess);
    return new ResponseEntity<>(respon, HttpStatus.OK);
       }
       @GetMapping("/file/{filename:.+}")
     public ResponseEntity<?> GetFileRestaurant(@PathVariable String filename) {
     Resource a=  fileservice.LoadFile(filename);
     return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+a.getFilename()+"\"").body(a);
       }

}
