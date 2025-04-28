package com.rutu.twitter.followms.controller;

import com.rutu.twitter.followms.dto.FollowDTO;
import com.rutu.twitter.followms.exception.BaseException;
import com.rutu.twitter.followms.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/follow")
public class FollowController {

    @Autowired
    private FollowService followService;

    @PostMapping
    public ResponseEntity<FollowDTO> createFollow(@RequestBody FollowDTO followDTO) {
        return ResponseEntity.ok(followService.createFollow(followDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FollowDTO> getFollowById(@PathVariable Long id) throws BaseException {
        FollowDTO followDTO = followService.getFollowById(id);
        if (followDTO != null) {
            return ResponseEntity.ok(followDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/follower/{followerId}")
    public ResponseEntity<List<FollowDTO>> getFollowsByFollowerId(@PathVariable Long followerId) {
        return ResponseEntity.ok(followService.getFollowsByFollowerId(followerId));
    }

    @GetMapping("/following/{followingId}")
    public ResponseEntity<List<FollowDTO>> getFollowsByFollowingId(@PathVariable Long followingId) {
        return ResponseEntity.ok(followService.getFollowsByFollowingId(followingId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFollow(@PathVariable Long id) {
        followService.deleteFollow(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/follower/{followerId}/following/{followingId}")
    public ResponseEntity<Void> deleteFollowByUserAndFollowing(@PathVariable Long followerId, @PathVariable Long followingId) {
        followService.deleteFollowByFollowerIdAndFollowingId(followerId, followingId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/exists/follower/{followerId}/following/{followingId}")
    public ResponseEntity<Boolean> checkFollowExists(@PathVariable Long followerId, @PathVariable Long followingId) {
        return ResponseEntity.ok(followService.checkFollowExists(followerId, followingId));
    }
}
