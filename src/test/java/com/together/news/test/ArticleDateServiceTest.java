package com.together.news.test;

import com.together.news.entity.ArticleDate;
import com.together.news.service.ArticleDateService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author feng yanli
 * @time 2016/12/2 21:02
 */

public class ArticleDateServiceTest extends AbstractTestCase {
    @Autowired
    private ArticleDateService articleDateService;

    @Test
    public void articleDetail() throws Exception {
        String content = articleDateService.articleDetail("1");
        System.out.println(content);
    }
}
