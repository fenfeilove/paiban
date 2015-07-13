package com.alibaba.monitor.mavenWeb.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.monitor.mavenWeb.dao.IEmpDao;
import com.alibaba.monitor.mavenWeb.dao.ILogDao;
import com.alibaba.monitor.mavenWeb.pojos.Emp;
import com.alibaba.monitor.mavenWeb.pojos.EmpArrayed;
import com.alibaba.monitor.mavenWeb.pojos.EmpSearch;
import com.alibaba.monitor.mavenWeb.pojos.Log;
import com.alibaba.monitor.mavenWeb.service.IEmpService;
/**
 * @author zhuohaidi
 */
@Service
public class EmpServiceImpl implements IEmpService
{
	@Autowired
	IEmpDao empDao;
	@Autowired
	ILogDao logdao;
	@Override
	public Emp getEmp(Emp emp)
	{
		return empDao.LoadEmp(emp);
	}
	@Override
	public Emp getEmpByEmail(Emp emp)
	{
		return empDao.LoadEmpByEmail(emp);
	}
	@Override
	public List<Emp> getAllEmp(Emp emp) {
		// TODO Auto-generated method stub
		return empDao.LoadAllEmp(emp);
	}
	@Override
	public List<Emp> getEmpByKey(String keyword,int deptno) {
		// TODO Auto-generated method stub
		if(deptno!=0)
		{
			EmpSearch empsearch=new EmpSearch();
			empsearch.setKeyword(keyword);
			empsearch.setDeptno(deptno);
			return empDao.loadEmpByEmpsearch(empsearch);
		}
		else
			return empDao.LoadEmpByKey(keyword);
	}
	@Override
	public void AddEmp(Emp emp) {
		// TODO Auto-generated method stub
		
		Log log=new Log();
		log.setEmpno(1);
		log.setDates(new Date());
		log.setTablename("emp");
		log.setOperate("add");
		log.setBfupdate("");
		log.setUpdated(emp.toString());
		logdao.AddLog(log);
		empDao.AddEmp(emp);
	}
	@Override
	public void ModifyEmp(Emp emp) {
		// TODO Auto-generated method stub

		Log log=new Log();
		log.setEmpno(1);
		log.setDates(new Date());
		log.setTablename("emp");
		log.setOperate("update");
		log.setBfupdate(empDao.LoadEmp(emp).toString());
		log.setUpdated(emp.toString());
		logdao.AddLog(log);
		empDao.ModifyEmp(emp);
	}
	@Override
	public void DeleteEmp(Emp emp) {
		// TODO Auto-generated method stub
		
		Log log=new Log();
		log.setEmpno(1);
		log.setDates(new Date());
		log.setTablename("emp");
		log.setOperate("delete");
		log.setBfupdate(empDao.LoadEmp(emp).toString());
		log.setUpdated("");
		logdao.AddLog(log);
		empDao.DeleteEmp(emp);
	}
	@Override
	public void AddMulitEmp(List<Emp> emplist) {
		// TODO Auto-generated method stub
		empDao.AddMulitEmp(emplist);
	}
	@Override
	public void ModifyMulitEmp(EmpArrayed emparrayed) {
		// TODO Auto-generated method stub
		if(emparrayed.getDeptno()==0)
			empDao.ModifyMulitEmp2(emparrayed);
		else
			empDao.ModifyMulitEmp(emparrayed);
	}

	
	
}
