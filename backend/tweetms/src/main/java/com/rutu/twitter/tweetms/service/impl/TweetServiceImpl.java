package com.rutu.twitter.tweetms.service.impl;

import com.rutu.twitter.tweetms.dto.TweetDTO;
import com.rutu.twitter.tweetms.entity.Tweet;
import com.rutu.twitter.tweetms.exception.BaseException;
import com.rutu.twitter.tweetms.repository.TweetRepository;
import com.rutu.twitter.tweetms.service.TweetService;
import com.rutu.twitter.tweetms.utility.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("tweetService")
public class TweetServiceImpl implements TweetService {

    @Autowired
    private TweetRepository tweetRepository;

    @Override
    public TweetDTO createTweet(TweetDTO tweetDTO) {
        Tweet tweet = ModelMapper.getTweet(tweetDTO);
        tweet.setId(null);
        Tweet savedTweet = tweetRepository.save(tweet);
        return ModelMapper.getTweetDTO(savedTweet);
    }

    @Override
    public TweetDTO getTweetById(Long id) throws BaseException {
        return tweetRepository.findById(id)
                .map(ModelMapper::getTweetDTO)
                .orElseThrow(() -> new BaseException("Tweet not found"));
    }

    @Override
    public List<TweetDTO> getTweetsByUserId(Long userId) throws BaseException {
        List<TweetDTO> tweetDTOS = tweetRepository.findByUserId(userId).stream()
                .map(ModelMapper::getTweetDTO)
                .toList();
        if (tweetDTOS.isEmpty()) {
            throw new BaseException("No tweets found");
        }
        return tweetDTOS;
    }

    @Override
    public TweetDTO updateTweet(Long id, TweetDTO tweetDTO) throws BaseException {
        Tweet tweet = tweetRepository.findById(id).orElseThrow(() -> new BaseException("tweet not found"));
        tweet = ModelMapper.getTweet(tweetDTO);
        tweet.setId(id);
        Tweet updatedTweet = tweetRepository.save(tweet);
        return ModelMapper.getTweetDTO(tweet);
    }

    @Override
    public void deleteTweet(Long id) {
        tweetRepository.deleteById(id);
    }
}
