package logic;

import model.Custom_info;

public interface LoginCatalog {
	String getPwd(String id);
	Integer getIdCnt(String id);
	Custom_info getUser(String id);
	
	void putUser(Custom_info guest);
}
