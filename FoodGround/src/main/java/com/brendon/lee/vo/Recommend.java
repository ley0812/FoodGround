package com.brendon.lee.vo;

import java.util.Date;

public class Recommend {
	private int id;
	private int storeId;
	private String menuName;
	private String comment;
	private String nickName;
	private Date registerDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	@Override
	public String toString() {
		return "Recommend [id=" + id + ", storeId=" + storeId + ", menuName=" + menuName + ", comment=" + comment
				+ ", nickName=" + nickName + ", registerDate=" + registerDate + "]";
	}
}