package com.WorkResource.service;

import com.WorkResource.domin.ResponseResult;
import com.WorkResource.enity.Article;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ArticleService extends IService<Article> {
    ResponseResult hotArticleList();
}
