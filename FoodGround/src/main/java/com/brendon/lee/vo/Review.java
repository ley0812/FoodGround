package com.brendon.lee.vo;

import java.util.Date;

public class Review {
	private int id;
	private int storeId;
	private int sectionId;
	private String nickName;
	private String contents;
	private String ip;
	private Date registerDate;

	public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

    @Override
    public String toString() {
        return "Review [id=" + id + ", storeId=" + storeId + ", sectionId=" + sectionId + ", nickName=" + nickName
                + ", contents=" + contents + ", ip=" + ip + ", registerDate=" + registerDate + "]";
    }
}