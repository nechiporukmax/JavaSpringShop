package org.example.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service("fileService")
public class FileService {

    public static final String SAVE_LOCATION = "/Uploads/";

    public boolean saveFile(MultipartFile multipartFile){
        boolean result = false;
        String fileName  = multipartFile.getOriginalFilename();
        String location = SAVE_LOCATION;
        File pathFile = new File(location);
        if(!pathFile.exists()){
            pathFile.mkdir();
        }

        pathFile = new File(location + fileName);
        try {
            multipartFile.transferTo(pathFile);
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}