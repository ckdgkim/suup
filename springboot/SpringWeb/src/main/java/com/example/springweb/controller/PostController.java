package com.example.springweb.controller;

import com.example.springweb.Domain.*;
import com.example.springweb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts/likes")
    public List<PostAllResponseDto> viewAllPostsWithLikes(@RequestParam(name="likes",required = false) Integer likes,
                                                          @RequestParam(name="title",required = false) String title) {
//        return "viewAllPosts";
        return postService.getAllPostsWithLikes(likes, title);
    }

    @GetMapping("/posts")
    public List<PostAllResponseDto> viewAllPosts() {
//        return "viewAllPosts";
        return postService.getAllPosts();
    }

    @GetMapping("/posts/{postId}")
    public PostDetailResponseDto viewPostDetail(@PathVariable("postId") int postId) {
        return postService.getPostDetail(postId);
    }

    @DeleteMapping("/posts/{postId}")
    public void deletePost(@PathVariable("postId") int postId) {
        postService.deletePost(postId);
    }

    @PostMapping("/posts")
    public int insertPost(@RequestBody PostCreateRequestDto postCreateRequestDto) {
        return postService.insertPost(postCreateRequestDto);
    }

    @PutMapping("/posts/{postId}")
    public int updateLikesPost(@PathVariable("postId") int postId) {
        return postService.increaseLikes(postId);
    }

    @PatchMapping("/posts/{postId}")
    public PostDetailResponseDto updateBodyPost(@PathVariable("postId") int postId, @RequestBody PostUpdateRequestDto postDto) {
        return postService.updatePost(postDto);
    }
}
