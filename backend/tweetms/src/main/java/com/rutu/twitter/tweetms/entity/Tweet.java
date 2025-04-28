package com.rutu.twitter.tweetms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "tweets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "media_id", nullable = false)
    private Long mediaId;

    @Column(name = "status", nullable = false)
    private Integer status = 1;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "scheduled_at", nullable = false)
    private Instant scheduledAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @PrePersist
    protected void onCreate() {
        Instant now = Instant.now();
        this.createdAt = now;
        this.scheduledAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
    }
}
