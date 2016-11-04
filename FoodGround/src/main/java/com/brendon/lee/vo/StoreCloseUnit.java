package com.brendon.lee.vo;

public class StoreCloseUnit {
	private int storeId;
	private int sectionId;
	private char open;
	
	public char getOpen() {
		return open;
	}
	public void setOpen(char open) {
		this.open = open;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public int getSectionId() {
		return sectionId;
	}
	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}
	@Override
	public String toString() {
		return "StoreCloseUnit [storeId=" + storeId + ", sectionId=" + sectionId + ", open=" + open + "]";
	}
}