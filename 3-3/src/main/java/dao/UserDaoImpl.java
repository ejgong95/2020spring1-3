package dao;

import org.apache.ibatis.session.SqlSession;

import model.User;

public class UserDaoImpl implements UserDao {
	private SqlSession session;
	
	
	public void setSession(SqlSession session) {
		this.session = session;
	}


	public User findByIdPwd(User user) {
		// TODO Auto-generated method stub
		return session.selectOne("mapper.usersMapper.getUser", user);
	}

}
