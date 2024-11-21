package com.example.springweb.repository;

import com.example.springweb.Domain.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostRepository {
    @Select("select * from post")
    List<Post> findAll();
    List<Post> findAllWithLikes(@Param("likes") Integer likes,@Param("title") String title);
    Post findById(int postId);
    Post deletePost(int postId);
    void updatePost(Post post);
    int insertPost(Post post);
}
