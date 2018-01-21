package com.gosling.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.gosling.entity.member.Member;
/**
 * SESSION管理
 * @author Administrator
 *
 */
public class WebSession {

	/**
	 * 放入SESSION
	 * @param request
	 * @param member
	 */
	public static void putSession(HttpServletRequest request,String name,Object obj) {
		HttpSession session = request.getSession();
		session.setAttribute(name, obj);
	}
	
	/**
	 * 获取SESSION
	 * @param request
	 * @param name
	 * @return
	 */
	public static Object getSession(HttpServletRequest request,String name) {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute(name);
		return obj;
	}
	
	/**
	 * 销毁SESSION 
	 * @param request
	 * @param name
	 */
	public static void removeSession(HttpServletRequest request,String name) {
		HttpSession session = request.getSession(false);
		if(session != null){
			session.removeAttribute(name);
		}
	}
	
}
