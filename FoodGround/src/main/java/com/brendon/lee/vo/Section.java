package com.brendon.lee.vo;

import java.util.Date;

public class Section {
	private int id;
	private String name;
	private Date registerDate;
	private Date changeDate;
	private String nickName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Date getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "Section [id=" + id + ", name=" + name + ", registerDate=" + registerDate + ", changeDate=" + changeDate
				+ ", nickName=" + nickName + "]";
	}
}