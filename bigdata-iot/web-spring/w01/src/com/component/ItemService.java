package com.component;

import java.util.ArrayList;

import com.frame.Dao;
import com.frame.Service;
import com.vo.Item;

public class ItemService implements Service<String, Item> {

	Dao dao;
	
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
	@Override
	public void register(Item v) {
		dao.insert(v);
	}

	@Override
	public void remove(String k) {
		dao.delete(k);
	}

	@Override
	public void modify(Item v) {
		dao.update(v);
	}

	@Override
	public Item get(String k) {
		return (Item) dao.select(k);
	}

	@Override
	public ArrayList<Item> get() {
		return dao.select();
	}

}
