package com.rutu.twitter.followms.utility;

import com.rutu.twitter.followms.dto.FollowDTO;
import com.rutu.twitter.followms.entity.Follow;

public class ModelMapper {
    public static FollowDTO getFollowDTO(Follow follow) {
        FollowDTO followDTO = new FollowDTO();
        followDTO.setId(follow.getId());
        followDTO.setFollowerId(follow.getFollowerId());
        followDTO.setFollowingId(follow.getFollowingId());
        followDTO.setCreatedAt(follow.getCreatedAt());
        followDTO.setUpdatedAt(follow.getUpdatedAt());
        return followDTO;
    }

    public static Follow getFollow(FollowDTO followDTO) {
        Follow follow = new Follow();
        follow.setId(followDTO.getId());
        follow.setFollowerId(followDTO.getFollowerId());
        follow.setFollowingId(followDTO.getFollowingId());
        follow.setCreatedAt(followDTO.getCreatedAt());
        follow.setUpdatedAt(followDTO.getUpdatedAt());
        return follow;
    }
}
