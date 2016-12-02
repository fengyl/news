package com.together.news.mapper;

import com.together.news.entity.ArticleDate;
import org.apache.ibatis.annotations.Param;


/**
 * ArticleDateMapper
 *
 * @author feng yanli
 * @time 2016/12/2 20:51
 */

public interface ArticleDateMapper {

    /**
     * 根据id查找文章详情
     * @param id
     * @return
     * @throws Exception
     */
    public String articleDetail(@Param("id") String id) throws Exception;
}
