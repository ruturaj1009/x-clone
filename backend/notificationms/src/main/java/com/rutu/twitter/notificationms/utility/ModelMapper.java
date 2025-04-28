package com.rutu.twitter.notificationms.utility;

import com.rutu.twitter.notificationms.dto.NotificationDTO;
import com.rutu.twitter.notificationms.entity.Notification;

import java.time.Instant;

public class ModelMapper {
    public static NotificationDTO getNotificationDTO(Notification notification) {
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setId(notification.getId());
        notificationDTO.setUserId(notification.getUserId());
        notificationDTO.setType(notification.getType());
        notificationDTO.setReferenceId(notification.getReferenceId());
        notificationDTO.setRead(notification.isRead());
        notificationDTO.setCreatedAt(notification.getCreatedAt());
        notificationDTO.setUpdatedAt(notification.getUpdatedAt());
        return notificationDTO;
    }

    public static Notification getNotification(NotificationDTO notificationDTO) {
        Notification notification = new Notification();
        notification.setId(notificationDTO.getId());
        notification.setUserId(notificationDTO.getUserId());
        notification.setType(notificationDTO.getType());
        notification.setReferenceId(notificationDTO.getReferenceId());
        notification.setRead(notificationDTO.isRead());
        notification.setCreatedAt(notificationDTO.getCreatedAt());
        notification.setUpdatedAt(notificationDTO.getUpdatedAt());
        return notification;
    }
}
