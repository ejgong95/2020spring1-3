package logic;

import dao.UserDao;
import model.User;

public class UserCatalogImpl implements UserCatalog {
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void putUser(User user) {
		this.userDao.create(user);
	}

	public User getUser(User user) {
		return userDao.findByIdPwd(user);
	}

}