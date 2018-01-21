package com.gosling.controller;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.gosling.util.StringUtil;


/**
* 
* @类描述：控制层基类， 所有controller类都需要继承此类
* @项目名称：gosling-controller
* @包名：com.gosling.blog.controller
* @类名称：BaseController
* @创建人：快敲网络出品-技术交流请移步Q群：327947585
* @创建时间：2017-12-10 18:30:15
*/
public class BaseController {
    protected static org.apache.log4j.Logger log = 
    		org.apache.log4j.LogManager.getLogger(BaseController.class);

        protected boolean isNull(Object... objs) {
            boolean flag = false;
            for (Object obj : objs) {
                if (obj == null || "".equals(obj)) {
                    flag = true;
                    break;
                }
            }
            return flag;
        }

        @InitBinder
        public void initBinder(WebDataBinder binder) {
            //date,datetime
            binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
                public void setAsText(String value) {
                    if (StringUtil.isEmpty(value)) {
                        setValue(null);
                        return;
                    }
                    try {
                        if (value.length() == 10) {
                            setValue(new SimpleDateFormat("yyyy-MM-dd").parse(value));
                        } else if (value.length() == 8) {
                            setValue(new SimpleDateFormat("HH:mm:ss").parse(value));
                        } else if (value.length() == 16) {
                            setValue(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(value));
                        } else {
                            setValue(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(value));
                        }

                    } catch (ParseException e) {
                        log.error("Can not convert '" + value + "' to java.util.Date", e);
                    }
                }

                public String getAsText() {
                    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format((Date) getValue());
                }

            });
            //int
            binder.registerCustomEditor(Integer.class, new PropertyEditorSupport() {
                public void setAsText(String value) {
                    if (StringUtil.isEmpty(value)) {
                        setValue(0);
                        return;
                    }
                    setValue(Integer.parseInt(value));
                }

                public String getAsText() {
                    return getValue().toString();
                }

            });

            //long
            binder.registerCustomEditor(Long.class, new PropertyEditorSupport() {
                public void setAsText(String value) {
                    if (StringUtil.isEmpty(value)) {
                        setValue(0);
                        return;
                    }
                    setValue(Long.parseLong(value));
                }

                public String getAsText() {
                    return getValue().toString();
                }

            });

            //double
            binder.registerCustomEditor(Double.class, new PropertyEditorSupport() {
                public void setAsText(String value) {
                    if (StringUtil.isEmpty(value)) {
                        setValue(0);
                        return;
                    }
                    setValue(Double.parseDouble(value));
                }

                public String getAsText() {
                    return getValue().toString();
                }

            });
        }

        public ModelAndView redirectHandlerFor301(String sURL) {
            RedirectView rv = new RedirectView(sURL);
            rv.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
            rv.setUrl(sURL);
            ModelAndView mv = new ModelAndView(rv);
            return mv;
        }

        /**
         * 调用此方法说明你的controller方法将要转到显示系统消息页面
         * @param stack
         * @param message
         * @param links
         */
        public void showMessage(Map<String, Object> stack, String message,
                                List<Map<String, String>> links) {
            if (links == null || links.size() == 0) {
                links = new ArrayList<Map<String, String>>();
                Map<String, String> link = new HashMap<String, String>();
                link.put("text", "返回上一页");
                link.put("url", "javascript:history.back()");
                links.add(link);
            }
            stack.put("messageInfo", message);
            stack.put("links", links);
            stack.put("msgType", "message");
        }
}
