package com.rutu.twitter.mediams.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MediaDTO {

    private Long id;
    private Long userId;
    private String mediaUrl;
    private MediaType mediaType;
    private Instant uploadedAt;
}
