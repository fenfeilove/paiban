package com.alibaba.monitor.mavenWeb.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.monitor.mavenWeb.contral.DateAction;
import com.alibaba.monitor.mavenWeb.pojos.Emp;
import com.alibaba.monitor.mavenWeb.pojos.EmpClazz;
import com.alibaba.monitor.mavenWeb.pojos.Schedule;
import com.alibaba.monitor.mavenWeb.pojos.ScheduleSearch;
import com.alibaba.monitor.mavenWeb.service.IEmpService;
import com.alibaba.monitor.mavenWeb.service.IScheduleService;
/**
 * @author zhuohaidi
 */
@RestController
@RequestMapping("/chaxun2")
public class chaxunSchedule {
	@Autowired
	IEmpService empService;
	@Autowired
	IScheduleService scheduleService;

	@RequestMapping(method = RequestMethod.GET)
	public Object chaxun (Integer weekno,Integer deptno , String keyword){
		
		List<Schedule> schedulelist=null;
		List<Emp> emplist=null;
		if(weekno==null) weekno=0;
		if(deptno==null) deptno=0;
		if(keyword==null) keyword="";
		emplist=empService.getEmpByKey(keyword, deptno);
		Date Momdy=DateAction.getWeekDay();
		ScheduleSearch sdsh=new ScheduleSearch();
		sdsh.setLeftdate(DateAction.getDateAfter(Momdy, weekno*7));
		sdsh.setRightdate(DateAction.getDateAfter(Momdy, weekno*7+6));
//		System.out.println(Momdy);
//		System.out.println(sdsh.getLeftdate());
//		System.out.println(sdsh.getRightdate());
//		Map<String,int[]> map=new HashMap<String,int[]>(); 
		//Map<Emp,int[]> map=new HashMap<Emp,int[]>(); 
		
	    long left = sdsh.getLeftdate().getTime();
	   
		List<EmpClazz> empcla = new ArrayList<EmpClazz>();
		for(int i=0;i<emplist.size();i++)
		{
			sdsh.setEmpno(emplist.get(i).getEmpno());
			schedulelist=scheduleService.getScheduleBySsearch(sdsh);
			int a[]=new int[7];
			for(int j=0;j<schedulelist.size();j++)
			{
				Schedule schedule=schedulelist.get(j);
				long right = schedule.getDates().getTime();
				a[(int) ((right-left)/(1000 * 60 * 60 * 24))]=schedule.getClassid();
			}
//			map.put(emplist.get(i).getEname(),a);
//			map.put(emplist.get(i),a);
			EmpClazz ec=new EmpClazz();
			ec.setEmp(emplist.get(i));
			ec.setA(a);
			empcla.add(ec);
		}
//		for (String key : map.keySet()) {
//			//System.out.print(key+":");
//			int a[]=map.get(key);
//			for(int i=0;i<7;i++)
//			{
//				System.out.print(a[i]+" ");
//			}
//			System.out.print("\n");
//		}
		return empcla;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@RequestBody SimpleBean sb) {
		Integer empno = sb.empno;
		Integer classid = sb.classid;
		Date date = sb.date;
//		System.out.println(empno);
//		System.out.println(classid);
//		System.out.println(date);

		if (empno == null || classid == null || date == null)
			return "{\"ok\":false}";
		@SuppressWarnings("deprecation")
		int year = date.getYear() + 1900;
		@SuppressWarnings("deprecation")
		int month = date.getMonth() + 1;
		@SuppressWarnings("deprecation")
		int day = date.getDate();
		try {
			date = DateAction.StringtoDate(year + "-" + month + "-" + day);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
//		System.out.println(date);
		Schedule schedule = new Schedule();
		schedule.setEmpno(empno);
		schedule.setDates(date);
		schedule.setClassid(classid);
		if(scheduleService.getScheduleByEmpTime(schedule)==null)
		{
			scheduleService.AddSchedule(schedule);
		}
		else
			scheduleService.ModifyScheduleByEmpno(schedule);
		return "{\"ok\":true}";
	}

	private static class SimpleBean {
		public Date date;
		public Integer classid;
		public Integer empno;
	}
}