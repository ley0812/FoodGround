package com.brendon.lee.service;

import java.util.ArrayList;

import com.brendon.lee.vo.Keyword;
import com.brendon.lee.vo.Store;
import com.brendon.lee.vo.StoreCloseUnit;
import com.brendon.lee.vo.StoreReadUnit;
import com.brendon.lee.vo.StoreUpdateUnit;

public interface StoreService {
	public void insert(Store store);
	
	public ArrayList<Store> readAll(StoreReadUnit storeReadUnit);
	
	public Store readOne(StoreReadUnit storeReadUnit);
	
	public void update(StoreUpdateUnit storeTemp);
	
	public void close(StoreCloseUnit storeCloseUnit);
	
	public ArrayList<Store> search(Keyword keywordObj);
	
	public String makeDirectory(Store store);
}