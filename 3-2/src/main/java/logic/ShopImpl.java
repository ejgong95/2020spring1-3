package logic;

import java.util.List;

import model.Item;

public class ShopImpl implements Shop {
	private ItemCatalog itemCatalog;
	
	public void setItemCatalog(ItemCatalog itemCatalog) {
		this.itemCatalog = itemCatalog;
	}
	
	
	public Item getItem(Integer id) {
		return this.itemCatalog.getItem(id);
	}
	

	public List<Item> getItems() {		
		return this.itemCatalog.getItemList();
	}


}
