package com.together.news.mapper;

import com.together.news.entity.Category;

import java.util.List;

/**
 * CategoryMapper
 *
 * @author feng yanli
 * @time 2016/12/19 14:51
 */

public interface CategoryMapper {
    public List<Category> listAll() throws Exception;
}
