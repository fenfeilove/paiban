package com.alibaba.monitor.mavenWeb.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.monitor.mavenWeb.pojos.M_Schedule;
/**
 * @author zhuohaidi
 */
@Repository
public interface IM_ScheduleService {
	public M_Schedule getMScheduleByEmpno(M_Schedule mschedule);
	public void AddMSchedule(M_Schedule mschedule);
	public void AddMulitMSchedule(List<M_Schedule> mschedulelist);
}
