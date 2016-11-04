package com.brendon.lee.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.brendon.lee.annotation.AuthCheck;
import com.brendon.lee.service.ReviewService;
import com.brendon.lee.vo.Review;

/**
 * @author Brendon Hakmin Lee
 * @date 2016. 11. 4.
 * @comment 리뷰 관련 제어 컨트롤러
 */
@Controller
@RequestMapping(value = "/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    
    @AuthCheck
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Object save(@CookieValue(value = "9011_FoodGround_cookie") String cookie, @RequestBody Review review) {
        String nickName = cookie.split("AND")[0];
        String sectionId = cookie.split("AND")[1];
        
        review.setNickName(nickName);
        review.setSectionId(Integer.parseInt(sectionId));
        
        System.setProperty("java.net.preferIPv4Stack", "true");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest();
        String ip = request.getHeader("X-FORWARDED-FOR");
        if (ip == null) {
            ip = request.getRemoteAddr();
        }
        
        review.setIp(ip);
        
        reviewService.insert(review);
       
        HashMap<String, Boolean> result = new HashMap<>();
        result.put(new String("result"), Boolean.TRUE);
        return result;    
    }
}