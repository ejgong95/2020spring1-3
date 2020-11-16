package dao;

import java.util.List;

import model.Item;

public interface ItemDao {
	List<Item> findByName(String name);
	List<Item> findAll();//모든 상품 검색
	Item findById(Integer id);//특정 상품 검색
	void create(Item item);//상품 등록
	void update(Item item);//상품 변경
	void delete(Integer id);//상품 삭제
	
}
