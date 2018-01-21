package com.gosling.service.classify;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gosling.entity.classify.Classify;
import com.gosling.dao.classify.ClassifyDao;

/**
 * 
 * @类描述：文章分类实现类
 * @项目名称：gosling-blog-service
 * @包名：com.gosling.service.classify
 * @类名称：ClassifyService
 * @创建人：快敲网络出品-技术交流请移步Q群：327947585
 * @创建时间：2018-1-21 12:08:10
 */
 @Service(value = "classifyService")
public class ClassifyService{

	@Resource(name="classifyDao")
	private ClassifyDao classifyDao; 
	
 	/**根据ID获取唯一*/
	public Classify getById(Integer id){
		return classifyDao.getById(id);
	}
	
	/**根据条件获取列表 分页*/
	public List<Classify> getClassifys(Map<String, String> queryMap, Integer start, Integer size){
		return classifyDao.getClassifys(queryMap,start,size);
	}
    
    /**根据条件获取数量 分页*/
    public Integer getClassifysCount(Map<String, String> queryMap){
    	return classifyDao.getClassifysCount(queryMap);
    }
    
     /**保存*/
	public Integer insert(Classify classify){
		return classifyDao.insert(classify);
	}
	
	 /**更新*/
	public Integer update(Classify classify){
		return classifyDao.update(classify);
	}
	
	/**删除*/
	public Integer delById(Integer id){
		return classifyDao.delById(id);
	}
 
 	/**根据对象查询*/
	public List<Classify> getByProperties(Map<String, String> queryMap) {
		return classifyDao.getByProperties(queryMap);
	}
 
}