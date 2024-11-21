package com.example.api.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class News {
    private int aid;
    private String title;
    private String img;
    private String date;
    private String content;
}
