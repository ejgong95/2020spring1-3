package logic;

import java.util.List;

import model.Item;

public interface Shop {
	List<Item> getItems();
	Item getItem(Integer id);
}
