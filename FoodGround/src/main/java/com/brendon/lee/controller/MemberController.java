package com.brendon.lee.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.brendon.lee.annotation.AuthCheck;
import com.brendon.lee.service.MemberService;
import com.brendon.lee.vo.Favorite;
import com.brendon.lee.vo.Member;
import com.brendon.lee.vo.MemberUnit;

/**
 * @author Brendon Hakmin Lee
 * @date 2016. 11. 4.
 * @comment 사용자 관련 제어 컨트롤러
 */
@Controller
@RequestMapping(value = "/members")
public class MemberController {
    @Autowired
    private MemberService memberService;

    /**
     * @author Brendon Hakmin Lee
     * @date 2016. 11. 4.
     * @comment 회원 가입 페이지로 이동
     */
    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public String join(Model model) {
        model.addAttribute("member", new Member());
        return "join";
    }

    /**
     * @author Brendon Hakmin Lee
     * @date 2016. 11. 4.
     * @comment 멤버정보와 ip주소를 이용해 회원가입을 처리해줍니다.
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute @Valid Member member, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "join";
        }
        System.setProperty("java.net.preferIPv4Stack", "true");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest();
        String ip = request.getHeader("X-FORWARDED-FOR");
        if (ip == null) {
            ip = request.getRemoteAddr();
        }
        member.setIp(ip);
        memberService.insert(member);
        return "login";
    }

    /**
     * @author Brendon Hakmin Lee
     * @date 2016. 11. 4.
     * @comment 주어진 sectionId와 nickName가 중복되는지 체크하는 함수
     */
    @ResponseBody
    @RequestMapping(value = "/{sectionId}/{nickName}", method = RequestMethod.GET)
    public Map<String, Boolean> existNickName(@PathVariable int sectionId, @PathVariable String nickName) {
        Map<String, Boolean> result = new HashMap<>();
        MemberUnit memberUnit = new MemberUnit();
        memberUnit.setSectionId(sectionId);
        memberUnit.setNickName(nickName);
        if (memberService.existNickName(memberUnit)) {
            result.put("result", Boolean.TRUE);
            return result;
        }
        result.put("result", Boolean.FALSE);
        return result;
    }

    /**
     * @author Brendon Hakmin Lee
     * @date 2016. 11. 4.
     * @comment 사용자의 매장에 대한 단골 여부를 입력해준다.
     */
    @AuthCheck
    @ResponseBody
    @RequestMapping(value = "/{storeId}/like", method = RequestMethod.POST)
    public Object insertFavorite(@CookieValue(value = "9011_FoodGround_cookie") String cookie,
            @RequestBody Favorite favorite) {
        String nickName = cookie.split("AND")[0];
        String sectionId = cookie.split("AND")[1];
        favorite.setNickName(nickName);
        favorite.setSectionId(Integer.parseInt(sectionId));
        memberService.insertFavorite(favorite);
        Map<String, Object> result = new HashMap<>();
        result.put("result", Boolean.TRUE);
        return result;
    }
}