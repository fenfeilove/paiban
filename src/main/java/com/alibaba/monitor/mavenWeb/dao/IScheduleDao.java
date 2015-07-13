package com.alibaba.monitor.mavenWeb.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.monitor.mavenWeb.pojos.Schedule;
import com.alibaba.monitor.mavenWeb.pojos.ScheduleSearch;
/**
 * @author zhuohaidi
 */
@Repository
public interface IScheduleDao{
	public Schedule LoadSchedule(Schedule schedule);
	public List<Schedule> LoadAllSchedule(Schedule schedule);
	public List<Schedule> LoadScheduleByEmpno(int empno);
	public Schedule LoadScheduleByEmpTime(Schedule schedule);
	public List<Schedule> LoadScheduleBySsearch(ScheduleSearch sdsh);
	public List<Schedule> LoadScheduleByDate(Date date);
	public void AddSchedule(Schedule schedule);
	public void AddMulitSchedule(List<Schedule> schedulelist);
	public void ModifySchedule(Schedule schedule);
	public void ModifyScheduleByEmpno(Schedule schedule);
	public void DeleteSchedule(Schedule schedule);
}
