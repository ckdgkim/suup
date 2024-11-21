package com.example.spring_swagger.postdomain.controller;

import com.example.spring_swagger.postdomain.domain.*;
import com.example.spring_swagger.postdomain.service.PostService;
import com.example.spring_swagger.userdomain.session.SessionConst;
import com.example.spring_swagger.userdomain.session.UserSession;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
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
    public String viewAllPosts(Model model) {
        List<PostAllResponseDto> allPosts = postService.getAllPosts();
        model.addAttribute("allPosts", allPosts);
        return "post/postAll";
    }

    @GetMapping("/{postId}")
    public String viewPostDetail(@PathVariable("postId") int postId, Model model) {
        model.addAttribute("post",postService.getPostDetail(postId));
        return "post/postDetail";
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable("postId") int postId) {
        postService.deletePost(postId);
    }

    @GetMapping("/add")
    public String createNewPostWithUser(Model model) {
        model.addAttribute("post", new Post());
        return "post/postAdd";
    }

    @PostMapping("/add")
    public String createNewPostWithUser(
//            @PathVariable("userId") String userId,
            @ModelAttribute PostCreateRequestDto postDto) {
         postService.createPostWithUser("1", postDto);
         return "redirect:/posts";
    }

    @PutMapping("/{postId}")
    public int updateLikesPost(@PathVariable("postId") int postId) {
        return postService.increaseLikes(postId);
    }

    @GetMapping("/update/{postId}")
    public String updatePostWithUser(@PathVariable("postId") int postId, Model model) {
        System.out.println(postService.getPostDetail(postId));
        model.addAttribute("post",postService.getPostDetail(postId));
        return "post/postUpdate";
    }

    @PostMapping("/update/{postId}") // /users/{userId})
    public String updatePostWithUser(
            @PathVariable("postId") int postId,
            HttpServletRequest req,
//            @PathVariable("userId") String userId,
            @ModelAttribute PostUpdateRequestDto postDto) {
//        String currentUserId = postDto.getUserId(); // 폼에서 전달받은 userId 사용
//        postService.updateBodyWithUser(postId, currentUserId, postDto);
//        return "redirect:/posts" + postId; // 수정 후 해당 포스트로 리디렉션
//    }
        // 세션 정보를 얻어온다. => 로그인 된 상태인지 확인 ==> userId와 post의 userId가 일치하면 수정 가능
        HttpSession session = req.getSession(false);
        String userId = "";
        if (session != null) {
            UserSession userSession = (UserSession) session.getAttribute(SessionConst.SESSION_NAME);
            userId = userSession.getUserId();
        }
        postService.updateBodyWithUser(postId, userId, postDto);
        return "redirect:/posts/{postId}"; // 수정 후 해당 포스트로 리디렉션
    }

    @RequestMapping("/delete/{postId}")
    public String deletePostWithUser(@PathVariable("postId") int postId,
//                                     @PathVariable("userId")
                                     String userId) {
        // 세션 정보를 얻어온다. => 로그인 된 상태인지 확인 ==> userId와 post의 userId가 일치하면 삭제 가능
        postService.removePostWithUser(postId, userId);
        return "redirect:/posts";
    }

//    @PatchMapping("/posts/{postId}")
//    public Post updateBodyPost(@PathVariable("postId") int postId, @RequestBody Post postDto) {
//        return postService.updatePost(postDto);
//    }
}
