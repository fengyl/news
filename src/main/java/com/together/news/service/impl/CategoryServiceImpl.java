package com.together.news.service.impl;

import com.together.news.entity.Category;
import com.together.news.mapper.CategoryMapper;
import com.together.news.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author feng yanli
 * @time 2016/12/19 22:47
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> listAll(String id) throws Exception {
        try {
            return categoryMapper.listAll(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
