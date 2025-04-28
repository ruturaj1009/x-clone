package com.rutu.twitter.tweetms.service.impl;

import com.rutu.twitter.tweetms.dto.LikeDTO;
import com.rutu.twitter.tweetms.entity.Like;
import com.rutu.twitter.tweetms.exception.BaseException;
import com.rutu.twitter.tweetms.repository.LikeRepository;
import com.rutu.twitter.tweetms.service.LikeService;
import com.rutu.twitter.tweetms.utility.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("likeService ")
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Override
    public LikeDTO createLike(LikeDTO likeDTO) {
        Like like = ModelMapper.getLike(likeDTO);
        like.setId(null);
        Like savedLike = likeRepository.save(like);
        return ModelMapper.getLikeDTO(savedLike);
    }

    @Override
    public LikeDTO getLikeById(Long id) throws BaseException {
        return likeRepository.findById(id)
                .map(ModelMapper::getLikeDTO)
                .orElseThrow(() -> new BaseException("Like not found"));
    }

    @Override
    public List<LikeDTO> getLikesByUserId(Long userId) {
        return likeRepository.findByUserId(userId).stream()
                .map(ModelMapper::getLikeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<LikeDTO> getLikesByTweetId(Long tweetId) {
        return likeRepository.findByTweetId(tweetId).stream()
                .map(ModelMapper::getLikeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteLike(Long id) {
        likeRepository.deleteById(id);
    }

    @Override
    public void deleteLikeByUserIdAndTweetId(Long userId, Long tweetId) {
        likeRepository.deleteByUserIdAndTweetId(userId, tweetId);
    }

    @Override
    public boolean checkLikeExists(Long userId, Long tweetId) {
        return likeRepository.existsByUserIdAndTweetId(userId, tweetId);
    }
}
