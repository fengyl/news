package com.together.news.service;

import com.together.news.entity.ArticleDate;

/**
 * @author feng yanli
 * @time 2016/12/2 20:57
 */

public interface ArticleDateService {
    /**
     * 根据id查找文章详情
     * @param id
     * @return
     * @throws Exception
     */
    public String articleDetail(String id) throws Exception;
}
