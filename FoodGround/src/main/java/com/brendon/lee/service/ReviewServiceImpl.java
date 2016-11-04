package com.brendon.lee.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brendon.lee.dao.ReviewDAO;
import com.brendon.lee.vo.Review;

/**
 * @author Brendon Hakmin Lee
 * @date 2016. 11. 4.
 * @comment 리뷰 관련 서비스 처리
 */
@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewDAO reviewDAO;

    @Override
    public void insert(Review review) {
        reviewDAO.insert(review);
    }
    
    @Override
    public ArrayList<Review> readAll(int storeId) {
        return reviewDAO.readAll(storeId);
    }
}