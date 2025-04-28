package com.rutu.twitter.tweetms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {

    private Long id;
    private Long userId;
    private Long tweetId;
    private String content;
    private Instant createdAt;
    private Instant updatedAt;
}
