package com.example.springweb.service;

import com.example.springweb.Domain.*;
import com.example.springweb.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<PostAllResponseDto> getAllPosts() {
//        return "PostService 가 호출되었습니다.";
        List<Post> allposts = postRepository.findAll();
        List<PostAllResponseDto> postDtos = allposts.stream()
                .map(PostAllResponseDto::of)
                .collect(Collectors.toList());
        return postDtos;
    }

    public List<PostAllResponseDto> getAllPostsWithLikes(Integer likes, String title) {
//        return "PostService 가 호출되었습니다.";
        List<Post> allposts = postRepository.findAllWithLikes(likes, title);
        List<PostAllResponseDto> postDtos = allposts.stream()
                .map(PostAllResponseDto::of)
                .collect(Collectors.toList());
        return postDtos;
    }

    public PostDetailResponseDto getPostDetail(int postId) {
        Post post = postRepository.findById(postId);
        PostDetailResponseDto retPost = new PostDetailResponseDto(
                post.getPostId(),
                post.getTitle(),
                post.getBody(),
                post.getLikes()
        );
        return retPost;
    }

    public void deletePost(int postId) {
        postRepository.deletePost(postId);
    }

    public int insertPost(PostCreateRequestDto postCreateRequestDto) {
        Post post = new Post(0, postCreateRequestDto.getTitle(), postCreateRequestDto.getBody(), 0); // 새 게시글 생성 시 초기 값 설정
        return postRepository.insertPost(post);
    }

    public int increaseLikes(int postId) {
        Post post = postRepository.findById(postId);
        int likes = 0;
        if (post != null) {
            likes = post.getLikes() + 1;
            post.setLikes(likes);
        }
        postRepository.updatePost(post);
        return likes;
    }

    public PostDetailResponseDto updatePost(PostUpdateRequestDto postDto) {
        Post post = postRepository.findById(postDto.getPostId());
        // body 는 빈 내용을 허용하지 않는다.
        if (post !=null && !postDto.getBody().equals("")) {
            post.setBody(postDto.getBody());
            postRepository.updatePost(post);
        }
        return getPostDetail(postDto.getPostId());
    }
}
