package logic;

import java.util.List;

import dao.ItemDao;
import model.Item;

public class ItemCatalogImpl implements ItemCatalog {
	private ItemDao itemDao;

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}


	public List<Item> getItemList() {
		// TODO Auto-generated method stub
		return this.itemDao.findAll();
	}

}
