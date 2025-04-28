package com.rutu.twitter.mediams.service.impl;

import com.cloudinary.Cloudinary;
import com.rutu.twitter.mediams.service.CloudinaryService;
import com.rutu.twitter.mediams.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service("cloudinaryService")
public class CloudinaryServiceImpl implements CloudinaryService {

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public String uploadFile(MultipartFile file, String folderName) {
        try {
            HashMap<Object, Object> options = new HashMap<>();
            options.put("folder", folderName);
            options.put("public_id", UUID.randomUUID().toString());
            byte[] resizedImage = Utility.getResizedImage(file, 300, 300);
            Map uploadedFile = cloudinary.uploader().upload(resizedImage, options);
            System.out.println(uploadedFile);
            return (String) uploadedFile.get("url");
//            String publicId = (String) uploadedFile.get("public_id");
//            return cloudinary.url().secure(true).generate(publicId);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//public String deleteImage(String publicId) {
//    try {
//        // Pass options if needed (e.g., invalidate cache)
//        Map<String, Object> options = new HashMap<>();
//        options.put("invalidate", true); // Optional: Invalidate cached versions
//
//        // Perform the delete operation
//        Map result = cloudinary.uploader().destroy(publicId, options);
//
//        return result.toString(); // Returns a response like {result=ok}
//    } catch (IOException e) {
//        e.printStackTrace();
//        return "Error deleting image";
//    }
//}
