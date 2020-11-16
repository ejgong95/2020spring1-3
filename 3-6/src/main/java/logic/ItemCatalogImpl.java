package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ItemDao;
import model.Item;

@Service
public class ItemCatalogImpl implements ItemCatalog{
	@Autowired
	private ItemDao itemDao;

	public List<Item> getItems() {
		return itemDao.findAll();
	}

	public Item getItem(Integer id) {
		return itemDao.findById(id);
	}

	public void entryItem(Item item) {
		itemDao.create(item);
	}

	public void updateItem(Item item) {
		itemDao.update(item);
	}

	public void deleteItem(Integer id) {
		itemDao.delete(id);
	}

	public List<Item> findItems(String name) {
		return itemDao.findByName(name);
	}

}
