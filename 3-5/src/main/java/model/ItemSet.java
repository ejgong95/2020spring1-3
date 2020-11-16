package model;

public class ItemSet {
	private Item item;//상품 객체
	private Integer quantity; //갯수
	
	public ItemSet (Item item, Integer quantity) {
		this.item=item;
		this.quantity=quantity;
	}//생성자
	public void addQuantity(Integer addQuantity) {
		int number = addQuantity.intValue();//추가될 갯수
		int existQunatity = this.getQuantity().intValue();//기존의 갯수
		this.setQuantity(new Integer(number + existQunatity));//기존 갯수 + 추가 갯수
	}
	//수량 추가 메서드
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
}
