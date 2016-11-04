package com.brendon.lee.vo;

public class StoreLog {
	private int storeId;
	private String logType;
	private String memo;
	private String beforeMemo;
	private String nickName;

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getBeforeMemo() {
		return beforeMemo;
	}

	public void setBeforeMemo(String beforeMemo) {
		this.beforeMemo = beforeMemo;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "StoreLog [storeId=" + storeId + ", logType=" + logType + ", memo=" + memo
				+ ", beforeMemo=" + beforeMemo + ", nickName=" + nickName + "]";
	}
}