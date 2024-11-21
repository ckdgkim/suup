package com.example.springweb.repository;

import com.example.springweb.Domain.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Repository
public class PostRepositoryImpl implements PostRepository {
    private static Map<Integer, Post> posts = new HashMap<>();
    private static int seq = 1;

    public PostRepositoryImpl() {
        Post post = new Post(1, "test", "body", 0);
        posts.put(1,post);
    }

    @Override
    public List<Post> findAll() {
        return new ArrayList<Post>(posts.values());
    }

    @Override
    public List<Post> findAllWithLikes(Integer likes, String title) {
        return List.of();
    }

    @Override
    public Post findById(int postId) {
        return posts.get(postId);
    }

    @Override
    public Post deletePost(int postId) {
        posts.remove(postId);
        return null;
    }

    @Override
    public void updatePost(Post post) {
        posts.put(post.getPostId(), post);
    }

    @Override
    public int insertPost(Post post) {
        seq++;
        post.setPostId(seq);
        posts.put(post.getPostId(), post);
        return seq;
    }
}
