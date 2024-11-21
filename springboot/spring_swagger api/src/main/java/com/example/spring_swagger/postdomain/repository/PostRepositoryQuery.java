package com.example.spring_swagger.postdomain.repository;

import com.example.spring_swagger.postdomain.domain.DynamicSearchCond;
import com.example.spring_swagger.postdomain.domain.Post;

import java.util.List;

public interface PostRepositoryQuery {
    List<Post> getAllPostWithLikesAndWriter(DynamicSearchCond searchCond);

}
