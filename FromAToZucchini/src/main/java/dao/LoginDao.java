package dao;

import model.Custom_info;

public interface LoginDao {
	Custom_info getUser(String id);
	String getPassword(String id);
	Integer getIdCount(String id);
	
	//가입자 등록시 사용하는 메서드
	void entryUser(Custom_info guest);
}