package com.brendon.lee.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.brendon.lee.vo.Tag;

@Repository
public interface StoreTagDAO {
	public ArrayList<Tag> readAll();
}