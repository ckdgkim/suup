package com.example.spring_swagger.postdomain.service;

import com.example.spring_swagger.postdomain.domain.*;
import com.example.spring_swagger.postdomain.repository.PostRepository;
import com.example.spring_swagger.userdomain.domain.User;
import com.example.spring_swagger.userdomain.repository.UserRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.spring_swagger.postdomain.domain.QPost.post;

@Service
@Transactional
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Autowired
    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public List<PostAllResponseDto> getAllPosts() {
        return postRepository.findAll().stream()
                .map(PostAllResponseDto::of) // DTO 변환
                .collect(Collectors.toList());
    }

//    public PostDetailResponseDto getPost

    public PostDetailResponseDto createPostWithUser(String userId, PostCreateRequestDto postDto) {
        User user = userRepository.findByUserId(userId);
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setBody(postDto.getBody());
        post.setWriter(user);
        postRepository.save(post);
        return getPostDetail(post.getPostId());
    }


//    public List<PostAllResponseDto> getAllPostsWithLikes(Integer likes, String title) {
////        return "PostService 가 호출되었습니다.";
//        List<Post> allposts = postRepository.findAllWithLikes(likes, title);
//        List<PostAllResponseDto> postDtos = allposts.stream()
//                .map(PostAllResponseDto::of)
//                .collect(Collectors.toList());
//        return postDtos;
//    }

    public PostDetailResponseDto getPostDetail(int postId) {
        Post post = postRepository.findById(postId).get();
        if (post == null) {
            return null;
        }
        PostDetailResponseDto retPost = new PostDetailResponseDto(
                post.getPostId(),
                post.getTitle(),
                post.getBody(),
                post.getLikes(),
                post.getWriter().getUserId()
        );
        return retPost;
    }

    public Post insertPost(Post post) {
        return postRepository.save(post);
    }

    public int increaseLikes(int postId) {
        Post post = postRepository.findById(postId).get();
        post.setLikes(post.getLikes() + 1);
        postRepository.save(post);
        return post.getLikes();
    }

    public Post updatePost(int postId, Post post) {
        Optional<Post> findPostId = postRepository.findById(postId);
        return findPostId.orElse(null);
    }
    public void deletePost(int postId) {
        if (!postRepository.existsById(postId)) {
            throw new RuntimeException("Post not found with id " + postId);
        }
        postRepository.deleteById(postId);
    }

    public PostDetailResponseDto updateBodyWithUser(int postId, String userId, PostUpdateRequestDto postDto) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        if (!post.getWriter().getUserId().equals(userId)) {
            throw new RuntimeException("User is not the writer of the post");
        }
        post.setBody(postDto.getBody());
        postRepository.save(post);
        return getPostDetail(post.getPostId());
    }

    public void removePostWithUser(int postId, String userId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        if (!post.getWriter().getUserId().equals(userId)) {
            throw new RuntimeException("User is not the writer of the post");
        }
        postRepository.delete(post);
    }

//    public List<PostDetailResponseDto> getPostByLikesAndWriter(DynamicSearchCond searchCond) {
//        qryFactory.select(new QPostDto(
//
//                ))
//                .from(QPost)
//                .where()
//                .fetch();
//    }

//    public List<PostDetailResponseDto> getPostByLikesAndWriter(DynamicSearchCond searchCond) {
//        return qryFactory.select(new QPostDetailResponseDto(
//                        post.postId,
//                        post.title,
//                        post.body,
//                        post.likes,
//                        post.writer.userId
//                ))
//                .from(post)
//                .where(
//                        likesGoe(searchCond.getLikes()),
//                        writerEq(searchCond.getUserName())
//                )
//                .fetch();
//    }
}
