package com.alibaba.monitor.mavenWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.monitor.mavenWeb.pojos.Dept;
import com.alibaba.monitor.mavenWeb.service.IDeptService;
/**
 * @author zhuohaidi
 */
@RestController
@RequestMapping("/department")
public class DedtController{

	@Autowired
	IDeptService deptservice;
	@RequestMapping(method = RequestMethod.GET)
	public List<Dept> getAllDept (){
		return deptservice.getAllDept(null);
	}

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@RequestBody Dept dept) {
    	deptservice.ModifyDept(dept);
        return "{\"ok\":true}";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestBody Dept dept) {
    	deptservice.AddDept(dept);
        return "{\"ok\":true}";
    }
}