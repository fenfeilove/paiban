package com.alibaba.monitor.mavenWeb.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.monitor.mavenWeb.dao.IClassDao;
import com.alibaba.monitor.mavenWeb.dao.ILogDao;
import com.alibaba.monitor.mavenWeb.pojos.Clazz;
import com.alibaba.monitor.mavenWeb.pojos.Log;
import com.alibaba.monitor.mavenWeb.service.IClassService;
/**
 * @author zhuohaidi
 */
@Service
public class ClassServiceImpl implements IClassService {
	
	@Autowired
	IClassDao classdao;
	@Autowired
	ILogDao logdao;
	@Override
	public Clazz getClazz(Clazz clazz) {
		// TODO Auto-generated method stub
		return classdao.LoadClass(clazz);
	}

	@Override
	public List<Clazz> getAllClass(Clazz clazz) {
		// TODO Auto-generated method stub
		return classdao.LoadAllClass(clazz);
	}

	@Override
	public void AddClass(Clazz clazz) {
		// TODO Auto-generated method stub
		
		Log log=new Log();
		log.setEmpno(1);
		log.setDates(new Date());
		log.setTablename("clazz");
		log.setOperate("add");
		log.setBfupdate("");
		log.setUpdated(clazz.toString());
		logdao.AddLog(log);
		classdao.AddClass(clazz);
	}

	@Override
	public void ModifyClass(Clazz clazz) {
		// TODO Auto-generated method stub
		
		Log log=new Log();
		log.setEmpno(1);
		log.setDates(new Date());
		log.setTablename("clazz");
		log.setOperate("update");
		log.setBfupdate(classdao.LoadClass(clazz).toString());
		log.setUpdated(clazz.toString());
		logdao.AddLog(log);
		classdao.ModifyClass(clazz);
	}

	@Override
	public void DeleteClass(Clazz clazz) {
		// TODO Auto-generated method stub
		
		Log log=new Log();
		log.setEmpno(1);
		log.setDates(new Date());
		log.setTablename("clazz");
		log.setOperate("delete");
		log.setBfupdate(classdao.LoadClass(clazz).toString());
		log.setUpdated("");
		logdao.AddLog(log);
		classdao.DeleteClass(clazz);
	}

	@Override
	public void AddmultiClass(List<Clazz> clazzlist) {
		// TODO Auto-generated method stub
		for(int i=0;i<clazzlist.size();i++)
		{
			AddClass(clazzlist.get(i));
		}
	}
}
