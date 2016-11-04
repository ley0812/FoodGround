package com.brendon.lee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brendon.lee.dao.MemberDAO;
import com.brendon.lee.vo.Favorite;
import com.brendon.lee.vo.Member;
import com.brendon.lee.vo.MemberUnit;

/**
 * @author Brendon Hakmin Lee
 * @date 2016. 11. 4.
 * @comment 사용자 관련 서비스 처리
 */
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;

	@Override
	public void insert(Member member) {
		memberDAO.insert(member);
	}
	
	@Override
	public boolean existNickName(MemberUnit memberUnit) {
		return memberDAO.existNickName(memberUnit);
	}
	
	@Override
	public boolean existMember(MemberUnit memberUnit) {
		return memberDAO.existMember(memberUnit);
	}

	@Override
	public void insertFavorite(Favorite favorite) {
		memberDAO.insertFavorite(favorite);
	}
}