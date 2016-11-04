package com.brendon.lee.dao;

import org.springframework.stereotype.Repository;

import com.brendon.lee.vo.StoreLog;

@Repository
public interface StoreLogDAO {
	public void insertStoreLog(StoreLog storeLog);
}
