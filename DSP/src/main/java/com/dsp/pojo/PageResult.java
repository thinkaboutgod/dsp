package com.dsp.pojo;

import java.util.ArrayList;
import java.util.List;

public class PageResult<T> {
	private int pageIndex;
	private int totalPage;
	private List<T> list = new ArrayList<T>();

	public PageResult() {
		super();
	}

	public PageResult(int pageIndex, int totalPage, List<T> list) {
		super();
		this.pageIndex = pageIndex;
		this.totalPage = totalPage;
		this.list = list;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
