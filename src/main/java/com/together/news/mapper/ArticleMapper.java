package com.together.news.mapper;

import com.together.news.entity.Article;

import java.util.List;

/**
 * ArticleMapper
 *
 * @author feng yanli
 * @time 2016/12/2 17:40
 */

public interface ArticleMapper {
    /**
     * 查询全部
     *
     * @return
     * @throws Exception
     */
    public List<Article> listAll() throws Exception;
}
