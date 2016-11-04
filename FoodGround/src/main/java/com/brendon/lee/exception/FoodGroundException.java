package com.brendon.lee.exception;

/**
 * @author Brendon Hakmin Lee
 * @date 2016. 11. 4.
 * @comment 예외처리를 위한 사용자 정의 Exception
 */
public class FoodGroundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public FoodGroundException(String message) {
		super(message);
	}
}