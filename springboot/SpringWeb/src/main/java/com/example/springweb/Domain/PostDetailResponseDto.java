package com.example.springweb.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDetailResponseDto {
    private int postId;
    private String title;
    private String body;
    private int likes;
}
