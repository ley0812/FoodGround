package com.brendon.lee.controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.brendon.lee.annotation.AuthCheck;
import com.brendon.lee.service.ReviewService;
import com.brendon.lee.service.StoreLogService;
import com.brendon.lee.service.StoreService;
import com.brendon.lee.vo.Store;
import com.brendon.lee.vo.StoreCloseUnit;
import com.brendon.lee.vo.StoreLog;
import com.brendon.lee.vo.StoreReadUnit;
import com.brendon.lee.vo.StoreUpdateUnit;

/**
 * @author Brendon Hakmin Lee
 * @date 2016. 11. 4.
 * @comment 매장 관련 제어 컨트롤러
 */
@Controller
@RequestMapping(value="/stores")
public class StoreController {
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private StoreLogService storeLogService;
	
	@Autowired
	private ReviewService reviewService;

	/**
	 * @author Brendon Hakmin Lee
	 * @date 2016. 11. 4.
	 * @comment 업체 등록 페이지로 이동해준다.
	 */
	@AuthCheck
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String save(Model model) {
		model.addAttribute("store", new Store());
		return "storeJoin";
	}
	
	/**
	 * @author Brendon Hakmin Lee
	 * @date 2016. 11. 4.
	 * @comment 매장 정보를 등록해준다.
	 */
	@AuthCheck
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@CookieValue(value="9011_FoodGround_cookie", required=false) String cookie, @ModelAttribute @Valid Store store, BindingResult bindingResult) {
		if(store.getFile1().isEmpty()) {
			bindingResult.rejectValue("file1", "field.required", "이미지를 업로드해주세요.");
		}
		
		if(bindingResult.hasErrors()) {
		    return "storeJoin";
		}
	    
		if (false == StringUtils.isEmpty(cookie)) {
	         store.setNickName(cookie.split("AND")[0]);
	    }
		
		storeService.insert(store);
		return "redirect:/";
	}
	
	/**
	 * @author Brendon Hakmin Lee
	 * @date 2016. 11. 4.
	 * @comment 업체의 상세정보를 보여준다.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView show(@CookieValue(value="9011_FoodGround_cookie", required=false) String cookie, @PathVariable int id) {
		
		StoreReadUnit storeReadUnit = new StoreReadUnit();
		
		if (StringUtils.isEmpty(cookie)) {
			storeReadUnit.setId(id);
		} else {
			String nickName = cookie.split("AND")[0];
			String sectionId = cookie.split("AND")[1];
			storeReadUnit.setId(id);
			storeReadUnit.setSectionId(Integer.parseInt(sectionId));
			storeReadUnit.setNickName(nickName);
		}
				
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("detail");
		modelAndView.addObject("store", storeService.readOne(storeReadUnit));
		modelAndView.addObject("reviews", reviewService.readAll(id));
		
		return modelAndView;
	}
	
	/**
	 * @author Brendon Hakmin Lee
	 * @date 2016. 11. 4.
	 * @comment 업체 정보를 수정해준다. 업체 정보 업데이트와 로그 삽입을 해준다.
	 */
	@AuthCheck
	@ResponseBody
	@RequestMapping(value = "/edit", method = RequestMethod.POST) 
	public Object edit(@CookieValue(value="9011_FoodGround_cookie") String cookie, @RequestBody StoreLog storeLog) {
		String nickName = cookie.split("AND")[0];
		StoreUpdateUnit storeUpdateUnit = new StoreUpdateUnit();
		
		storeUpdateUnit.setStoreId(storeLog.getStoreId());
		storeUpdateUnit.setType(storeLog.getLogType());
		storeUpdateUnit.setMemo(storeLog.getMemo());
		
		storeLog.setNickName(nickName);
		
		storeService.update(storeUpdateUnit);
		storeLogService.insertStoreLog(storeLog);
		
		HashMap<String, Boolean> result = new HashMap<>();
		result.put(new String("result"), Boolean.TRUE);
		return result;
	}
	
	/**
	 * @author Brendon Hakmin Lee
	 * @date 2016. 11. 4.
	 * @comment 폐업 신고를 해주는 함수
	 */
	@AuthCheck
	@ResponseBody
	@RequestMapping(value = "/close", method = RequestMethod.POST)
	public Object close(@RequestBody StoreCloseUnit storeCloseUnit) {
		storeService.close(storeCloseUnit);
		HashMap<String, Object> result = new HashMap<>();
		result.put("result", Boolean.TRUE);
		result.put("open", storeCloseUnit.getOpen());
		return result;
	}
}