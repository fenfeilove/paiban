package com.alibaba.monitor.mavenWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.monitor.mavenWeb.pojos.Emp;
import com.alibaba.monitor.mavenWeb.pojos.EmpArrayed;
import com.alibaba.monitor.mavenWeb.service.IEmpService;
/**
 * @author zhuohaidi
 */
@RestController
@RequestMapping("/employee")
public class EmpController {

	@Autowired
	IEmpService empservice;

	@RequestMapping(method = RequestMethod.GET)
	public List<Emp> getAllEmp() {
		return empservice.getAllEmp(null);
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public List<Emp> searchEmp(@RequestBody String keyword,
			@RequestBody String deptno) {
		int deptnum = Integer.parseInt(deptno);
		return empservice.getEmpByKey(keyword, deptnum);
	}

	@RequestMapping(value = "/batchAdd", method = RequestMethod.POST)
	public String batchAdd(@RequestBody List<Emp> emplist) {
		empservice.AddMulitEmp(emplist);
		return "{\"ok\":true}";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		Emp emp = new Emp();
		emp.setEmpno(id);
		empservice.DeleteEmp(emp);
		return "{\"ok\":true}";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(@RequestBody Emp empl) {
		// System.out.println(empl);
		empservice.ModifyEmp(empl);
		return "{\"ok\":true}";
	}
	@RequestMapping(value = "/batchEdit", method = RequestMethod.GET)
	public String batchEdit(Integer deptno,Integer chose , String keyword) 
	{
		if(deptno==null) deptno=0;
		if(chose==null) chose=1;
		boolean chosed=true;
		if(chose==0) chosed=false;
		if(keyword==null) keyword="";
		EmpArrayed emparrayed=new EmpArrayed();
		emparrayed.setArrayed(chosed);
		emparrayed.setDeptno(deptno);
		emparrayed.setKeyword(keyword);
		empservice.ModifyMulitEmp(emparrayed);
		return "{\"ok\":true}";
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@RequestBody Emp empl) {
		// System.out.println(empl);
		empservice.AddEmp(empl);
		return "{\"ok\":true}";
	}

}