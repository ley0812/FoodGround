package com.brendon.lee.vo;

public class Tag {
	private String keyword;
	private String menu;
	private String service;
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	@Override
	public String toString() {
		return "Tag [keyword=" + keyword + ", menu=" + menu + ", service=" + service + "]";
	}
}