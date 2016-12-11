package com.together.news.mapper;

import com.together.news.dto.SearchDto;
import com.together.news.entity.Article;

import java.util.List;

/**
 * ArticleMapper
 *
 * @author feng yanli
 * @time 2016/12/2 17:40
 */

public interface ArticleMapper {
    /**
     * 查询全部
     *
     * @return
     * @throws Exception
     */
    public List<Article> listAll() throws Exception;

    /**
     * 根据栏目id查询文章信息
     *
     * @return
     * @throws Exception
     */
    public List<Article> listByCategoryId(String categoryId) throws Exception;

    /**
     * 根据文章id联表删除
     * @param id
     * @throws Exception
     */
    public void delById(String id) throws Exception;

    /**
     * 根据搜索条件模糊查询
     * @return
     * @throws Exception
     */
    public List<Article> listBySearchDto(SearchDto searchDto) throws Exception;
}
