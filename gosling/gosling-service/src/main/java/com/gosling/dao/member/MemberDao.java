package com.gosling.dao.member;

import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import com.gosling.entity.member.Member;

/**
 * 
 * @类描述：会员
 * @项目名称：高斯林开源项目
 * @包名：com.gosling.dao.member
 * @类名称：MemberDao
 * @创建人：快敲网络出品-技术交流请移步Q群：327947585
 * @创建时间：2018-1-18 19:15:24
 */
@Repository
public interface MemberDao {
 
 	/**根据ID获取唯一*/
	Member getById(Integer id);
	
	/**根据条件获取列表 分页*/
	List<Member> getMembers(@Param("queryMap") Map<String, String> queryMap,
                            @Param("start") Integer start, @Param("size") Integer size);
    
    /**根据条件获取数量 分页*/
    Integer getMembersCount(@Param("queryMap") Map<String, String> queryMap);
    
     /**保存*/
	Integer insert(Member member);
	
	 /**更新*/
	Integer update(Member member);
	
	/**删除*/
	Integer delById(Integer id);
	
	/**根据对象查询*/
	List<Member> getByProperties(@Param("queryMap") Map<String, String> queryMap);
}