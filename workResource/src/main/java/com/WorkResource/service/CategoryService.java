package com.WorkResource.service;
import com.WorkResource.domin.ResponseResult;
import com.WorkResource.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
/**
 * 分类表(Category)表服务接口
 *
 * @author makejava
 * @since 2023-11-25 19:32:23
 */
public interface CategoryService extends IService<Category> {
    ResponseResult getCategoryList();
}
