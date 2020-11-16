package logic;

import java.util.List;

import model.Item;

public interface ItemCatalog {
	void putItem(Item item); //상품 등록
	List<Item> getItems(Integer pageNo); //상품 목록
	Integer getItemCount(); //상품 갯수
	Item getItem(String code); //상품 상세
}
