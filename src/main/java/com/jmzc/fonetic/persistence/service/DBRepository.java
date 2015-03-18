package com.jmzc.fonetic.persistence.service;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.jmzc.fonetic.persistence.domain.Item;

public interface DBRepository extends Repository<Item, Integer> 
{


		List<Item> findByType(String type);
		
		List<Item> findAll();
		
}
