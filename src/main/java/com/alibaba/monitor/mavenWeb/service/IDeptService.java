package com.alibaba.monitor.mavenWeb.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.monitor.mavenWeb.pojos.Dept;
/**
 * @author zhuohaidi
 */
@Repository
public interface IDeptService {
	public Dept getDept(Dept dept);
	public List<Dept> getAllDept(Dept dept);
	public void AddDept(Dept dept);
	public void AddmultiDept(List<Dept> deptlist);
	public void ModifyDept(Dept dept);
	public void DeleteDept(Dept dept);
}
