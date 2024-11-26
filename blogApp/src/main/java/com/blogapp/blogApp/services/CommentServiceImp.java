package com.blogapp.blogApp.services;


import com.blogapp.blogApp.entity.Comment;
import com.blogapp.blogApp.entity.Post;
import com.blogapp.blogApp.repository.CommentRepository;
import com.blogapp.blogApp.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImp implements CommentService{
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    public Comment createComment(Long postId, String postedBy, String content) {
        Optional<Post> optionalPost = postRepository.findById(postId);

        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            Comment comment = new Comment(post, content, postedBy, new Date());

            return commentRepository.save(comment);
        } else {
            throw new EntityNotFoundException("Post not found!");
        }
    }


    public List<Comment> getCommentByPostId(Long postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        System.out.println("Fetched Comments: " + comments);
        return comments;
    }
}
