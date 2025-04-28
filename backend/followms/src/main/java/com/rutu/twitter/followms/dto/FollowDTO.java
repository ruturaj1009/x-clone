package com.rutu.twitter.followms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FollowDTO {

    private Long id;
    private Long followerId;
    private Long followingId;
    private Instant createdAt;
    private Instant updatedAt;
}
