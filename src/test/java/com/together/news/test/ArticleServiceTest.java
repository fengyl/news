package com.together.news.test;

import com.together.news.dto.SearchDto;
import com.together.news.entity.Article;
import com.together.news.service.ArticleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

/**
 * @author feng yanli
 * @time 2016/12/2 17:57
 */

public class ArticleServiceTest extends AbstractTestCase {
    @Autowired
    private ArticleService articleService;

    @Test
    public void listAll() throws Exception {
        List<Article> list = articleService.listAll();
        System.out.println(list.get(0));
    }

    @Test
    public void listByCategoryId() throws Exception {
        List<Article> list = articleService.listByCategoryId("1");
        System.out.println(list.get(0));
    }

    @Test
    public void delById() throws Exception {
        articleService.delById("1");
    }

    @Test
    public void listBySearchDto() throws Exception {
       SearchDto searchDto = null;
        List<Article> list = articleService.listBySearchDto(searchDto);

    }
}
