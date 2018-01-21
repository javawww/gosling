package com.gosling.controller.member;

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

import com.gosling.entity.member.Member;
import com.gosling.service.member.MemberService;

/**
 * 
 * @类描述：会员
 * @项目名称：gosling-controller
 * @包名：com.gosling.controller.member
 * @类名称：MemberController
 * @创建人：快敲网络出品-技术交流请移步Q群：327947585
 * @创建时间：2018-1-21 11:26:55
 */
@Controller
@RequestMapping(value = "member")
public class MemberController extends BaseController {

	/***注入业务service层*/
	@Resource
	private MemberService							memberService;
	
	/***静态链接*/
	public static final String LIST = "list.html";//列表页面
	public static final String ADD = "add.html";//添加页面
	public static final String CREATE = "create.html";//新增操作
	public static final String EDIT = "edit.html";//编辑页面
	public static final String UPDATE = "update.html";//更新操作
	
	/**
	 * 会员列表 页面跳转
	 * @param request
	 * @param response
	 * @param dataMap
	 * @return
	 */
	@RequestMapping(value = MemberController.LIST,method = {RequestMethod.GET })
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response,
            Map<String, Object> dataMap){
		return new ModelAndView("gosling/member/list");
	}
	
	/**
	 * 会员新增页面跳转
	 * @param request
	 * @param dataMap
	 * @return
	 */
	@RequestMapping(value = MemberController.ADD,method = {RequestMethod.GET })
	public ModelAndView add(HttpServletRequest request, Map<String, Object> dataMap) {
		return new ModelAndView("gosling/member/add");
	}
	
	/**
	 * 添加会员
	 * @param member
	 * @param request
	 * @param dataMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = MemberController.CREATE, method = { RequestMethod.POST })
    @ResponseBody
    public ResultCode<Object> create(Member member, HttpServletRequest request,
                                         Map<String, Object> dataMap) {
		Integer code = memberService.insert(member);
		if(code==1){
			return ResultCode.newRightCode("添加成功");
		}else{
			return ResultCode.newErrorCode("添加失败");
		}
	}
	
	/**
	 * 会员编辑页面跳转
	 * @param request
	 * @param id
	 * @param dataMap
	 * @return
	 */
	@RequestMapping(value = MemberController.EDIT, method = { RequestMethod.GET })
    public ModelAndView edit(HttpServletRequest request, Integer id, Map<String, Object> dataMap){
		Member member = memberService.getById(id);
		dataMap.put("member", member);
		return new ModelAndView("gosling/member/edit");
	}
	
	/**
	 * 更新会员
	 * @param member
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = MemberController.UPDATE, method = { RequestMethod.POST })
    @ResponseBody
    public ResultCode<Object> update(Member member, HttpServletRequest request) {
		Integer code = memberService.update(member);
		if(code==1){
			return ResultCode.newRightCode("更新成功");
		}else{
			return ResultCode.newErrorCode("更新失败");
		}
	}
	
}
