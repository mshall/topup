package com.topup.charging.exception;
public class ErrorResponse {

	private String message;
	private int code;

	public ErrorResponse() {

	}

	public ErrorResponse(int code) {
		this.code = code;
	}

	public ErrorResponse(String message) {
		this.message = message;
	}

	public ErrorResponse(int code, String message) {
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