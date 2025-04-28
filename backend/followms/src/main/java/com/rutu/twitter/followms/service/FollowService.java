package com.rutu.twitter.followms.service;

import com.rutu.twitter.followms.dto.FollowDTO;
import com.rutu.twitter.followms.exception.BaseException;

import java.util.List;

public interface FollowService {
    FollowDTO createFollow(FollowDTO followDTO);

    FollowDTO getFollowById(Long id) throws BaseException;

    List<FollowDTO> getFollowsByFollowerId(Long followerId);

    List<FollowDTO> getFollowsByFollowingId(Long followingId);

    void deleteFollow(Long id);

    void deleteFollowByFollowerIdAndFollowingId(Long followerId, Long followingId);

    boolean checkFollowExists(Long followerId, Long followingId);
}
