package com.gn.homework.controller;

import com.gn.homework.model.dao.MarketDao;
import com.gn.homework.model.vo.MarkerVo;

public class MarketController {
	
	public MarkerVo checkId(String userId) {
		MarkerVo result = new MarketDao().checkId(userId) ;
		return result;
	}
	
	public int insertUser(String userId, String userPw ,String userName) {
		int result = 0;
		return result;
	}
	
	
	
	
	
	
	
}
