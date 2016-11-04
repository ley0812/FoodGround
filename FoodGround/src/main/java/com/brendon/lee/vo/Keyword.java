package com.brendon.lee.vo;

import java.util.Arrays;

public class Keyword {
	private String[] keywords;
	private int sectionId;
	private String nickName;

	public String[] getKeywords() {
		return keywords;
	}
	
	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
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
		return "Keyword [keywords=" + Arrays.toString(keywords) + ", sectionId=" + sectionId + ", nickName=" + nickName
				+ "]";
	}
}