package com.alibaba.monitor.mavenWeb.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.monitor.mavenWeb.pojos.Emp;
import com.alibaba.monitor.mavenWeb.pojos.EmpArrayed;
/**
 * @author zhuohaidi
 */
@Repository
public interface IEmpService {
	public Emp getEmp(Emp emp);
	public Emp getEmpByEmail(Emp emp);
	public List<Emp> getAllEmp(Emp emp);
	public List<Emp> getEmpByKey(String keyword,int deptno);
	public void AddEmp(Emp emp);
	public void AddMulitEmp(List<Emp> emplist);
	public void ModifyEmp(Emp emp);
	public void ModifyMulitEmp(EmpArrayed emparrayed);
	public void DeleteEmp(Emp emp);
}
