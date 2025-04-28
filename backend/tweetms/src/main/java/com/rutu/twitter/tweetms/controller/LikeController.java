package com.rutu.twitter.tweetms.controller;

import com.rutu.twitter.tweetms.dto.LikeDTO;
import com.rutu.twitter.tweetms.exception.BaseException;
import com.rutu.twitter.tweetms.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/like")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @PostMapping
    public ResponseEntity<LikeDTO> createLike(@RequestBody LikeDTO likeDTO) {
        return ResponseEntity.ok(likeService.createLike(likeDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LikeDTO> getLikeById(@PathVariable Long id) throws BaseException {
        LikeDTO likeDTO = likeService.getLikeById(id);
        if (likeDTO != null) {
            return ResponseEntity.ok(likeDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LikeDTO>> getLikesByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(likeService.getLikesByUserId(userId));
    }

    @GetMapping("/tweet/{tweetId}")
    public ResponseEntity<List<LikeDTO>> getLikesByTweetId(@PathVariable Long tweetId) {
        return ResponseEntity.ok(likeService.getLikesByTweetId(tweetId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLike(@PathVariable Long id) {
        likeService.deleteLike(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/user/{userId}/tweet/{tweetId}")
    public ResponseEntity<Void> deleteLikeByUserAndTweet(@PathVariable Long userId, @PathVariable Long tweetId) {
        likeService.deleteLikeByUserIdAndTweetId(userId, tweetId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/exists/user/{userId}/tweet/{tweetId}")
    public ResponseEntity<Boolean> checkLikeExists(@PathVariable Long userId, @PathVariable Long tweetId) {
        return ResponseEntity.ok(likeService.checkLikeExists(userId, tweetId));
    }
}
