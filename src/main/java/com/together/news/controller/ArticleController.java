package com.together.news.controller;

import com.together.news.dto.ArticleDto;
import com.together.news.dto.SearchDto;
import com.together.news.entity.Article;
import com.together.news.entity.Category;
import com.together.news.service.ArticleDateService;
import com.together.news.service.ArticleService;
import com.together.news.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * ArticleController
 *
 * @author feng yanli
 * @time 2016/12/11 22:27
 */

@Controller
@RequestMapping(value = "")
public class ArticleController {
    @Resource //激活一个命名资源的依赖注入
    private ArticleService articleService;

    @Resource
    private ArticleDateService articleDateService;

    @Resource
    private CategoryService categoryService;

    /**
     * 查询出的文章列表页
     *
     * @param searchDto
     * @param model
     * @return
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String articleList(SearchDto searchDto,
                              Model model) {
        List<ArticleDto> articleDtoList = Collections.emptyList();
        try{
            articleDtoList = articleService.listBySearchDto(searchDto);
            model.addAttribute("articleDtoList", articleDtoList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }

      /**
     * 去文章详情页
     * @return
     */
   /* @RequestMapping(value = "to/content/{id}", method = RequestMethod.GET)
    public String toContent(@PathVariable("id") String id){
        return "article_data";
    }*/

    /**
     * 文章详情
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "content/{id}", method = RequestMethod.GET)
    public String articleContent(@PathVariable(value = "id") String id,
                             Model model) {
        try{
            if(id == null){
                System.out.print("无此文章！");
            }else {
                String articleData = articleDateService.articleDetail(id);
                model.addAttribute("articleData", articleData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "article_data";
    }

    /**
     * 删除文章
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delStudent(@PathVariable("id") String id){
        try{
            articleService.delById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  "redirect:/index";
    }

    @RequestMapping(value = "category/list", method = RequestMethod.GET)
    public String listCategory(Model model) throws Exception{
        try {
            List<Category> list = categoryService.listAll(null);
            model.addAttribute("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }

    @RequestMapping(value = "load/category/list", method = RequestMethod.GET)
    public String listCategory(Model model, String id) throws Exception{
        try {
            List<Category> categoryList = categoryService.listAll(id);
           model.addAttribute("categoryList", categoryList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }
}
