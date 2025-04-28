package com.rutu.twitter.notificationms.controller;

import com.rutu.twitter.notificationms.dto.NotificationDTO;
import com.rutu.twitter.notificationms.exception.BaseException;
import com.rutu.twitter.notificationms.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public ResponseEntity<NotificationDTO> createNotification(@RequestBody NotificationDTO notificationDTO) {
        return ResponseEntity.ok(notificationService.createNotification(notificationDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificationDTO> getNotificationById(@PathVariable Long id) throws BaseException {
        NotificationDTO notificationDTO = notificationService.getNotificationById(id);
        if (notificationDTO != null) {
            return ResponseEntity.ok(notificationDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<NotificationDTO>> getNotificationsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(notificationService.getNotificationsByUserId(userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotificationDTO> updateNotification(@PathVariable Long id, @RequestBody NotificationDTO notificationDTO) {
        NotificationDTO updatedNotificationDTO = notificationService.updateNotification(id, notificationDTO);
        if (updatedNotificationDTO != null) {
            return ResponseEntity.ok(updatedNotificationDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
        return ResponseEntity.noContent().build();
    }
}
