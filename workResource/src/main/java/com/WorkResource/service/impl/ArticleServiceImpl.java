package com.WorkResource.service.impl;

import com.WorkResource.enity.Article;
import com.WorkResource.mapper.ArticleMapper;
import com.WorkResource.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
}
