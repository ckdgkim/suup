package com.example.spring_swagger.postdomain.controller;

import com.example.spring_swagger.postdomain.domain.*;
import com.example.spring_swagger.postdomain.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

//    @GetMapping("/posts/likes")
//    public List<PostAllResponseDto> viewAllPostsWithLikes(@RequestParam(name="likes",required = false) Integer likes,
//                                                          @RequestParam(name="title",required = false) String title) {
////        return "viewAllPosts";
//        return postService.getAllPostsWithLikes(likes, title);
//    }

    @GetMapping
    public List<PostAllResponseDto> viewAllPosts() {
//        return "viewAllPosts";
        return postService.getAllPosts();
    }

    @GetMapping("/{postId}")
    public PostDetailResponseDto viewPostDetail(@PathVariable("postId") int postId) {
        return postService.getPostDetail(postId);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable("postId") int postId) {
        postService.deletePost(postId);
    }

    @PostMapping("/users/{userId}")
    public PostDetailResponseDto createNewPostWithUser(@PathVariable("userId") String userId, @RequestBody PostCreateRequestDto postDto) {
        return postService.createPostWithUser(userId, postDto);
    }

    @PutMapping("/{postId}")
    public int updateLikesPost(@PathVariable("postId") int postId) {
        return postService.increaseLikes(postId);
    }

    @PatchMapping("/{postId}/users/{userId}")
    public PostDetailResponseDto updatePostWithUser(@PathVariable("postId") int postId, @PathVariable("userId") String userId, @RequestBody PostUpdateRequestDto postDto) {
        return postService.updateBodyWithUser(postId, userId, postDto);
    }

    @DeleteMapping("/{postId}/users/{userId}")
    public void deletePostWithUser(@PathVariable("postId") int postId, @PathVariable("userId") String userId) {
        postService.removePostWithUser(postId, userId);
    }

//    @PatchMapping("/posts/{postId}")
//    public Post updateBodyPost(@PathVariable("postId") int postId, @RequestBody Post postDto) {
//        return postService.updatePost(postDto);
//    }
}
