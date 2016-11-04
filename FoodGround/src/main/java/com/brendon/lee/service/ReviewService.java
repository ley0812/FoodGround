package com.brendon.lee.service;

import java.util.ArrayList;

import com.brendon.lee.vo.Review;

public interface ReviewService {
    public void insert(Review review);
    
    public ArrayList<Review> readAll(int storeId);
}