package com.alibaba.monitor.mavenWeb.service;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.alibaba.monitor.mavenWeb.pojos.Emp;
import com.alibaba.monitor.mavenWeb.pojos.Schedule;
/**
 * @author zhuohaidi
 */
@Repository
public interface IArrayClassService {
	public List<Schedule> ModeZero(List<Emp> emplist,int year,int month,int day);
	public List<Schedule> ModeOne(List<Emp> emplist,int year,int month,int day);
	public List<Schedule> ModeTow(List<Emp> emplist,int year,int month,int day);
	public List<Schedule> ModeThree(List<Emp> emplist,int year,int month,int day);
	public List<Schedule> ModeFour(List<Emp> emplist,int year,int month,int day);
}
