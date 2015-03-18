package com.jmzc.fonetic;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jmzc.fonetic.bean.ItemBean;
import com.jmzc.fonetic.exception.DBException;
import com.jmzc.fonetic.persistence.domain.Item;
import com.jmzc.fonetic.persistence.service.DBService;


@RestController  /*( @Controller + @ResponseBody */
public class RESTDBController
{
	
	@Autowired
	private DBService service;
	
	
	public  RESTDBController() 
	{
	
	}
	
	@RequestMapping(value="/item/list", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<ItemBean> getItems(@RequestParam(value="type", required=false) String type) 
	{
	
		if("EXCEPTION".equals(type))
			throw new DBException();
		
		List<Item> l = (type != null )?this.service.getItems(type):this.service.getItems();
		
		List<ItemBean> response = new ArrayList<ItemBean>();
		if ( l != null && l.size() > 0)
		{
			for (Item item: l )
			{
				
			ItemBean bean = new ItemBean();
			bean.setName(item.getName());
			bean.setType(item.getType());
			
			response.add(bean);
			}
		}
		return response;
		
		
		

	}
}
	
   