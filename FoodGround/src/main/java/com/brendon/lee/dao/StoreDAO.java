package com.brendon.lee.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.brendon.lee.vo.Keyword;
import com.brendon.lee.vo.Store;
import com.brendon.lee.vo.StoreCloseUnit;
import com.brendon.lee.vo.StoreReadUnit;
import com.brendon.lee.vo.StoreUpdateUnit;

@Repository
public interface StoreDAO {
	public void insert(Store store);

	public ArrayList<Store> readAll(StoreReadUnit storeReadUnit);

	public Store readOne(StoreReadUnit storeReadUnit);

	public void update(StoreUpdateUnit storeUpdateUnit);
	
	public void delete(StoreCloseUnit storeCloseUnit);
	
	public ArrayList<Store> search(Keyword keywordObj);
	
	public void updateStoreDupilicateName(Store store);
}