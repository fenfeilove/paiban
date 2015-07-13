package com.alibaba.monitor.mavenWeb.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.monitor.mavenWeb.dao.IDeptDao;
import com.alibaba.monitor.mavenWeb.dao.ILogDao;
import com.alibaba.monitor.mavenWeb.pojos.Dept;
import com.alibaba.monitor.mavenWeb.pojos.Log;
import com.alibaba.monitor.mavenWeb.service.IDeptService;
/**
 * @author zhuohaidi
 */
@Service
public class DeptServiceImpl implements IDeptService {

	@Autowired
	IDeptDao deptDao;
	@Autowired
	ILogDao logdao;
	@Override
	public Dept getDept(Dept dept) {
		// TODO Auto-generated method stub
		return deptDao.LoadDept(dept);
	}

	@Override
	public List<Dept> getAllDept(Dept dept) {
		// TODO Auto-generated method stub
		return deptDao.LoadAllDept(dept);
	}

	@Override
	public void AddDept(Dept dept) {
		// TODO Auto-generated method stub
		
		Log log=new Log();
		log.setEmpno(1);
		log.setDates(new Date());
		log.setTablename("dept");
		log.setOperate("add");
		log.setBfupdate("");
		log.setUpdated(dept.toString());
		logdao.AddLog(log);
		deptDao.AddDept(dept);
	}

	@Override
	public void ModifyDept(Dept dept) {
		// TODO Auto-generated method stub
		
		Log log=new Log();
		log.setEmpno(1);
		log.setDates(new Date());
		log.setTablename("dept");
		log.setOperate("update");
		log.setBfupdate(deptDao.LoadDept(dept).toString());
		log.setUpdated(dept.toString());
		logdao.AddLog(log);
		deptDao.ModifyDept(dept);
	}

	@Override
	public void DeleteDept(Dept dept) {
		// TODO Auto-generated method stub
		
		Log log=new Log();
		log.setEmpno(1);
		log.setDates(new Date());
		log.setTablename("dept");
		log.setOperate("delete");
		log.setBfupdate(deptDao.LoadDept(dept).toString());
		log.setUpdated("");
		logdao.AddLog(log);
		deptDao.DeleteDept(dept);
	}

	@Override
	public void AddmultiDept(List<Dept> deptlist) {
		// TODO Auto-generated method stub
		for(int i=0;i<deptlist.size();i++)
		{
			AddDept(deptlist.get(i));
		}
	}
}
