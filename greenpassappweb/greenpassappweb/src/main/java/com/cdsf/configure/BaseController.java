/**
 * @Title: BaseController.java
 * @Description: 
 * @Copyright: Copyright (c) 2014
 * @Company: cdsf
 * @author jiangzhao
 * @date 2014年8月21日
 * @version 2.0
 */
package com.cdsf.configure;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @Title: BaseController
 * @Description:
 * @Company: cdsf
 * @author jiangzhao
 * @date 2014年8月21日
 */
public abstract class BaseController extends AbstractController {
	/**
	 * 
	 * @Title: getRequest
	 * @Description: 得到request
	 * @return request
	 */
	protected HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
	}

	/**
	 * 
	 * @Title: getSession
	 * @Description: 得到session
	 * @return session
	 */
	protected HttpSession getSession() {
		return getRequest().getSession();
	}

}
