package sample3;

public class Danaka implements Human {
	private String name;
	private Item item;
	
	public void setName(String name) {
		this.name = name;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	
	public void has() {
		// TODO Auto-generated method stub
		System.out.println(name + "입니다. 다음의 상품을 가지고 있습니다.");
		item.showName();
	}



}
