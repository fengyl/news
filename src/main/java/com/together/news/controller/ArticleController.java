package com.together.news.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.together.news.dto.ArticleDto;
import com.together.news.dto.SearchDto;
import com.together.news.entity.Category;
import com.together.news.service.ArticleDateService;
import com.together.news.service.ArticleService;
import com.together.news.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
public class ArticleController extends AbstractController {
    @Resource //激活一个命名资源的依赖注入
    private ArticleService articleService;

    @Resource
    private ArticleDateService articleDateService;

    @Resource
    private CategoryService categoryService;

    @RequestMapping(value = "to/index", method = RequestMethod.GET)
    public String articleList(SearchDto searchDto, Model model) {
        try {
            List<ArticleDto> articleDtoList = articleService.listBySearchDto(searchDto);
            model.addAttribute("articleDtoList", articleDtoList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }

    /**
     * 文章详情
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "content/{id}", method = RequestMethod.GET)
    public String articleContent(@PathVariable(value = "id") String id,
                                 Model model) {
        try {
            if (id == null) {
                System.out.print("无此文章！");
            } else {
                String title = articleService.queryNameById(id);
                String articleData = articleDateService.articleDetail(id);
                model.addAttribute("articleData", articleData);
                model.addAttribute("title", title);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "article_data";
    }

    @RequestMapping(value = "category/list", method = RequestMethod.GET)
    public String listCategory(Model model) throws Exception {
        try {
            List<Category> list = categoryService.listAll(null);
            model.addAttribute("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }

    @RequestMapping(value = "to/category", method = RequestMethod.GET)// 刷json的请求路径这个。
    @ResponseBody
    public JSON listCategory(String id) throws Exception {
        List<Category> categoryList = Collections.emptyList();
        JSONArray jsonArray = new JSONArray();
        try {
            categoryList = categoryService.listAll(id);
            for (Category category : categoryList) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", category.getId());
                jsonObject.put("pId", category.getParentId());
                jsonObject.put("name", category.getName());
                jsonObject.put("isParent","true");
                jsonArray.add(jsonObject);
            }
        } catch (Exception e) {
            sendErrMsgAndErrCode(e);
        }
        return jsonArray;

    }

    /**
     * 删除文章
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delStudent(@PathVariable("id") String id) {
        try {
            articleService.delById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/to/index";
    }

    /**
     * 新增文章
     * @param articleDto
     * @return
     */
    @RequestMapping(value = "new", method = RequestMethod.POST)
    public String newArticle(ArticleDto articleDto) {
        try {
            articleService.newArticle(articleDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  "redirect:index";
    }
}