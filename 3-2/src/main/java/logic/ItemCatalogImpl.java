package logic;

import java.util.List;

import dao.ItemDao;
import model.Item;

public class ItemCatalogImpl implements ItemCatalog {
	private ItemDao itemDao;

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	public Item getItem(Integer id) {
		return this.itemDao.findById(id);
	}
	
	public List<Item> getItemList() {
		return this.itemDao.findAll();
	}




}
