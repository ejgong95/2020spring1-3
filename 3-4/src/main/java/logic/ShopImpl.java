package logic;

import model.User;

public class ShopImpl implements Shop {
	private UserCatalog userCatalog;
	
	
	public void setUserCatalog(UserCatalog userCatalog) {
		this.userCatalog = userCatalog;
	}


	public User getUser(User user) {
		// TODO Auto-generated method stub
		return userCatalog.getUser(user);
	}


	public void putUser(User user) {
		this.userCatalog.putUser(user);
		
	}
	 


}
