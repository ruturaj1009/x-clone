package com.rutu.twitter.notificationms.service.impl;

import com.rutu.twitter.notificationms.dto.NotificationDTO;
import com.rutu.twitter.notificationms.entity.Notification;
import com.rutu.twitter.notificationms.exception.BaseException;
import com.rutu.twitter.notificationms.repository.NotificationRepository;
import com.rutu.twitter.notificationms.service.NotificationService;
import com.rutu.twitter.notificationms.utility.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("notificationService")
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public NotificationDTO createNotification(NotificationDTO notificationDTO) {
        Notification notification = ModelMapper.getNotification(notificationDTO);
        Notification savedNotification = notificationRepository.save(notification);
        return ModelMapper.getNotificationDTO(savedNotification);
    }

    @Override
    public NotificationDTO getNotificationById(Long id) throws BaseException {
        return notificationRepository.findById(id)
                .map(ModelMapper::getNotificationDTO)
                .orElseThrow(() -> new BaseException("Notification not found"));
    }

    @Override
    public List<NotificationDTO> getNotificationsByUserId(Long userId) {
        return notificationRepository.findByUserId(userId).stream()
                .map(ModelMapper::getNotificationDTO)
                .collect(Collectors.toList());
    }

    @Override
    public NotificationDTO updateNotification(Long id, NotificationDTO notificationDTO) {
        if (notificationRepository.existsById(id)) {
            Notification notification = ModelMapper.getNotification(notificationDTO);
            notification.setId(id);
            Notification updatedNotification = notificationRepository.save(notification);
            return ModelMapper.getNotificationDTO(updatedNotification);
        }
        return null;
    }

    @Override
    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }
}

