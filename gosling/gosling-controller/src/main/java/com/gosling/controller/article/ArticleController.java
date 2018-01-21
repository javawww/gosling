package com.gosling.controller.article;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gosling.controller.BaseController;
import com.gosling.core.ResultCode;

import com.gosling.entity.article.Article;
import com.gosling.service.article.ArticleService;

/**
 * 
 * @类描述：文章
 * @项目名称：gosling-controller
 * @包名：com.gosling.controller.article
 * @类名称：ArticleController
 * @创建人：快敲网络出品-技术交流请移步Q群：327947585
 * @创建时间：2018-1-21 12:25:31
 */
@Controller
@RequestMapping(value = "article")
public class ArticleController extends BaseController {

	/***注入业务service层*/
	@Resource
	private ArticleService							articleService;
	
	/***静态链接*/
	public static final String LIST = "list.html";//列表页面
	public static final String ADD = "add.html";//添加页面
	public static final String CREATE = "create.html";//新增操作
	public static final String EDIT = "edit.html";//编辑页面
	public static final String UPDATE = "update.html";//更新操作
	
	/**
	 * 文章列表 页面跳转
	 * @param request
	 * @param response
	 * @param dataMap
	 * @return
	 */
	@RequestMapping(value = ArticleController.LIST,method = {RequestMethod.GET })
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response,
            Map<String, Object> dataMap){
		return new ModelAndView("article/list");
	}
	
	/**
	 * 文章新增页面跳转
	 * @param request
	 * @param dataMap
	 * @return
	 */
	@RequestMapping(value = ArticleController.ADD,method = {RequestMethod.GET })
	public ModelAndView add(HttpServletRequest request, Map<String, Object> dataMap) {
		return new ModelAndView("article/add");
	}
	
	/**
	 * 添加文章
	 * @param member
	 * @param request
	 * @param dataMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = ArticleController.CREATE, method = { RequestMethod.POST })
    @ResponseBody
    public ResultCode<Object> create(Article article, HttpServletRequest request,
                                         Map<String, Object> dataMap) {
		Integer code = articleService.insert(article);
		if(code==1){
			return ResultCode.newRightCode("添加成功");
		}else{
			return ResultCode.newErrorCode("添加失败");
		}
	}
	
	/**
	 * 文章编辑页面跳转
	 * @param request
	 * @param id
	 * @param dataMap
	 * @return
	 */
	@RequestMapping(value = ArticleController.EDIT, method = { RequestMethod.GET })
    public ModelAndView edit(HttpServletRequest request, Integer id, Map<String, Object> dataMap){
		Article article = articleService.getById(id);
		dataMap.put("article", article);
		return new ModelAndView("article/edit");
	}
	
	/**
	 * 更新文章
	 * @param member
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = ArticleController.UPDATE, method = { RequestMethod.POST })
    @ResponseBody
    public ResultCode<Object> update(Article article, HttpServletRequest request) {
		Integer code = articleService.update(article);
		if(code==1){
			return ResultCode.newRightCode("更新成功");
		}else{
			return ResultCode.newErrorCode("更新失败");
		}
	}
	
}
