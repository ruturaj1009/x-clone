package com.rutu.twitter.mediams.entity;

import com.rutu.twitter.mediams.dto.MediaType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "medias")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "media_url", nullable = false, length = 500)
    private String mediaUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "media_type", nullable = false)
    private MediaType mediaType;

    @Column(name = "uploaded_at", nullable = false)
    private Instant uploadedAt;

    @PrePersist
    void onUpload() {
        uploadedAt = Instant.now();
    }
}
