package com.rutu.twitter.notificationms.service;

import com.rutu.twitter.notificationms.dto.NotificationDTO;
import com.rutu.twitter.notificationms.exception.BaseException;

import java.util.List;

public interface NotificationService {
    NotificationDTO createNotification(NotificationDTO notificationDTO);

    NotificationDTO getNotificationById(Long id) throws BaseException;

    List<NotificationDTO> getNotificationsByUserId(Long userId);

    NotificationDTO updateNotification(Long id, NotificationDTO notificationDTO);

    void deleteNotification(Long id);
}
