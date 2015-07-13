package com.alibaba.monitor.mavenWeb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.monitor.mavenWeb.pojos.Dept;
/**
 * @author zhuohaidi
 */
@Repository
public interface IDeptDao {
	public Dept LoadDept(Dept dept);
	public List<Dept> LoadAllDept(Dept dept);
	public void AddDept(Dept dept);
	public void ModifyDept(Dept dept);
	public void DeleteDept(Dept dept);
}
