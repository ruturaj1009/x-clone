package com.rutu.twitter.tweetms.service;

import com.rutu.twitter.tweetms.dto.TweetDTO;
import com.rutu.twitter.tweetms.exception.BaseException;

import java.util.List;

public interface TweetService {
    TweetDTO createTweet(TweetDTO tweetDTO);

    TweetDTO getTweetById(Long id) throws BaseException;

    List<TweetDTO> getTweetsByUserId(Long userId) throws BaseException;

    TweetDTO updateTweet(Long id, TweetDTO tweetDTO) throws BaseException;

    void deleteTweet(Long id);
}
