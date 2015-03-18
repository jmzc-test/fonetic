package com.jmzc.fonetic.persistence.service;

import java.util.List;

import com.jmzc.fonetic.persistence.domain.Item;


public interface DBService 
{
	
	public List<Item> getItems(String type);
	
	public List<Item> getItems();


}
