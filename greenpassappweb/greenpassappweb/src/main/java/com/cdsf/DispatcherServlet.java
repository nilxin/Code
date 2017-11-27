package com.cdsf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import com.cdsf.webmvc.exception.BusinessException;
import com.cdsf.webmvc.logging.Logger;
import com.cdsf.webmvc.logging.LoggerFactory;

/**
 * 
 * @Title: DispatcherServlet.java
 * @Description:
 * @Company: cdsf
 * @author caohuantai
 * @date 2016年7月6日下午3:33:47
 */
public class DispatcherServlet extends org.springframework.web.servlet.DispatcherServlet {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2692447239941454481L;
	private Logger log = LoggerFactory.getLogger(getClass());

	/** {@inheritDoc} */
	@Override
	protected void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			super.doService(request, response);
		} catch (Exception e) {
			log.error(e.getMessage());
			if (!(e instanceof BusinessException)) {
				log.error(e.getMessage(), e);
			}
		}
	}

	@Override
	protected void render(ModelAndView mv, HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getAttribute("MultipartRequest") != null)
			return;
		super.render(mv, request, response);
	}

	@Override
	protected WebApplicationContext initWebApplicationContext() {
		WebApplicationContext webApplicatioContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		onRefresh(webApplicatioContext);
		return webApplicatioContext;
	}

}
