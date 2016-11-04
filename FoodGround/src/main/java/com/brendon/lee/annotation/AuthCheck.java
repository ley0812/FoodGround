package com.brendon.lee.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Brendon Hakmin Lee
 * @date 2016. 11. 4.
 * @comment Login Interceptor를 위한 Annotation 정의
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AuthCheck {
	
}
