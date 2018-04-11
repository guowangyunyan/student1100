package com.training.page;

import java.util.List;

public class SearchResult<T> {
	private List<T> result;// 对象集合
	private Pagination page;// 分页数据

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	public Pagination getPage() {
		return page;
	}

	public void setPage(Pagination page) {
		this.page = page;
	}

}
