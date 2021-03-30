package com.example.pojo.params;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分页结果
 */
@Data
@NoArgsConstructor
public class PageResult<T> {
    private Integer totalPage;  //总页数
    private List<T> list; // 数据

    public PageResult(Integer totalPage, List<T> list) {
		this.totalPage = totalPage;
		this.list = list;
	}

}