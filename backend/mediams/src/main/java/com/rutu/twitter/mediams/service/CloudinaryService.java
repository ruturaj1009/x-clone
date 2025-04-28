package com.rutu.twitter.mediams.service;

import com.rutu.twitter.mediams.dto.MediaDTO;
import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {
    String uploadFile(MultipartFile file, String folderName);
}
