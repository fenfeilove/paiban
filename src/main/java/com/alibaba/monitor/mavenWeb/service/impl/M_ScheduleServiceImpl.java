package com.alibaba.monitor.mavenWeb.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.monitor.mavenWeb.dao.ILogDao;
import com.alibaba.monitor.mavenWeb.dao.IM_ScheduleDao;
import com.alibaba.monitor.mavenWeb.pojos.Log;
import com.alibaba.monitor.mavenWeb.pojos.M_Schedule;
import com.alibaba.monitor.mavenWeb.service.IM_ScheduleService;
@Service
public class M_ScheduleServiceImpl implements IM_ScheduleService{

	@Autowired
	IM_ScheduleDao mscheduledao;
	@Autowired
	ILogDao logdao;
	@Override
	public M_Schedule getMScheduleByEmpno(M_Schedule mschedule) {
		// TODO Auto-generated method stub
		return mscheduledao.LoadMScheduleByEmpno(mschedule);
	}

	@Override
	public void AddMSchedule(M_Schedule mschedule) {
		// TODO Auto-generated method stub
		Log log=new Log();
		log.setEmpno(1);
		log.setDates(new Date());
		log.setTablename("m_schedule");
		log.setOperate("add");
		log.setBfupdate("");
		log.setUpdated(mschedule.toString());
		logdao.AddLog(log);
		mscheduledao.AddMSchedule(mschedule);
	}

	@Override
	public void AddMulitMSchedule(List<M_Schedule> mschedulelist) {
		// TODO Auto-generated method stub
		for(int i=0;i<mschedulelist.size();i++)
		{
			AddMSchedule(mschedulelist.get(i));
		}
	}

}
