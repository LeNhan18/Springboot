package com.example.demo.Service;

import com.example.demo.Service.IMP.FileServiceIMP;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
@Service
public class FileService implements FileServiceIMP {
    @Value("${fileUpload.rootpath}")
    private String rootPath;
    private Path root ;

    private void init(){
       try{
           root= Paths.get(rootPath);
           if(Files.notExists(root)){
               Files.createDirectories(root);
           }
       }catch (Exception e){
           System.out.println("Error create failder root");
       }
    }
    @Override
    public boolean SaveFile(MultipartFile file) {
      try{
          init();
          Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING );//ghi đè tên file bị trùng, chúng ta muốn di chuyển đến một tệp đến thư mục mới, giữ nguyên tên tệp và thay thế bằng bất kì tệp nào có tên trong thư mục đó

          return true;

      }catch (Exception e){
          System.out.println("Errot save file"+e.getMessage());
          return false;
      }
    }

    @Override
    public Resource LoadFile(String filename) {
        try{
            init();
            //resolve đại diện cho dấu /
            Path file = root.resolve(filename);// tạo ra một đường dẫn tới file người dùng yêu cầu
            Resource resource = new UrlResource(file.toUri());//sau đó biến đường dẫn đó thành cái resource
            //resource.exists thông qua đối tượng resource kiểm tra xem file đó có tồn tại hay khôg
            //resource.isReadable FILE có được phép đọc hay không
            if(resource.exists()||resource.isReadable()){
                return resource;//nếu được trả resource đó ra
            }
            else{
                throw new RuntimeException("Could not read the file");//ném ra ngoại lệ runtimeException và in ra không đọc được filez`
            }
        }catch (Exception e){
            System.out.println("Erro load file"+e.getMessage());
        }

        return null;
    }
}
