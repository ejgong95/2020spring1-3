package logic;

import java.util.List;

import model.Item;

public interface ItemCatalog {
	List<Item> findItems(String name);
	List<Item> getItems();
	Item getItem(Integer id);
	void entryItem(Item item);
	void updateItem(Item item);
	void deleteItem(Integer id);
	
}
