package com.business.commerce.common;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 分页查询条件类
 *
 * @since  2018年11月2日
 *
 */
@Data
@NoArgsConstructor
public class PageDto implements Serializable {

	private static final long serialVersionUID = 6672868810683022692L;

	// 当前页
	private Integer current = 1;
	// 返回条数
	private Integer size = 10;
	// 偏移量
	private Integer offset = 0;
	// 是否需要分页
	private Boolean isPage = true;
	
	public PageDto(Integer current, Integer size) {
		super();
		this.current = current;
		this.size = size;
	}
	public PageDto(Integer current, Integer size, Boolean isPage) {
		super();
		this.current = current;
		this.size = size;
		this.isPage = isPage;
	}
}
