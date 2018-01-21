package com.gosling.service.article;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gosling.entity.article.Article;
import com.gosling.dao.article.ArticleDao;

/**
 * 
 * @类描述：文章实现类
 * @项目名称：gosling-blog-service
 * @包名：com.gosling.service.article
 * @类名称：ArticleService
 * @创建人：快敲网络出品-技术交流请移步Q群：327947585
 * @创建时间：2018-1-21 12:05:36
 */
 @Service(value = "articleService")
public class ArticleService{

	@Resource(name="articleDao")
	private ArticleDao articleDao; 
	
 	/**根据ID获取唯一*/
	public Article getById(Integer id){
		return articleDao.getById(id);
	}
	
	/**根据条件获取列表 分页*/
	public List<Article> getArticles(Map<String, String> queryMap, Integer start, Integer size){
		return articleDao.getArticles(queryMap,start,size);
	}
    
    /**根据条件获取数量 分页*/
    public Integer getArticlesCount(Map<String, String> queryMap){
    	return articleDao.getArticlesCount(queryMap);
    }
    
     /**保存*/
	public Integer insert(Article article){
		return articleDao.insert(article);
	}
	
	 /**更新*/
	public Integer update(Article article){
		return articleDao.update(article);
	}
	
	/**删除*/
	public Integer delById(Integer id){
		return articleDao.delById(id);
	}
 
 	/**根据对象查询*/
	public List<Article> getByProperties(Map<String, String> queryMap) {
		return articleDao.getByProperties(queryMap);
	}
 
}