package com.autfish.demo.web.model;

import java.util.HashMap;
import java.util.Map;

public class ErrorModel {

	private String message;
	private Map<String, String> pages = new HashMap<>();
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Map<String, String> getPages() {
		return pages;
	}
	public void setPages(Map<String, String> pages) {
		this.pages.putAll(pages);
	}
	public void setPage(String title, String url) {
		this.pages.put(title, url);
	}
}
