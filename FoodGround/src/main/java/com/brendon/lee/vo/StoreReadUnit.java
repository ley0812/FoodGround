package com.brendon.lee.vo;

public class StoreReadUnit {
	private int id;
	private int sectionId;
	private String nickName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSectionId() {
		return sectionId;
	}
	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	@Override
	public String toString() {
		return "StoreReadUnit [id=" + id + ", sectionId=" + sectionId + ", nickName=" + nickName + "]";
	}
}