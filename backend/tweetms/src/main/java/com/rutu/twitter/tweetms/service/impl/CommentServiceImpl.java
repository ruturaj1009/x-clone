package com.rutu.twitter.tweetms.service.impl;

import com.rutu.twitter.tweetms.dto.CommentDTO;
import com.rutu.twitter.tweetms.entity.Comment;
import com.rutu.twitter.tweetms.exception.BaseException;
import com.rutu.twitter.tweetms.repository.CommentRepository;
import com.rutu.twitter.tweetms.service.CommentService;
import com.rutu.twitter.tweetms.utility.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public CommentDTO createComment(CommentDTO commentDTO) {
        Comment comment = ModelMapper.getComment(commentDTO);
        Comment savedComment = commentRepository.save(comment);
        return ModelMapper.getCommentDTO(savedComment);
    }

    @Override
    public CommentDTO getCommentById(Long id) throws BaseException {
        return commentRepository.findById(id)
                .map(ModelMapper::getCommentDTO)
                .orElseThrow(() -> new BaseException("comment not found"));
    }

    @Override
    public List<CommentDTO> getCommentsByUserId(Long userId) {
        return commentRepository.findByUserId(userId).stream()
                .map(ModelMapper::getCommentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CommentDTO> getCommentsByTweetId(Long tweetId) {
        return commentRepository.findByTweetId(tweetId).stream()
                .map(ModelMapper::getCommentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CommentDTO updateComment(Long id, CommentDTO commentDTO) {
        if (commentRepository.existsById(id)) {
            Comment comment = ModelMapper.getComment(commentDTO);
            comment.setId(id);
            Comment updatedComment = commentRepository.save(comment);
            return ModelMapper.getCommentDTO(updatedComment);
        }
        return null;
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
