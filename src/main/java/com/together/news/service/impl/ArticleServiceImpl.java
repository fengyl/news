package com.together.news.service.impl;

import com.together.news.entity.Article;
import com.together.news.mapper.ArticleMapper;
import com.together.news.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * ArticleServiceImpl
 *
 * @author feng yanli
 * @time 2016/12/2 17:49
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    public List<Article> listAll() throws Exception {
        try {
          return articleMapper.listAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
