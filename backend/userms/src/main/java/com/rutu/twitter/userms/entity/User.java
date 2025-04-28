package com.rutu.twitter.userms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "username", nullable = false, unique = true)
    private String userName;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "full_name", nullable = true)
    private String fullName;
    @Column(name = "bio", nullable = true)
    private String bio;
    @Column(name = "profile_image_url", nullable = true)
    private String profileImageUrl;
    @Column(name = "cover_image_url", nullable = true)
    private String coverImageUrl;
    @Column(name = "created_at", nullable = true)
    private Instant createdAt;
    @Column(name = "updated_at", nullable = true)
    private Instant updatedAt;

    @PrePersist
    protected void onCreate() {
        Instant now = Instant.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = Instant.now();
    }
}
