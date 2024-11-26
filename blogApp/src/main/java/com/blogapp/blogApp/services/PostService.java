package com.blogapp.blogApp.services;

import com.blogapp.blogApp.entity.Post;

import java.util.List;

public interface PostService {

    Post savePost(Post post);

    List<Post> getAllPosts();

    Post getPostById(long postId);

    void likePost(Long postId);

    List<Post> searchByName(String name);
}
