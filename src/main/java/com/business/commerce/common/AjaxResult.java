package com.business.commerce.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 返回视图类
 *  
 * @since Mar 20, 2019
 *
 */
@Data
public class AjaxResult implements Serializable {

	private final static String SUCCESS_CODE = "200";
	private final static String ERROR_CODE = "500";
	private final static String NOLOGIN_CODE = "401";
	private final static String COMMERCE_ERROR = "777";
	private final static String NODATA_CODE = "204";
	private final static String FEIGN_CODE = "888";

	/**
	 * 
	 */
	private static final long serialVersionUID = -6204780191596479147L;

	// 状态码
	private String status;
	// 消息
	private String msg;
	// 返回的数据
	private Object data;
	// 校验失败
	private String type;
	public AjaxResult() {
	}
	
	/**
	 * 构造一个有状态码、消息、返回数据的返回对象
	 * 
	 * @param status
	 * @param msg
	 * @param data
	 */
	public AjaxResult(String status, String msg, Object data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}
	
	/**
	 * 构造一个手动抛错的提示信息
	 * 
	 * @param status
	 * @param msg
	 * @param type
	 */
	public AjaxResult(String status, String msg, String type) {
		this.status = status;
		this.msg = msg;
		this.type = type;
	}
	
	/**
	 * 构造一个有状态码、消息的返回对象
	 * 
	 * @param status
	 * @param msg
	 */
	public AjaxResult(String status, String msg) {
		this(status, msg, null);
	}
	
	/**
	 * 构造一个有状态码的返回对象
	 * 
	 * @param status
	 */
	public AjaxResult(String status) {
		this(status, "", null);
	}
	
	/**
	 * 请求成功，只有状态码
	 *
	 * @return
	 * 
	 */
	public final static AjaxResult SUCCESS() {
		return SUCCESS("");
	}
	
	/**
	 * 请求成功，含状态码、提示消息
	 *
	 * @param msg
	 * @return
	 * 
	 */
	public final static AjaxResult SUCCESS(String msg) {
		return SUCCESS(msg, null);
	}
	
	/**
	 * 请求成功，含状态码、提示消息、返回数据
	 *
	 * @param msg
	 * @param data
	 * @return
	 * 
	 */
	public final static AjaxResult SUCCESS(String msg, Object data) {
		return new AjaxResult(SUCCESS_CODE, msg, data);
	}
	
	/**
	 * 请求报错，含状态码
	 *
	 * @return
	 * 
	 */
	public final static AjaxResult ERROR() {
		return ERROR("");
	}
	
	/**
	 * 请求报错，含状态码、提示消息
	 *
	 * @param msg
	 * @return
	 * 
	 */
	public final static AjaxResult ERROR(String msg) {
		return new AjaxResult(ERROR_CODE, msg);
	}

	public final static AjaxResult NOLOGIN(String msg) {
		return new AjaxResult(NOLOGIN_CODE, msg);
	}
	
	/**
	 * 手动抛出的异常
	 *
	 * @param msg
	 * @return
	 * 
	 */
	public final static AjaxResult SYSTEM_ERROR(String msg) {
		return new AjaxResult(COMMERCE_ERROR, msg, "error");
	}
	
	/**
	 * 未登陆获取或者请求超时
	 *
	 * @return
	 * 
	 */
	public final static AjaxResult LOGOUT(String msg) {
		return new AjaxResult(NOLOGIN_CODE, "未登录");
	}

	public final static AjaxResult NODATE(String msg) {
		return new AjaxResult(NODATA_CODE, msg);
	}

}
