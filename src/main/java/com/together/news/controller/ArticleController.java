package com.together.news.controller;

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
public class ArticleController extends AbstractController{
    @Resource //激活一个命名资源的依赖注入
    private ArticleService articleService;

    @Resource
    private ArticleDateService articleDateService;

    @Resource
    private CategoryService categoryService;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String toList(){
        return "body/index";
    }

    /**
     * 查询出的文章列表页
     *
     * @param searchDto
     * @return
     */
    @RequestMapping(value = "index/{pageNo}", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject articleList(@PathVariable("pageNo") Integer pageNo,
                                  @RequestParam("pageSize") Integer pageSize,
                                  SearchDto searchDto) {
        searchDto.setPageNo(pageNo);
        searchDto.setPageSize(pageSize);
        List<ArticleDto> articleDtoList = Collections.emptyList();
        JSONArray jsonArray = new JSONArray();
        try{
            articleDtoList = articleService.listBySearchDto(searchDto);
            int offset = 0;
            if(pageNo != null){
                pageNo = pageNo <= 0 ? 0 : pageNo - 1;
                offset = pageNo * pageSize;
            }
            int i = 0;
            for (ArticleDto articleDto : articleDtoList){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", articleDto.getId());
                jsonObject.put("sequenceNumber",offset+(++i));
                jsonObject.put("name",articleDto.getName());
                jsonObject.put("title", articleDto.getTitle());
                jsonObject.put("categoryId", articleDto.getCategoryId());
                jsonArray.add(jsonObject);
            }
           /* model.addAttribute("articleDtoList", articleDtoList);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        int dataCount = 0;
        try{
            dataCount = articleService.countBySearchDto(searchDto);

        }catch (Exception e){
            e.printStackTrace();
        }
        return sendJsonArray(jsonArray, dataCount, 10);
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
        return "body/article_data";
    }

    @RequestMapping(value = "category/list", method = RequestMethod.GET)
    public String listCategory(Model model) throws Exception{
        try {
            List<Category> list = categoryService.listAll(null);
            model.addAttribute("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "body/index";
    }

    @RequestMapping(value = "load/category/list", method = RequestMethod.GET)
    public String listCategory(Model model, String id) throws Exception{
        try {
            List<Category> categoryList = categoryService.listAll(id);
            model.addAttribute("categoryList", categoryList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "body/index";
    }

    /**
     * 删除文章
     *
     * @param id
     * @return
     */

 @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delStudent(@PathVariable("id") String id){
        try{
            articleService.delById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  "redirect:/index";
    }
    /**
     * 删除
     *
     * @param id
     * @return
     *//*
    @RequestMapping(value = "delete/{id}",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject delById(@PathVariable("id") String id){
        try{
            if (id != null){
                articleService.delById(id);
                return sendMsgAndCode(AJAX_SUCCESS_CODE,"删除成功");
            } else {
                return sendMsgAndCode(AJAX_FAILURE_CODE,"删除成功");
            }
        }catch (Exception e){
            e.printStackTrace();
            return sendErrMsgAndErrCode(e);
        }
    }
*/
}
