package com.alibaba.monitor.mavenWeb.dao;

import org.springframework.stereotype.Repository;

import com.alibaba.monitor.mavenWeb.pojos.M_Schedule;
/**
 * @author zhuohaidi
 */
@Repository
public interface IM_ScheduleDao {
	public M_Schedule LoadMScheduleByEmpno(M_Schedule mschedule);
	public void AddMSchedule(M_Schedule mschedule);
}
