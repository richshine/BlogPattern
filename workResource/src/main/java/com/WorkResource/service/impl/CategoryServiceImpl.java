package com.WorkResource.service.impl;

import com.WorkResource.constant.statusConstant;
import com.WorkResource.domin.ResponseResult;
import com.WorkResource.domin.vo.cateGoryVo;
import com.WorkResource.entity.Article;
import com.WorkResource.entity.Category;
import com.WorkResource.mapper.CategoryMapper;
import com.WorkResource.service.ArticleService;
import com.WorkResource.service.CategoryService;
import com.WorkResource.utills.beanCopyTool;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 分类表(Category)表服务实现类
 *
 * @author makejava
 * @since 2023-11-25 19:32:33
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    /**
     * 显示分类列表
     * 要求此分类下必须有文章
     *
     * @return
     */
    @Autowired
    ArticleService articleService;

    @Override
    public ResponseResult getCategoryList() {
        //先查询分类下是否有文章
        LambdaQueryWrapper<Article> articleLambdaQueryWrapper = new LambdaQueryWrapper<>();
        articleLambdaQueryWrapper.eq(Article::getStatus, statusConstant.ACTIVE);
        List<Article> list = articleService.list(articleLambdaQueryWrapper);
        //获取文章id并且去重
        Set<Long> CateGoryId = list.stream().map(Article::getCategoryId).collect(Collectors.toSet());
        //查询出所有分类
        List<Category> categories = listByIds(CateGoryId);
        //显示状态正常的分类
        categories = categories.stream().filter(category -> statusConstant.CATEGORY_ACTIVE.equals(category.getStatus())).collect(Collectors.toList());
        List<cateGoryVo> cateGoryVos = beanCopyTool.copyBeanList(categories, cateGoryVo.class);
        return ResponseResult.okResult(cateGoryVos);
    }
}

