package com.together.news.service.impl;

import com.together.news.mapper.ArticleDateMapper;
import com.together.news.service.ArticleDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ArticleDateServiceImpl
 *
 * @author feng yanli
 * @time 2016/12/2 20:58
 */

@Service("articleDateService")
public class ArticleDateServiceImpl implements ArticleDateService{
    @Autowired
    private ArticleDateMapper articleDateMapper;

    public String articleDetail(String id) throws Exception {
        try {
            if (id != null) {
                return articleDateMapper.articleDetail(id);
            }
            return null;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
