package com.brendon.lee.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.brendon.lee.vo.Review;

@Repository
public interface ReviewDAO {
    public void insert(Review review);
    
    public ArrayList<Review> readAll(int storeId);
}