package com.together.news.service;

import com.together.news.entity.Category;

import java.util.List;

/**
 * @author feng yanli
 * @time 2016/12/19 22:47
 */

public interface CategoryService {
    /**
     * 查询所有栏目
     * @param id
     * @return
     * @throws Exception
     */
    public List<Category> listAll(String id) throws Exception;
}
