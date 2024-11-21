package com.example.api.controller;

import com.example.api.domain.News;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;


@Slf4j
@RestController
@RequestMapping("/news")
public class NewsController {

    @GetMapping
    public List<News> getNews() {
        List<News> newsList = new ArrayList<>();
        News news = new News();
        news.setAid(1);
        news.setTitle("test");
        newsList.add(news);
        return newsList;
    }

    @PostMapping
    public String addNews(@RequestBody News news) {
        log.info("addNews : {}", news);
        return "뉴스 등록 완료";
    }
}
