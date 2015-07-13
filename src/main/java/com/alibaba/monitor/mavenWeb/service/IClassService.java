package com.alibaba.monitor.mavenWeb.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.monitor.mavenWeb.pojos.Clazz;
/**
 * @author zhuohaidi
 */
@Repository
public interface IClassService {
	public Clazz getClazz(Clazz clazz);
	public List<Clazz> getAllClass(Clazz clazz);
	public void AddClass(Clazz clazz);
	public void AddmultiClass(List<Clazz> clazzlist);
	public void ModifyClass(Clazz clazz);
	public void DeleteClass(Clazz clazz);
}
