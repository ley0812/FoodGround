package com.brendon.lee.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.brendon.lee.exception.FoodGroundException;
import com.brendon.lee.service.MemberService;
import com.brendon.lee.service.StoreService;
import com.brendon.lee.service.StoreTagService;
import com.brendon.lee.vo.Keyword;
import com.brendon.lee.vo.MemberUnit;
import com.brendon.lee.vo.StoreReadUnit;

/**
 * @author Brendon Hakmin Lee
 * @date 2016. 11. 4.
 * @comment 메인페이지 관련 제어 컨트롤러
 */
@Controller
public class HomeController {
    @Autowired
    private StoreService storeService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private StoreTagService storeTagService;

    /**
     * @author Brendon Hakmin Lee
     * @date 2016. 11. 4.
     * @comment 메인페이지로 가서 모든 매장의 정보와 태그정보를 받아 출력해준다.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(@CookieValue(value = "9011_FoodGround_cookie", required = false) String cookie) {

        StoreReadUnit storeReadUnit = new StoreReadUnit();

        if (false == StringUtils.isEmpty(cookie)) {
            storeReadUnit.setSectionId(Integer.parseInt(cookie.split("AND")[1]));
            storeReadUnit.setNickName(cookie.split("AND")[0]);
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        modelAndView.addObject("stores", storeService.readAll(storeReadUnit));
        modelAndView.addObject("tags", storeTagService.readAll());
        return modelAndView;
    }

    /**
     * @author Brendon Hakmin Lee
     * @date 2016. 11. 4.
     * @comment 사용자가 입력한 단어를 DB에서 검색해 매장 리스트를 가져온다. / 태그를 클릭하면 일치하는 매장 리스트를 가져온다. (띄어쓰기로 여러단어 검색 가능)
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView search(@CookieValue(value = "9011_FoodGround_cookie", required = false) String cookie,
            @RequestParam("keyword") String keyword) {

        if ((keyword.trim()).length() == 0) {
            throw new FoodGroundException("검색어를 입력해주세요.");
        }

        Keyword keywordObj = new Keyword();

        if (false == StringUtils.isEmpty(cookie)) {
            keywordObj.setSectionId(Integer.parseInt(cookie.split("AND")[1]));
            keywordObj.setNickName(cookie.split("AND")[0]);
        }

        keywordObj.setKeywords(keyword.trim().split("[ ]"));

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        modelAndView.addObject("stores", storeService.search(keywordObj));
        modelAndView.addObject("tags", storeTagService.readAll());
        return modelAndView;
    }

    /**
     * @author Brendon Hakmin Lee
     * @date 2016. 11. 4.
     * @comment 로그인 페이지로 이동한다.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * @author Brendon Hakmin Lee
     * @date 2016. 11. 4.
     * @comment 로그인 처리 후 성공시 쿠키를 저장한다.
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginCheck(@ModelAttribute MemberUnit memberUnit, HttpServletResponse response) {

        String coookieValue = memberUnit.getNickName() + "AND" + memberUnit.getSectionId();

        if (memberService.existMember(memberUnit)) {
            Cookie cookie = new Cookie("9011_FoodGround_cookie", coookieValue);
            cookie.setMaxAge(20 * 60);
            response.addCookie(cookie);
            return "redirect:/";
        }
        
        return "login";
    }

    /**
     * @author Brendon Hakmin Lee
     * @date 2016. 11. 4.
     * @comment 로그아웃 후 메인 페이지로 이동한다.
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        return "redirect:/";
    }
}