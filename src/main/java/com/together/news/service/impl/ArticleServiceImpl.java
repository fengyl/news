package com.together.news.service.impl;

import com.together.news.dto.ArticleDto;
import com.together.news.dto.SearchDto;
import com.together.news.entity.Article;
import com.together.news.mapper.ArticleMapper;
import com.together.news.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * 查询全部
     *
     * @return
     * @throws Exception
     */
    public List<ArticleDto> listAll() throws Exception {
        try {
          return articleMapper.listAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * 根据栏目id查询文章信息
     *
     * @return
     * @throws Exception
     */
    public List<ArticleDto> listByCategoryId(String categoryId) throws Exception {
        try {
            if(categoryId != null) {
                return articleMapper.listByCategoryId(categoryId);
            }
            return null;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * 根据文章id删除
     * @param id
     * @throws Exception
     */
    public void delById(String id) throws Exception {
        try {
            if(id != null) {
                articleMapper.delById(id);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * 根据搜索条件模糊查询
     * @return
     * @throws Exception
     */
    public List<ArticleDto> listBySearchDto(SearchDto searchDto) throws Exception {
        List<ArticleDto> list = Collections.emptyList();
        try {
            list = articleMapper.listBySearchDto(searchDto);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return list;
    }

    /**
     * 根据id查找标题名称
     * @param id
     * @return
     * @throws Exception
     */
    public String queryNameById(String id) throws Exception {
        try {
            if (id != null) {
               return articleMapper.queryNameById(id);
            }
            return null;
        } catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * 新增文章
     * @param articleDto
     * @throws Exception
     */
    @Transactional(rollbackFor = {Exception.class,RuntimeException.class,Exception.class},propagation = Propagation.REQUIRED)
    public void newArticle(ArticleDto articleDto) throws Exception{
        try {
            Article article = (new Article()).constructFromDto(articleDto);
            articleDto.setId(article.getId());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public int countBySearchDto(SearchDto searchDto) throws Exception{
        Integer count = 0;
        try {
            count = articleMapper.countBySearchDto(searchDto);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return count == null ? 0 : count;
    }
}
