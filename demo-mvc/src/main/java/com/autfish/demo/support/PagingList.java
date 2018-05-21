package com.autfish.demo.support;

import java.util.List;

public class PagingList<T> {

	public static final String PAGE_INDEX_NAME = "pageIndex";
	public static final int DEFAULT_PAGE_INDEX = 1;
	public static final String PAGE_SIZE_NAME = "pageSize";
	public static final int DEFAULT_PAGE_SIZE = 5;
	
	private int pageIndex = 1;
	private int pageSize = 20;
	private int pageCount = 0;
	private int itemCount = 0;
	
	private List<T> items;

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}
}
