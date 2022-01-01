package com.topup.charging.exception;
public class BusinessException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String message;
	private int code;
	
	public BusinessException() {

	}
	
	public BusinessException(int code) {
		this.code = code;
	}
	
	public BusinessException(String message) {
		this.message = message;
	}

	public BusinessException(int code, String message) {
		this.message = message;
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	
}