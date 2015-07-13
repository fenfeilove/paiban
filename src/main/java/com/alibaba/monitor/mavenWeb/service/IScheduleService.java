package com.alibaba.monitor.mavenWeb.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.monitor.mavenWeb.pojos.Schedule;
import com.alibaba.monitor.mavenWeb.pojos.ScheduleSearch;
/**
 * @author zhuohaidi
 */
@Repository
public interface IScheduleService {
	public Schedule getSchedule(Schedule schedule);
	public Schedule getScheduleByEmpTime(Schedule schedule);
	public List<Schedule> getAllSchedule(Schedule schedule);
	public List<Schedule> getScheduleByEmpno(int empno);
	public List<Schedule> getScheduleBySsearch(ScheduleSearch sdsh);
	public List<Schedule> getScheduleByDate(Date date);
	public void AddSchedule(Schedule schedule);
	public void AddMulitSchedule(List<Schedule> schedulelist);
	public void ModifyScheduleByEmpno(Schedule schedule);
	public void ModifySchedule(Schedule schedule);
	public void DeleteSchedule(Schedule schedule);
}
