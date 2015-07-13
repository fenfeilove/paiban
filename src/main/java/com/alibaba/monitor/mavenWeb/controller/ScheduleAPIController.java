package com.alibaba.monitor.mavenWeb.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.monitor.mavenWeb.contral.DateAction;
import com.alibaba.monitor.mavenWeb.pojos.Emp;
import com.alibaba.monitor.mavenWeb.pojos.Schedule;
import com.alibaba.monitor.mavenWeb.service.IEmpService;
import com.alibaba.monitor.mavenWeb.service.IScheduleService;
/**
 * @author zhuohaidi
 */
@Controller
public class ScheduleAPIController{
	
	@Autowired
	IScheduleService scheduleService;
	@Autowired
	IEmpService empService;
	@RequestMapping(value = "/api",method = RequestMethod.GET)
	@ResponseBody
	public List<Emp> test (String date){
		Date dates;
		List<Emp> emplist=new ArrayList<Emp>();
		try {
			dates = DateAction.StringtoDate(date);
		} catch (Exception e) {
			return emplist;
		}
		
		if(dates==null) return emplist;
		List<Schedule> schedulelist=scheduleService.getScheduleByDate(dates);
		for(int i=0;i<schedulelist.size();i++)
		{
			Schedule schedule=schedulelist.get(i);
			if(schedule.getClassid()==0||schedule.getClassid()==4) continue;
			Emp emp=new Emp();
			emp.setEmpno(schedulelist.get(i).getEmpno());
			emp=empService.getEmp(emp);
			emplist.add(emp);
		}
		return emplist;
	}
}