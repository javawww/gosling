package com.gosling.core;

import java.io.Serializable;


@SuppressWarnings("serial")
public class ResultCode<T> implements Serializable {

	int code;

	String msg;

	T data;

	public ResultCode() {
		super();
	}

	public ResultCode(int code, String msg, T data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public static <T> ResultCode me(int code, String msg, T data) {
		return new ResultCode<T>(code, msg, data);
	}

	public static <T> ResultCode newErrorCode(String msg, T data) {
		return me(1, msg, data);
	}

	public static ResultCode newErrorCode(String msg) {
		return newErrorCode(msg, null);
	}

	public static <T> ResultCode newErrorCode(T data) {
		return newErrorCode(null, data);
	}

	public static ResultCode newErrorCode() {
		return newErrorCode(null, null);
	}

	public static <T> ResultCode newRightCode(String msg, T data) {
		return me(0, msg, data);
	}

	public static ResultCode newRightCode(String msg) {
		return newRightCode(msg, null);
	}

	public static <T> ResultCode newRightCode(T data) {
		return newRightCode(null, data);
	}

	public static <T> ResultCode newRightCode() {
		return newRightCode(null, null);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
