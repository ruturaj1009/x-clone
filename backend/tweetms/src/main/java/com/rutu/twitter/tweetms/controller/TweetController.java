package com.rutu.twitter.tweetms.controller;

import com.rutu.twitter.tweetms.dto.TweetDTO;
import com.rutu.twitter.tweetms.exception.BaseException;
import com.rutu.twitter.tweetms.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/tweet")
public class TweetController {

    @Autowired
    private TweetService tweetService;

    @PostMapping
    public ResponseEntity<TweetDTO> createTweet(@RequestBody TweetDTO tweetDTO) {
        return ResponseEntity.ok(tweetService.createTweet(tweetDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TweetDTO> getTweetById(@PathVariable Long id) throws BaseException {
        TweetDTO tweetDTO = tweetService.getTweetById(id);
        if (tweetDTO != null) {
            return ResponseEntity.ok(tweetDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TweetDTO>> getTweetsByUserId(@PathVariable Long userId) throws BaseException {
        return ResponseEntity.ok(tweetService.getTweetsByUserId(userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TweetDTO> updateTweet(@PathVariable Long id, @RequestBody TweetDTO tweetDTO) throws BaseException {
        TweetDTO updatedTweetDTO = tweetService.updateTweet(id, tweetDTO);
        if (updatedTweetDTO != null) {
            return ResponseEntity.ok(updatedTweetDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTweet(@PathVariable Long id) {
        tweetService.deleteTweet(id);
        return ResponseEntity.noContent().build();
    }
}
