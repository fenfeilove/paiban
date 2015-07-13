package com.alibaba.monitor.mavenWeb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.monitor.mavenWeb.pojos.Clazz;
/**
 * @author zhuohaidi
 */
@Repository
public interface IClassDao {
	public Clazz LoadClass(Clazz clazz);
	public List<Clazz> LoadAllClass(Clazz clazz);
	public void AddClass(Clazz clazz);
	public void ModifyClass(Clazz clazz);
	public void DeleteClass(Clazz clazz);
}
