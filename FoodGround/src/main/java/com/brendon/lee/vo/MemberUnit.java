package com.brendon.lee.vo;

public class MemberUnit {
	private int sectionId;
	private String nickName;
	private String password;
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "MemberUnit [nickName=" + nickName + ", sectionId=" + sectionId + ", password=" + password + "]";
	}
}