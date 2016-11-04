package com.brendon.lee.service;

import com.brendon.lee.vo.Favorite;
import com.brendon.lee.vo.Member;
import com.brendon.lee.vo.MemberUnit;

public interface MemberService {
	public void insert(Member member);
	
	public boolean existNickName(MemberUnit memberUnit);

	public boolean existMember(MemberUnit memberUnit);
	
	public void insertFavorite(Favorite favorite);
}