package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class empDao {

	
	
	Map<Integer,empPojo> empMap= new HashMap<>();
	
	public empDao()
	{
		empMap.put(1,new empPojo(1,"rohan"));
	}
	public List<empPojo> getEmployees()
	{
		return new ArrayList<>(empMap.values());
	}
	 
	public empPojo getEmployee(int id)
	{
		return empMap.get(id);
	}
	public empPojo getEmployeebyName(String name)
	{
		empPojo e=null;
		
	  
		List<empPojo> li = new ArrayList<>(empMap.values());
		for(empPojo em:li)
		{
			if(em.getName().equals(name))
			{
				e=em;
				return e;
			}
		}
		return e;
	}
	public String insertEmployee(empPojo e)
	{
		int id=e.getId();
		empMap.put(id, e);
		
		return "Successfull";
	}
	public String delEmployee(int id)
	{
		empMap.remove(id);
		return "deleted";
	}
	public String updateEmployee(empPojo e,int id)
	{
		empMap.put(id, e);
		return "updated";
	}
}
