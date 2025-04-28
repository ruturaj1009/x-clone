package com.rutu.twitter.tweetms.repository;

import com.rutu.twitter.tweetms.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    List<Like> findByUserId(Long userId);

    List<Like> findByTweetId(Long tweetId);

    boolean existsByUserIdAndTweetId(Long userId, Long tweetId);

    void deleteByUserIdAndTweetId(Long userId, Long tweetId);
}
