package com.rutu.twitter.tweetms.controller;

import com.rutu.twitter.tweetms.dto.CommentDTO;
import com.rutu.twitter.tweetms.exception.BaseException;
import com.rutu.twitter.tweetms.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO commentDTO) {
        return ResponseEntity.ok(commentService.createComment(commentDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDTO> getCommentById(@PathVariable Long id) throws BaseException {
        CommentDTO commentDTO = commentService.getCommentById(id);
        if (commentDTO != null) {
            return ResponseEntity.ok(commentDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CommentDTO>> getCommentsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(commentService.getCommentsByUserId(userId));
    }

    @GetMapping("/tweet/{tweetId}")
    public ResponseEntity<List<CommentDTO>> getCommentsByTweetId(@PathVariable Long tweetId) {
        return ResponseEntity.ok(commentService.getCommentsByTweetId(tweetId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentDTO> updateComment(@PathVariable Long id, @RequestBody CommentDTO commentDTO) {
        CommentDTO updatedCommentDTO = commentService.updateComment(id, commentDTO);
        if (updatedCommentDTO != null) {
            return ResponseEntity.ok(updatedCommentDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }
}
