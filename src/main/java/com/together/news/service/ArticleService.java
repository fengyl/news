package com.together.news.service;

import com.together.news.entity.Article;

import java.util.List;

/**
 * ArticleService
 *
 * @author feng yanli
 * @time 2016/12/2 17:49
 */

public interface ArticleService {
    /**
     * 查询全部
     *
     * @return
     * @throws Exception
     */
    public List<Article> listAll() throws Exception;
}
