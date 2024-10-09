package com.example.demo.Controller;

import com.example.demo.PayLoad.ResponiseData;
import com.example.demo.Service.FileService;
import com.example.demo.Service.IMP.MenuServiceIMP;
import com.example.demo.Service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@CrossOrigin("*")
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    FileService fileService;
    @Autowired
    MenuService menuService;
    @Autowired
    MenuServiceIMP menuServiceIMP;

    @GetMapping()
    public ResponseEntity<?> getMenu() {
        ResponiseData responiseData = new ResponiseData();
        responiseData.setData(menuService.getMenu());
        return new ResponseEntity<>(responiseData, HttpStatus.OK);
    }
    @PostMapping("/insert")
    public ResponseEntity<?> CreateMenu(@RequestParam MultipartFile file
        ,@RequestParam String title
        ,@RequestParam boolean isfreeship
    ){
        ResponiseData data = new ResponiseData();
        boolean issucess = menuService.insertMenu(file,title,isfreeship);
        data.setData(issucess);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
    @GetMapping("/file/{filename:.+}")
    public ResponseEntity<?> getMenu(@PathVariable String filename) {
        Resource r = fileService.LoadFile(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+r.getFilename()+"\"").body(r);
    }
}
