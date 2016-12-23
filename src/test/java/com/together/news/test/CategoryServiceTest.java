package com.together.news.test;

import com.together.news.entity.Category;
import com.together.news.service.CategoryService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author feng yanli
 * @time 2016/12/19 22:51
 */

public class CategoryServiceTest  extends AbstractTestCase{

    @Autowired
    private CategoryService categoryService;

    @Test
    public void listAll() throws Exception {
        List<Category> list = categoryService.listAll("0");
        System.out.println(list.get(0));
    }
}
