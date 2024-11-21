package com.example.spring_swagger.postdomain.domain;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostDetailResponseDto {
    private int postId;
    private String title;
    private String body;
    private int likes;
    private String userId;

    @QueryProjection
    public PostDetailResponseDto(int postId, String title, String body, int likes, String userId) {
        this.postId = postId;
        this.title = title;
        this.body = body;
        this.likes = likes;
        this.userId = userId;
    }

}
