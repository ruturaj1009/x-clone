package com.rutu.twitter.tweetms.utility;

import com.rutu.twitter.tweetms.dto.CommentDTO;
import com.rutu.twitter.tweetms.dto.LikeDTO;
import com.rutu.twitter.tweetms.dto.TweetDTO;
import com.rutu.twitter.tweetms.entity.Comment;
import com.rutu.twitter.tweetms.entity.Like;
import com.rutu.twitter.tweetms.entity.Tweet;

import java.time.Instant;


public class ModelMapper {
    public static TweetDTO getTweetDTO(Tweet tweet) {
        TweetDTO tweetDTO = new TweetDTO();
        tweetDTO.setId(tweet.getId());
        tweetDTO.setContent(tweet.getContent());
        tweetDTO.setUserId(tweet.getUserId());
        tweetDTO.setMediaId(tweet.getMediaId());
        tweetDTO.setStatus(tweet.getStatus());
        tweetDTO.setCreatedAt(tweet.getCreatedAt());
        tweetDTO.setScheduledAt(tweet.getScheduledAt());
        tweetDTO.setUpdatedAt(tweet.getUpdatedAt());
        return tweetDTO;
    }

    public static Tweet getTweet(TweetDTO tweetDTO) {
        Tweet tweet = new Tweet();
        tweet.setId(tweetDTO.getId());
        tweet.setContent(tweetDTO.getContent());
        tweet.setUserId(tweetDTO.getUserId());
        tweet.setMediaId(tweetDTO.getMediaId());
        tweet.setStatus(tweetDTO.getStatus());
        tweet.setCreatedAt(tweetDTO.getCreatedAt());
        tweet.setScheduledAt(tweetDTO.getScheduledAt());
        tweet.setUpdatedAt(tweetDTO.getUpdatedAt());
        return tweet;
    }

    public static LikeDTO getLikeDTO(Like like) {
        LikeDTO likeDTO = new LikeDTO();
        likeDTO.setId(like.getId());
        likeDTO.setUserId(like.getUserId());
        likeDTO.setTweetId(like.getTweetId());
        likeDTO.setCreatedAt(like.getCreatedAt());
        likeDTO.setUpdatedAt(like.getUpdatedAt());
        return likeDTO;
    }

    public static Like getLike(LikeDTO likeDTO) {
        Like like = new Like();
        like.setId(likeDTO.getId());
        like.setUserId(likeDTO.getUserId());
        like.setTweetId(likeDTO.getTweetId());
        like.setCreatedAt(likeDTO.getCreatedAt());
        like.setUpdatedAt(likeDTO.getUpdatedAt());
        return like;
    }

    public static CommentDTO getCommentDTO(Comment comment) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(comment.getId());
        commentDTO.setUserId(comment.getUserId());
        commentDTO.setTweetId(comment.getTweetId());
        commentDTO.setContent(comment.getContent());
        commentDTO.setCreatedAt(comment.getCreatedAt());
        commentDTO.setUpdatedAt(comment.getUpdatedAt());
        return commentDTO;
    }

    public static Comment getComment(CommentDTO commentDTO) {
        Comment comment = new Comment();
        comment.setId(commentDTO.getId());
        comment.setUserId(commentDTO.getUserId());
        comment.setTweetId(commentDTO.getTweetId());
        comment.setContent(commentDTO.getContent());
        comment.setCreatedAt(commentDTO.getCreatedAt());
        comment.setUpdatedAt(commentDTO.getUpdatedAt());
        return comment;
    }
}
