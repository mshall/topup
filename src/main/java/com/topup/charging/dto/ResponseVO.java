package com.topup.charging.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
* @author Mohamed S. El-Shall 
*/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVO<T> {
	private int code;
	private String message;
	private T results;
}
