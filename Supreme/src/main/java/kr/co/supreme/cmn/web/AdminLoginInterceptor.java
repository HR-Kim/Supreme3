package kr.co.supreme.cmn.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


import kr.co.supreme.cmn.web.AdminLoginInterceptor;
import kr.co.supreme.user.service.User;

public class AdminLoginInterceptor extends HandlerInterceptorAdapter {
	private final Logger LOG = LoggerFactory.getLogger(AdminLoginInterceptor.class);
	
	//컨트롤러 실행전 가로채기
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		try {
			HttpSession  httpSession  = request.getSession();
			User user = (User) httpSession.getAttribute("user");
			
			LOG.debug("==============================================");
			LOG.debug("=user="+user);
			LOG.debug("==============================================");
			
			
			if(null == user) {
				String context = request.getContextPath();
				response.sendRedirect(context+"/admin/admin_login.jsp");
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	private String getViewName(HttpServletRequest request) throws Exception {
		// /ehr/board_attr/get_retrieve.do
		//String contextPath = request.getContextPath();// ehr
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		
		if(null == uri || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}
		
		return uri;		
	}
	
	
	//컨트롤러 수행후 DispacherServlet이 뷰로 보내기전에 호출
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	//뷰까지 수행하고 나서 호출 
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

}
