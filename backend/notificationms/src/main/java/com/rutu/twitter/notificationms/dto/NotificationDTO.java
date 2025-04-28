package com.rutu.twitter.notificationms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDTO {

    private Long id;
    private Long userId;
    private NotificationType type;
    private Long referenceId;
    private boolean isRead;
    private Instant createdAt;
    private Instant updatedAt;
}
