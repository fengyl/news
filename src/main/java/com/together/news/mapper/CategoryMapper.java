package com.together.news.mapper;

import com.together.news.entity.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * CategoryMapper
 *
 * @author feng yanli
 * @time 2016/12/19 14:51
 */

public interface CategoryMapper {

    /**
     * 查询所有栏目
     * @param id
     * @return
     * @throws Exception
     */
    public List<Category> listAll(String id) throws Exception;
}
