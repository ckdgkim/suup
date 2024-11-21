package com.example.spring_swagger.postdomain.repository;

import com.example.spring_swagger.postdomain.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
//    List<Post> findAllWithLikes(String postName);
    Post findByTitle(String title);
    List<Post> findByTitleLike(int likes);

    @Query("select p from Post p left join fetch p.writer where p.postId = :postId")
    Post findByPostWithUserFetchjoin(@Param("postId") int postId);
}
