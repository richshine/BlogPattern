package com.front.controller;

import com.WorkResource.enity.Article;
import com.WorkResource.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("article")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @GetMapping("/list")
    public List<Article> get() {
        return articleService.list();
    }
}
