package com.rutu.twitter.mediams.controller;

import com.rutu.twitter.mediams.dto.MediaDTO;
import com.rutu.twitter.mediams.exception.BaseException;
import com.rutu.twitter.mediams.service.CloudinaryService;
import com.rutu.twitter.mediams.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/media")
public class MediaController {

    @Autowired
    private MediaService mediaService;

    @Autowired
    private CloudinaryService cloudinaryService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("image")MultipartFile file){
        String url = cloudinaryService.uploadFile(file,"img");
        return ResponseEntity.ok(url);
    }

    @PostMapping
    public ResponseEntity<MediaDTO> createMedia(@RequestBody MediaDTO mediaDTO) {
        return ResponseEntity.ok(mediaService.createMedia(mediaDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MediaDTO> getMediaById(@PathVariable Long id) throws BaseException {
        MediaDTO mediaDTO = mediaService.getMediaById(id);
        if (mediaDTO != null) {
            return ResponseEntity.ok(mediaDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MediaDTO> updateMedia(@PathVariable Long id, @RequestBody MediaDTO mediaDTO) {
        MediaDTO updatedMediaDTO = mediaService.updateMedia(id, mediaDTO);
        if (updatedMediaDTO != null) {
            return ResponseEntity.ok(updatedMediaDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedia(@PathVariable Long id) {
        mediaService.deleteMedia(id);
        return ResponseEntity.noContent().build();
    }
}
