package com.example.spring_swagger.postdomain.domain;

import com.example.spring_swagger.userdomain.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;
    @Column(nullable = false)
    private String title;
    private String body;
    private int likes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private User writer;
}