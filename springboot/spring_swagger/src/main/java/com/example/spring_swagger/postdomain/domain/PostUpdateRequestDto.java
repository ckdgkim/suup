package com.example.spring_swagger.postdomain.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostUpdateRequestDto {
    private int postId;
    private String body;
    private String title;
}
