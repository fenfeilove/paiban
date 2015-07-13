package com.alibaba.monitor.mavenWeb.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.monitor.mavenWeb.pojos.Dept;
import com.alibaba.monitor.mavenWeb.pojos.Emp;
import com.alibaba.monitor.mavenWeb.pojos.M_Schedule;
import com.alibaba.monitor.mavenWeb.pojos.Schedule;
import com.alibaba.monitor.mavenWeb.service.IArrayClassService;
import com.alibaba.monitor.mavenWeb.service.IDeptService;
import com.alibaba.monitor.mavenWeb.service.IEmpService;
import com.alibaba.monitor.mavenWeb.service.IM_ScheduleService;
import com.alibaba.monitor.mavenWeb.service.IScheduleService;
/**
 * @author zhuohaidi
 */
@RestController
@RequestMapping("/shiftcfg")
public class ShiftcfgController {

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

	@RequestMapping(method = RequestMethod.POST)
	public String Shiftcfg(@RequestBody SimpleBean sb) {
		Integer year = sb.year;
		Integer month = sb.month;
		Integer mode = sb.mode;
		// System.out.println("y:" + sb.year + " m: " + month + " mode:" +
		// mode);

		if (year == null)
			year = 2015;
		if (month == null)
			month = 6;
		if (mode == null)
			mode = 1;

		Calendar calendar = Calendar.getInstance();
		int Year = calendar.get(Calendar.YEAR);
		int Month = calendar.get(Calendar.MONTH) + 1;
		int day = 1;

		if (year < Year || (year == Year && month < Month))
			return "{\"ok\":\"时间已过去，不能进行排班\"}";
		if (year == Year && month == Month)
			day = calendar.get(Calendar.DAY_OF_MONTH);
//		System.out.println(year);
//		System.out.println(month);
//		System.out.println(day);
		List<Dept> deptlist = deptservice.getAllDept(null);
//		System.out.println("******deptlist*********");
//		for (int i = 0; i < deptlist.size(); i++) {
//			System.out.println(deptlist.get(i).toString());
//		}

		for (int i = 0; i < deptlist.size(); i++) {
			List<Emp> emps = empservice.getEmpByKey("", deptlist.get(i)
					.getDeptno());
//			System.out.println("******emps*********");
//			for (int l = 0; l < emps.size(); l++) {
//				System.out.println(emps.get(l).toString());
//			}
			List<Emp> emplist = new ArrayList<Emp>();
			List<M_Schedule> mschedulelist = new ArrayList<M_Schedule>();
			// System.out.println(emps.size());
			for (int j = 0; j < emps.size(); j++) {
				Emp emp = emps.get(j);
				if (emp.isArrayed() == false)
					continue;
				M_Schedule mschedule = new M_Schedule();
				mschedule.setYears(year);
				mschedule.setMonths(month);
				mschedule.setFlag(false);
				mschedule.setEmpno(emp.getEmpno());
				// System.out.println(mschedule.toStrings());
				M_Schedule ms = mscheduleservice.getMScheduleByEmpno(mschedule);
				if (ms != null)
					continue;
				emplist.add(emp);
				mschedulelist.add(mschedule);
			}
//			System.out.println("******emplist*********");
//			for (int l = 0; l < emplist.size(); l++) {
//				System.out.println(emplist.get(l).toString());
//			}
			List<Schedule> schedulelist = null;
			if(emplist.size()==0)
			{
				continue;
			}
			else if (emplist.size() < 6) {
//				System.out.println("jin"+year+" "+month+" "+day+"\n");
				schedulelist = arrayclassservice.ModeFour(emplist, year, month,day);
			} 
			else if (mode == 0) {
				schedulelist = arrayclassservice.ModeFour(emplist, year, month,day);
			}
			else if (mode == 1)
				schedulelist = arrayclassservice.ModeOne(emplist, year, month,
						day);
			else if (mode == 2)
				schedulelist = arrayclassservice.ModeTow(emplist, year, month,
						day);
			else if (mode == 3)
				schedulelist = arrayclassservice.ModeThree(emplist, year,
						month, day);
//			System.out.println("******schedulelist*********");
//			for (int l = 0; l < schedulelist.size(); l++) {
//				System.out.println(schedulelist.get(l).toString());
//			}
			scheduleservice.AddMulitSchedule(schedulelist);
			mscheduleservice.AddMulitMSchedule(mschedulelist);

		}
		return "{\"ok\":\"排班完成\"}";

	}

	private static class SimpleBean {
		public Integer year, month;
		public Integer mode;
	}
}