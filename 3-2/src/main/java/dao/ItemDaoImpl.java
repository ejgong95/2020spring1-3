package dao;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import model.Item;

public class ItemDaoImpl implements ItemDao{
	private SqlSession session;

	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	public Item findById(Integer id) {
		return session.selectOne("mapper.usersMapper.getItem", id);
	}

	public List<Item> findAll() {
		List<Item> list =session.selectList("mapper.usersMapper.getItemList");
		return list;
	}

}
