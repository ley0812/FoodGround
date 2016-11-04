package com.brendon.lee.dao;

import org.springframework.stereotype.Repository;

import com.brendon.lee.vo.Favorite;
import com.brendon.lee.vo.Member;
import com.brendon.lee.vo.MemberUnit;

@Repository
public interface MemberDAO {
	public void insert(Member member);
	
	public boolean existNickName(MemberUnit memberUnit);
	
	public boolean existMember(MemberUnit memberUnit);
	
	public void insertFavorite(Favorite favoriteUpdateUnit);
}