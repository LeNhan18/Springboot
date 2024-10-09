package com.example.demo.Service.IMP;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileServiceIMP {
       boolean SaveFile(MultipartFile file);
       Resource LoadFile(String filename);

}
