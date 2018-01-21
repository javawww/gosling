package com.gosling.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.gosling.core.Constants;
import com.gosling.core.WebSession;
import com.gosling.util.ResourceUtil;

/**
 * 权限拦截器
 * @author Administrator
 *
 */
public class AuthInterceptor implements HandlerInterceptor {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(AuthInterceptor.class);
	private Boolean flag;
	private List<String> excludeUrls;
	public List<String> getExcludeUrls() {
		return excludeUrls;
	}
	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		System.out.println("this is preHandle and it is say: the auth interceptor is good~");
		String requestPath = ResourceUtil.getRequestPath(request);
		Object obj =  WebSession.getSession(request, Constants.SESSION_MEMBER);
		if(excludeUrls.contains(requestPath)) {
			flag =  true;
		}else if(obj==null || "".equals(obj.toString())) {
			/**无权限拦截、跳转登陆页面*/
			response.sendRedirect(request.getContextPath()+"/login.html");
			flag =  false;
		}else {
			flag =  true;
		}
		return flag;
	}

}
