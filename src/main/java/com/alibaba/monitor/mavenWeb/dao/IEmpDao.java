package com.alibaba.monitor.mavenWeb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.monitor.mavenWeb.pojos.Emp;
import com.alibaba.monitor.mavenWeb.pojos.EmpArrayed;
import com.alibaba.monitor.mavenWeb.pojos.EmpSearch;
/**
 * @author zhuohaidi
 */
@Repository
public interface IEmpDao{
	public Emp LoadEmp(Emp emp);
	public Emp LoadEmpByEmail(Emp emp);
	public List<Emp> LoadAllEmp(Emp emp);
	public List<Emp> LoadEmpByKey(String keyword);
	public List<Emp> loadEmpByEmpsearch(EmpSearch empsearch);
	public void AddEmp(Emp emp);
	public void AddMulitEmp(List<Emp> emplist);
	public void ModifyEmp(Emp emp);
	public void ModifyMulitEmp(EmpArrayed emparrayed);
	public void ModifyMulitEmp2(EmpArrayed emparrayed);
	public void DeleteEmp(Emp emp);
}