package com.gosling.dao.article;

import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import com.gosling.entity.article.Article;

/**
 * 
 * @类描述：文章
 * @项目名称：高斯林开源项目
 * @包名：com.gosling.dao.article
 * @类名称：ArticleDao
 * @创建人：快敲网络出品-技术交流请移步Q群：327947585
 * @创建时间：2018-1-21 12:05:36
 */
@Repository
public interface ArticleDao {
 
 	/**根据ID获取唯一*/
	Article getById(Integer id);
	
	/**根据条件获取列表 分页*/
	List<Article> getArticles(@Param("queryMap") Map<String, String> queryMap,
                            @Param("start") Integer start, @Param("size") Integer size);
    
    /**根据条件获取数量 分页*/
    Integer getArticlesCount(@Param("queryMap") Map<String, String> queryMap);
    
     /**保存*/
	Integer insert(Article article);
	
	 /**更新*/
	Integer update(Article article);
	
	/**删除*/
	Integer delById(Integer id);
	
	/**根据对象查询*/
	List<Article> getByProperties(@Param("queryMap") Map<String, String> queryMap);
}