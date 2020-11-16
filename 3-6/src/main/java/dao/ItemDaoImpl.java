package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Item;

@Repository
public class ItemDaoImpl implements ItemDao{
	@Autowired
	private SqlSession session;
	
	public List<Item> findAll() {
		return session.selectList("mapper.usersMapper.getItemList");
	}

	public Item findById(Integer id) {
		return session.selectOne("mapper.usersMapper.getItem", id);
	}

	public void create(Item item) {
		session.insert("mapper.usersMapper.putItem", item);		
	}

	public void update(Item item) {
		session.update("mapper.usersMapper.updateItem", item);
	}

	public void delete(Integer id) {
		session.delete("mapper.usersMapper.deleteItem", id);
	}

	public List<Item> findByName(String name) {
		return session.selectList("mapper.usersMapper.findItem", name);
	}

}
