package com.rutu.twitter.followms.service.impl;

import com.rutu.twitter.followms.dto.FollowDTO;
import com.rutu.twitter.followms.entity.Follow;
import com.rutu.twitter.followms.exception.BaseException;
import com.rutu.twitter.followms.repository.FollowRepository;
import com.rutu.twitter.followms.utility.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service("followService")
public class FollowServiceImpl implements com.rutu.twitter.followms.service.FollowService {

    @Autowired
    private FollowRepository followRepository;

    @Override
    public FollowDTO createFollow(FollowDTO followDTO) {
        Follow follow = ModelMapper.getFollow(followDTO);
        Follow savedFollow = followRepository.save(follow);
        return ModelMapper.getFollowDTO(savedFollow);
    }

    @Override
    public FollowDTO getFollowById(Long id) throws BaseException {
        return followRepository.findById(id)
                .map(ModelMapper::getFollowDTO)
                .orElseThrow(()-> new BaseException("follow data not found"));
    }

    @Override
    public List<FollowDTO> getFollowsByFollowerId(Long followerId) {
        return followRepository.findByFollowerId(followerId).stream()
                .map(ModelMapper::getFollowDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<FollowDTO> getFollowsByFollowingId(Long followingId) {
        return followRepository.findByFollowingId(followingId).stream()
                .map(ModelMapper::getFollowDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteFollow(Long id) {
        followRepository.deleteById(id);
    }

    @Override
    public void deleteFollowByFollowerIdAndFollowingId(Long followerId, Long followingId) {
        followRepository.deleteByFollowerIdAndFollowingId(followerId, followingId);
    }

    @Override
    public boolean checkFollowExists(Long followerId, Long followingId) {
        return followRepository.existsByFollowerIdAndFollowingId(followerId, followingId);
    }
}
