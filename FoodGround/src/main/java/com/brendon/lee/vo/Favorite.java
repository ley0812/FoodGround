package com.brendon.lee.vo;

public class Favorite {
	private int id;
	private String nickName;
	private int sectionId;
	private int storeId;
	private char toggle;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public char getToggle() {
		return toggle;
	}
	public void setToggle(char toggle) {
		this.toggle = toggle;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getSectionId() {
		return sectionId;
	}
	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	@Override
	public String toString() {
		return "FavoriteUpdateUnit [id=" + id + ", nickName=" + nickName + ", sectionId=" + sectionId + ", storeId="
				+ storeId + ", toggle=" + toggle + "]";
	}
}