package dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;

import dao.TeamDao;
import model.Team;

public class TeamDaoImpl implements TeamDao {
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	
	public List<Team> getTeamList() throws DataAccessException {
		//매퍼의 쿼리 호출
		List<Team> list = sqlSession.selectList("mapper.usersMapper.getTeamList");
		return list;
	}
	

	
	
}
