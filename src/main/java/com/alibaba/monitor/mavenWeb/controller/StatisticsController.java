package com.alibaba.monitor.mavenWeb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.monitor.mavenWeb.contral.DateAction;
import com.alibaba.monitor.mavenWeb.pojos.Emp;
import com.alibaba.monitor.mavenWeb.pojos.Schedule;
import com.alibaba.monitor.mavenWeb.pojos.ScheduleSearch;
import com.alibaba.monitor.mavenWeb.pojos.Statistics;
import com.alibaba.monitor.mavenWeb.service.IArrayClassService;
import com.alibaba.monitor.mavenWeb.service.IDeptService;
import com.alibaba.monitor.mavenWeb.service.IEmpService;
import com.alibaba.monitor.mavenWeb.service.IM_ScheduleService;
import com.alibaba.monitor.mavenWeb.service.IScheduleService;
import com.alibaba.monitor.mavenWeb.service.IStatisticsService;
/**
 * @author zhuohaidi
 */
@RestController
@RequestMapping("/statistics")
public class StatisticsController {

	@Autowired
	IEmpService empservice;
	@Autowired
	IScheduleService scheduleservice;
	@Autowired
	IM_ScheduleService mscheduleservice;
	@Autowired
	IDeptService deptservice;
	@Autowired
	IArrayClassService arrayclassservice;
	@Autowired
	IStatisticsService statisticsservice;
	@RequestMapping(method = RequestMethod.GET)
	public List<Statistics> Shiftcfg(Integer m) {
		if(m==null)
			m=0;
		int Year = DateAction.getYear();
		int Month = DateAction.getMonth();
		int month=Month+m;
		int year=Year+(month/12);
		month=month%12;
		if(month<=0){
			month+=12;
			year-=1;
		}
		int daysOfmonth=DateAction.daysOfmonth(year, month);
		//System.out.println(Year + " " + Month);
		
		List<Emp> emplist=empservice.getAllEmp(null);
		List<Statistics> statisticslist=new ArrayList<Statistics>();
		if (year < Year || (year == Year && month < Month))
		{
			ScheduleSearch sdsh=new ScheduleSearch();
			try {
				sdsh.setLeftdate(DateAction.StringtoDate(year+"-"+month+"-01"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
			try {
				sdsh.setRightdate(DateAction.StringtoDate(year+"-"+month+"-"+daysOfmonth));
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
			Statistics statistics=new Statistics();
			statistics.setYears(year);
			statistics.setMonths(month);
			for(int i=0;i<emplist.size();i++)
			{
				Emp emp=emplist.get(i);
				statistics.setEmpno(emp.getEmpno());
				statistics.setEname(emp.getEname());
				statistics.setDeptno(emp.getDeptno());
				Statistics std=statisticsservice.getStatisticsByEmpnoTime(statistics);
				if(std!=null)
				{
					std.setEname(emp.getEname());
					std.setDeptno(emp.getDeptno());
					statisticslist.add(std);
					continue;
				}
				sdsh.setEmpno(emp.getEmpno());
				List<Schedule> schedulelist=scheduleservice.getScheduleBySsearch(sdsh);
				for(int j=0;j<schedulelist.size();j++)
				{
					Schedule schudule=schedulelist.get(j);
					if(schudule.getClassid()==1) statistics.setDayshift(statistics.getDayshift()+1);
					else if(schudule.getClassid()==2) statistics.setNightshift(statistics.getNightshift()+1);
					else if(schudule.getClassid()==3) statistics.setNormalshift(statistics.getNormalshift()+1);
					else if(schudule.getClassid()==4) statistics.setHolidayshift(statistics.getHolidayshift()+1);
				}
				statistics.cntTotalhours();
				statisticslist.add(statistics);
				statisticsservice.AddStatistics(statistics);
			}
		}
		else
		{
			ScheduleSearch sdsh=new ScheduleSearch();
			try {
				sdsh.setLeftdate(DateAction.StringtoDate(year+"-"+month+"-01"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
			try {
				sdsh.setRightdate(DateAction.StringtoDate(year+"-"+month+"-"+daysOfmonth));
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
			for(int i=0;i<emplist.size();i++)
			{
				Emp emp=emplist.get(i);
				sdsh.setEmpno(emp.getEmpno());
				List<Schedule> schedulelist=scheduleservice.getScheduleBySsearch(sdsh);
				Statistics statistics=new Statistics();
				statistics.setEmpno(emp.getEmpno());
				statistics.setEname(emp.getEname());
				statistics.setDeptno(emp.getDeptno());
				
				statistics.setYears(year);
				statistics.setMonths(month);
				for(int j=0;j<schedulelist.size();j++)
				{
					Schedule schudule=schedulelist.get(j);
					if(schudule.getClassid()==1) statistics.setDayshift(statistics.getDayshift()+1);
					else if(schudule.getClassid()==2) statistics.setNightshift(statistics.getNightshift()+1);
					else if(schudule.getClassid()==3) statistics.setNormalshift(statistics.getNormalshift()+1);
					else if(schudule.getClassid()==4) statistics.setHolidayshift(statistics.getHolidayshift()+1);
				}
				statistics.cntTotalhours();
				statisticslist.add(statistics);
			}
		}
		return statisticslist;
	}

}