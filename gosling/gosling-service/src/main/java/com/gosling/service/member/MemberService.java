package com.gosling.service.member;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gosling.entity.member.Member;
import com.gosling.dao.member.MemberDao;

/**
 * 
 * @类描述：会员实现类
 * @项目名称：gosling-blog-service
 * @包名：com.gosling.service.member
 * @类名称：MemberService
 * @创建人：快敲网络出品-技术交流请移步Q群：327947585
 * @创建时间：2018-1-18 19:15:24
 */
 @Service(value = "memberService")
public class MemberService{

	@Resource(name="memberDao")
	private MemberDao memberDao; 
	
 	/**根据ID获取唯一*/
	public Member getById(Integer id){
		return memberDao.getById(id);
	}
	
	/**根据条件获取列表 分页*/
	public List<Member> getMembers(Map<String, String> queryMap, Integer start, Integer size){
		return memberDao.getMembers(queryMap,start,size);
	}
    
    /**根据条件获取数量 分页*/
    public Integer getMembersCount(Map<String, String> queryMap){
    	return memberDao.getMembersCount(queryMap);
    }
    
     /**保存*/
	public Integer insert(Member member){
		return memberDao.insert(member);
	}
	
	 /**更新*/
	public Integer update(Member member){
		return memberDao.update(member);
	}
	
	/**删除*/
	public Integer delById(Integer id){
		return memberDao.delById(id);
	}
 
 	/**根据对象查询*/
	public List<Member> getByProperties(Map<String, String> queryMap) {
		return memberDao.getByProperties(queryMap);
	}
 
}