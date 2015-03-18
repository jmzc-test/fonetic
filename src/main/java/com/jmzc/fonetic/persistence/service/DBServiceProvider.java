package com.jmzc.fonetic.persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.jmzc.fonetic.persistence.domain.Item;

@Component("DBService")
@Transactional
public class DBServiceProvider implements DBService 
{

	@Autowired
	private DBRepository repository;
	

	public List<Item> getItems(String type) throws IllegalArgumentException
	{
		Assert.notNull(type, "Type is required");
		Assert.hasLength(type, "Type is required");

		return this.repository.findByType(type);
	}

	public List<Item> getItems() 
	{
		

		return this.repository.findAll();
	}
	

}
