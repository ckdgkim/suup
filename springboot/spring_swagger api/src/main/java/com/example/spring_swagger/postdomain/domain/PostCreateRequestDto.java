package com.example.spring_swagger.postdomain.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostCreateRequestDto {
    private String title;
    private String body;
//    private String userId;
}
