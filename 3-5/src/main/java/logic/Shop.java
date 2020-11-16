package logic;

import java.util.List;

import model.Cart;
import model.Item;
import model.ItemSet;
import model.User;

public interface Shop {
	List<Item> getItems();//과일 목록
	Item getItem(Integer id);//과일 상세정보 , 상품정보로 상품 검색 (add)
	User getUser(User user);//가입자 검색
	void putUser(User user);//가입자 등록
	
	//매출정보와 관련된 메서드
	Integer calculateTotal(List<ItemSet> itemList);//구매금액 총액 계산
	Cart getCart();//장바구니 정보 출력
	void checkout(User user, Cart cart); //장바구니 상품 구매 (매출정보 저장)
	
	
}





