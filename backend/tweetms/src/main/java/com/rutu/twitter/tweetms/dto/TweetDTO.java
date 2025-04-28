package com.rutu.twitter.tweetms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TweetDTO {

    private Long id;
    private String content;
    private Long userId;
    private Long mediaId;
    private Integer status;
    private Instant createdAt;
    private Instant scheduledAt;
    private Instant updatedAt;
}
