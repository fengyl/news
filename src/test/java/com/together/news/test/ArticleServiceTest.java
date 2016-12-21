package com.together.news.test;

import com.together.news.dto.ArticleDto;
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
        List<ArticleDto> list = articleService.listAll();
        System.out.println(list.get(0));
    }

    @Test
    public void listByCategoryId() throws Exception {
        List<ArticleDto> list = articleService.listByCategoryId("1");
        System.out.println(list.get(0));
    }

    @Test
    public void delById() throws Exception {
        articleService.delById("1");
    }

    @Test
    public void listBySearchDto() throws Exception {
        SearchDto searchDto = null;
        searchDto.setTitle("东方");
        List<ArticleDto> list = articleService.listBySearchDto(searchDto);

    }

    @Test
    public void countBySearchDto() throws Exception {
        SearchDto searchDto = null;
       int a= articleService.countBySearchDto(searchDto);
        System.out.println(a);
    }

}
