package com.brendon.lee.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brendon.lee.dao.StoreTagDAO;
import com.brendon.lee.vo.Tag;

/**
 * @author Brendon Hakmin Lee
 * @date 2016. 11. 4.
 * @comment 태그 관련 서비스 처리
 */
@Service
public class StoreTagServiceImpl implements StoreTagService {
	@Autowired
	private StoreTagDAO storeTagDAO;	

	/**
	 * @author Brendon Hakmin Lee
	 * @date 2016. 11. 4.
	 * @comment 모든 태그를 가져와서 정렬시켜 태그 리스트를 리턴한다.
	 */
	public Map<String, Integer> readAll() {
		ArrayList<Tag> tags = storeTagDAO.readAll();
		
		Map<String, Integer> tagCount = new HashMap<String, Integer>();
		TagComparator tagComparator = new TagComparator(tagCount);
		TreeMap<String, Integer> sorted_tags = new TreeMap<>(tagComparator);
		
		for(Tag tag : tags) {
			count(tagCount, tag.getKeyword().split("[,]"));
			count(tagCount, tag.getMenu().split("[,]"));
			count(tagCount, tag.getService().split("[,]"));
		}
		
		sorted_tags.putAll(tagCount);
		return sorted_tags;
	}
	
	/**
	 * @author Brendon Hakmin Lee
	 * @date 2016. 11. 4.
	 * @comment 단어의 개수를 카운트한다.
	 */
	public void count(Map<String, Integer> tagCount, String[] words) {
		for(String word : words){
			word = word.trim();
			if(word.length() == 0) {
				break;
			}
			if(tagCount.containsKey(word)){
				tagCount.put(word, tagCount.get(word)+1);
			}else {
				tagCount.put(word, 1);
			}
		}
	}
}