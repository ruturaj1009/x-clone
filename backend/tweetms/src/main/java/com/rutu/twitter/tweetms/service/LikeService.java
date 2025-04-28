package com.rutu.twitter.tweetms.service;

import com.rutu.twitter.tweetms.dto.LikeDTO;
import com.rutu.twitter.tweetms.exception.BaseException;

import java.util.List;

public interface LikeService {
    LikeDTO createLike(LikeDTO likeDTO);

    LikeDTO getLikeById(Long id) throws BaseException;

    List<LikeDTO> getLikesByUserId(Long userId);

    List<LikeDTO> getLikesByTweetId(Long tweetId);

    void deleteLike(Long id);

    void deleteLikeByUserIdAndTweetId(Long userId, Long tweetId);

    boolean checkLikeExists(Long userId, Long tweetId);
}
