package com.brendon.lee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brendon.lee.dao.StoreLogDAO;
import com.brendon.lee.vo.StoreLog;

/**
 * @author Brendon Hakmin Lee
 * @date 2016. 11. 4.
 * @comment 매장 수정 로그 서비스 처리
 */
@Service
public class StoreLogServiceImpl implements StoreLogService {
	@Autowired 
	private StoreLogDAO storeLogDAO; 
	
	@Override
	public void insertStoreLog(StoreLog storeLog) {
		storeLogDAO.insertStoreLog(storeLog);
	}
}