package com.brendon.lee.vo;

public class StoreUpdateUnit {
	private String type;
	private String memo;
	private int storeId;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	@Override
	public String toString() {
		return "StoreUpdateUnit [type=" + type + ", memo=" + memo + ", storeId=" + storeId + "]";
	}
}