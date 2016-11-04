package com.brendon.lee.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Brendon Hakmin Lee
 * @date 2016. 11. 4.
 * @comment 전역 예외 처리를 위한 컨트롤러 어드바이스
 */
@ControllerAdvice
public class ExceptionControllerAdvice {
	
	/**
	 * @author Brendon Hakmin Lee
	 * @date 2016. 11. 4.
	 * @comment 예외 발생시 확장자를 보고 예외 값을 리턴한다.
	 */
	@ExceptionHandler(FoodGroundException.class)
	public Object handleException(HttpServletRequest request, FoodGroundException foodGroundException) {

		String extension = request.getRequestURI();
				
		if (extension.endsWith(".json")) {
			return new ResponseEntity<String>(foodGroundException.getMessage(), HttpStatus.BAD_REQUEST);
		}
			
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("error", foodGroundException.getMessage());
		modelAndView.setViewName("error");
		return modelAndView;
	}
}