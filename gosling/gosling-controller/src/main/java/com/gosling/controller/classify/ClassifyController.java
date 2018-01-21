package com.gosling.controller.classify;

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

import com.gosling.entity.classify.Classify;
import com.gosling.service.classify.ClassifyService;

/**
 * 
 * @类描述：文章分类
 * @项目名称：gosling-controller
 * @包名：com.gosling.controller.classify
 * @类名称：ClassifyController
 * @创建人：快敲网络出品-技术交流请移步Q群：327947585
 * @创建时间：2018-1-21 13:58:38
 */
@Controller
@RequestMapping(value = "classify")
public class ClassifyController extends BaseController {

	/***注入业务service层*/
	@Resource
	private ClassifyService							classifyService;
	
	/***静态链接*/
	public static final String LIST = "list.html";//列表页面
	public static final String ADD = "add.html";//添加页面
	public static final String CREATE = "create.html";//新增操作
	public static final String EDIT = "edit.html";//编辑页面
	public static final String UPDATE = "update.html";//更新操作
	
	/**
	 * 文章分类列表 页面跳转
	 * @param request
	 * @param response
	 * @param dataMap
	 * @return
	 */
	@RequestMapping(value = ClassifyController.LIST,method = {RequestMethod.GET })
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response,
            Map<String, Object> dataMap){
		return new ModelAndView("classify/list");
	}
	
	/**
	 * 文章分类新增页面跳转
	 * @param request
	 * @param dataMap
	 * @return
	 */
	@RequestMapping(value = ClassifyController.ADD,method = {RequestMethod.GET })
	public ModelAndView add(HttpServletRequest request, Map<String, Object> dataMap) {
		return new ModelAndView("classify/add");
	}
	
	/**
	 * 添加文章分类
	 * @param member
	 * @param request
	 * @param dataMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = ClassifyController.CREATE, method = { RequestMethod.POST })
    @ResponseBody
    public ResultCode<Object> create(Classify classify, HttpServletRequest request,
                                         Map<String, Object> dataMap) {
		Integer code = classifyService.insert(classify);
		if(code==1){
			return ResultCode.newRightCode("添加成功");
		}else{
			return ResultCode.newErrorCode("添加失败");
		}
	}
	
	/**
	 * 文章分类编辑页面跳转
	 * @param request
	 * @param id
	 * @param dataMap
	 * @return
	 */
	@RequestMapping(value = ClassifyController.EDIT, method = { RequestMethod.GET })
    public ModelAndView edit(HttpServletRequest request, Integer id, Map<String, Object> dataMap){
		Classify classify = classifyService.getById(id);
		dataMap.put("classify", classify);
		return new ModelAndView("classify/edit");
	}
	
	/**
	 * 更新文章分类
	 * @param member
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = ClassifyController.UPDATE, method = { RequestMethod.POST })
    @ResponseBody
    public ResultCode<Object> update(Classify classify, HttpServletRequest request) {
		Integer code = classifyService.update(classify);
		if(code==1){
			return ResultCode.newRightCode("更新成功");
		}else{
			return ResultCode.newErrorCode("更新失败");
		}
	}
	
}
