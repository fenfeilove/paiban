package com.alibaba.monitor.mavenWeb.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.monitor.mavenWeb.dao.ILogDao;
import com.alibaba.monitor.mavenWeb.dao.IScheduleDao;
import com.alibaba.monitor.mavenWeb.pojos.Log;
import com.alibaba.monitor.mavenWeb.pojos.Schedule;
import com.alibaba.monitor.mavenWeb.pojos.ScheduleSearch;
import com.alibaba.monitor.mavenWeb.service.IScheduleService;
@Service
public class ScheduleServiceImpl implements IScheduleService{
	@Autowired
	IScheduleDao scheduleDao;
	@Autowired
	ILogDao logdao;
	@Override
	public Schedule getSchedule(Schedule schedule) {
		// TODO Auto-generated method stub
		return scheduleDao.LoadSchedule(schedule);
	}

	@Override
	public List<Schedule> getAllSchedule(Schedule schedule) {
		// TODO Auto-generated method stub
		return scheduleDao.LoadAllSchedule(schedule);
	}
	
	@Override
	public List<Schedule> getScheduleByEmpno(int empno) {
		// TODO Auto-generated method stub
		return scheduleDao.LoadScheduleByEmpno(empno);
	}
	
	@Override
	public List<Schedule> getScheduleBySsearch(ScheduleSearch sdsh) {
		// TODO Auto-generated method stub
		return scheduleDao.LoadScheduleBySsearch(sdsh);
	}
	
	@Override
	public void AddSchedule(Schedule schedule) {
		// TODO Auto-generated method stub
		
		Log log=new Log();
		log.setEmpno(1);
		log.setDates(new Date());
		log.setTablename("schedule");
		log.setOperate("add");
		log.setBfupdate("");
		log.setUpdated(schedule.toString());
		logdao.AddLog(log);
		scheduleDao.AddSchedule(schedule);
	}

	@Override
	public void ModifySchedule(Schedule schedule) {
		// TODO Auto-generated method stub
		
		Log log=new Log();
		log.setEmpno(1);
		log.setDates(new Date());
		log.setTablename("schedule");
		log.setOperate("update");
		log.setBfupdate(scheduleDao.LoadSchedule(schedule).toString());
		log.setUpdated(schedule.toString());
		logdao.AddLog(log);
		scheduleDao.ModifySchedule(schedule);
	}

	@Override
	public void DeleteSchedule(Schedule schedule) {
		// TODO Auto-generated method stub
		
		Log log=new Log();
		log.setEmpno(1);
		log.setDates(new Date());
		log.setTablename("schedule");
		log.setOperate("delete");
		log.setBfupdate(scheduleDao.LoadSchedule(schedule).toString());
		log.setUpdated("");
		logdao.AddLog(log);
		scheduleDao.DeleteSchedule(schedule);
	}

	@Override
	public void AddMulitSchedule(List<Schedule> schedulelist) {
		// TODO Auto-generated method stub
		scheduleDao.AddMulitSchedule(schedulelist);
	}

	@Override
	public void ModifyScheduleByEmpno(Schedule schedule) {
		// TODO Auto-generated method stub
		scheduleDao.ModifyScheduleByEmpno(schedule);
	}

	@Override
	public List<Schedule> getScheduleByDate(Date date) {
		// TODO Auto-generated method stub
		return scheduleDao.LoadScheduleByDate(date);
	}

	@Override
	public Schedule getScheduleByEmpTime(Schedule schedule) {
		// TODO Auto-generated method stub
		return scheduleDao.LoadScheduleByEmpTime(schedule);
	}



}
