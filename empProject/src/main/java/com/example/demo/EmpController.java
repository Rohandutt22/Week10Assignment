package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {
	
	@Autowired
	empDao emp;
	
	@GetMapping("/get")
	public List<empPojo> getEmps()
	{
		return emp.getEmployees();
	}
    
	
	@GetMapping("/get/{d}")
	public empPojo getEmp(@PathVariable  String d)
	{
		int id=Integer.parseInt(d);
		return emp.getEmployee(id);
	}
	
	
	@GetMapping("/getbyname/{d}")
	public empPojo getEmpByName(@PathVariable  String d)
	{
		
		return emp.getEmployeebyName(d);
	}
	@PostMapping("/insert")
	public String insertEmp(@RequestBody empPojo e)
	{
		
		return emp.insertEmployee(e);
	}
	@DeleteMapping("/delete/{d}")
	public String deleteEmp(@PathVariable  String d)
	{
		int id=Integer.parseInt(d);
		return emp.delEmployee(id);
	}
	
	@PostMapping("/update/{d}")
	public String updateEmp(@RequestBody empPojo e,@PathVariable  String d)
	{
		int id=Integer.parseInt(d);
		return emp.updateEmployee(e,id);
	}
}
