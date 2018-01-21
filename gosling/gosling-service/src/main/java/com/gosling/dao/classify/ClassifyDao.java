package com.gosling.dao.classify;

import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import com.gosling.entity.classify.Classify;

/**
 * 
 * @类描述：文章分类
 * @项目名称：高斯林开源项目
 * @包名：com.gosling.dao.classify
 * @类名称：ClassifyDao
 * @创建人：快敲网络出品-技术交流请移步Q群：327947585
 * @创建时间：2018-1-21 12:08:10
 */
@Repository
public interface ClassifyDao {
 
 	/**根据ID获取唯一*/
	Classify getById(Integer id);
	
	/**根据条件获取列表 分页*/
	List<Classify> getClassifys(@Param("queryMap") Map<String, String> queryMap,
                            @Param("start") Integer start, @Param("size") Integer size);
    
    /**根据条件获取数量 分页*/
    Integer getClassifysCount(@Param("queryMap") Map<String, String> queryMap);
    
     /**保存*/
	Integer insert(Classify classify);
	
	 /**更新*/
	Integer update(Classify classify);
	
	/**删除*/
	Integer delById(Integer id);
	
	/**根据对象查询*/
	List<Classify> getByProperties(@Param("queryMap") Map<String, String> queryMap);
}