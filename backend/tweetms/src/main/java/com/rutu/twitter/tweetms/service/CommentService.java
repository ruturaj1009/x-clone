package com.rutu.twitter.tweetms.service;

import com.rutu.twitter.tweetms.dto.CommentDTO;
import com.rutu.twitter.tweetms.exception.BaseException;

import java.util.List;

public interface CommentService {
    CommentDTO createComment(CommentDTO commentDTO);

    CommentDTO getCommentById(Long id) throws BaseException;

    List<CommentDTO> getCommentsByUserId(Long userId);

    List<CommentDTO> getCommentsByTweetId(Long tweetId);

    CommentDTO updateComment(Long id, CommentDTO commentDTO);

    void deleteComment(Long id);
}
