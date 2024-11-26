package com.blogapp.blogApp.services;

import com.blogapp.blogApp.entity.Comment;

import java.util.List;

public interface CommentService {

    Comment createComment(Long postId, String postedBy, String content);
    List<Comment> getCommentByPostId(Long postId);
}
