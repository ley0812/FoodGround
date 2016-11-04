package com.brendon.lee.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

import com.brendon.lee.annotation.AuthCheck;

/**
 * @author Brendon Hakmin Lee
 * @date 2016. 11. 4.
 * @comment 로그인 여부를 체크하기 위한 인터셉터
 */
public class LoginInterceptor extends WebContentInterceptor {
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception) throws Exception {
		
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView mv) throws Exception {
		
	}

	/**
	 * @author Brendon Hakmin Lee
	 * @date 2016. 11. 4.
	 * @comment 컨트롤러 접근 전에 쿠키 존재 여부를 파악하여, 없으면 로그인 페이지로 넘겨준다.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		try {
			if (!(handler instanceof HandlerMethod)) {
				return true;
			}
			
			AuthCheck authCheck = ((HandlerMethod)handler).getMethodAnnotation(AuthCheck.class);
			if (authCheck == null) {
				return true;
			}	
			
			Cookie[] cookies = request.getCookies();

			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("9011_FoodGround_cookie")) {
					return true;
				}
			}
			response.sendRedirect("/login");
			return false;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}