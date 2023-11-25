package com.WorkResource.service.impl;

import com.WorkResource.constant.statusConstant;
import com.WorkResource.domin.ResponseResult;
import com.WorkResource.domin.vo.ArticleListVo;
import com.WorkResource.domin.vo.PageVo;
import com.WorkResource.domin.vo.hotArticleVo;
import com.WorkResource.entity.Article;
import com.WorkResource.mapper.ArticleMapper;
import com.WorkResource.service.ArticleService;
import com.WorkResource.utills.beanCopyTool;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
    @Override
    public ResponseResult hotArticleList() {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Article::getStatus, statusConstant.ACTIVE);
        queryWrapper.orderByDesc(Article::getViewCount);
        Page<Article> page = new Page<>(1, 10);
        page(page, queryWrapper);
        List<Article> records = page.getRecords();
        List<hotArticleVo> hotArticleVos = beanCopyTool.copyBeanList(records, hotArticleVo.class);
        return ResponseResult.okResult(hotArticleVos);
    }

    @Override
    public ResponseResult getArticleList(Integer pageNum, Integer pageSize, Long categoryId) {
        //查询条件
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Article::getStatus, statusConstant.ACTIVE);
        queryWrapper.orderByDesc(Article::getIsTop);
        queryWrapper.eq(Objects.nonNull(categoryId), Article::getCategoryId, categoryId);
        //分页查询
        Page<Article> page = new Page(pageNum, pageSize);
        page(page, queryWrapper);
        List<Article> records = page.getRecords();
        //将集合封装成vo返回
        List<ArticleListVo> articleListVos = beanCopyTool.copyBeanList(records, ArticleListVo.class);
        log.info("---------",page.getTotal());
        return ResponseResult.okResult(new PageVo(articleListVos,page.getTotal()));
    }
}
