package com.alibaba.monitor.mavenWeb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.monitor.mavenWeb.pojos.Emp;
import com.alibaba.monitor.mavenWeb.pojos.Schedule;
import com.alibaba.monitor.mavenWeb.service.IArrayClassService;
import com.alibaba.monitor.mavenWeb.service.IClassService;
import com.alibaba.monitor.mavenWeb.service.IDeptService;
import com.alibaba.monitor.mavenWeb.service.IEmpService;
import com.alibaba.monitor.mavenWeb.service.ILogService;
import com.alibaba.monitor.mavenWeb.service.IM_ScheduleService;
import com.alibaba.monitor.mavenWeb.service.IScheduleService;
import com.alibaba.monitor.mavenWeb.service.IUserService;
/**
 * @author yangjiadi
 */
@Controller

public class Test2Controller{

	@Autowired
	ILogService logservice;
	@Autowired
	IEmpService empservice;
	@Autowired
	IDeptService deptservice;
	@Autowired
	IClassService classService;
	@Autowired
	IArrayClassService arrayclassservice;
	@Autowired
	IScheduleService scheduleservice;
	@Autowired
	IM_ScheduleService mscheduleservice;
	@Autowired 
	IUserService userservice;
	@RequestMapping("/test2")
	@ResponseBody
	public Object test (HttpServletRequest request,Model model){
		
		List<Emp> emplist=empservice.getEmpByKey("",2);
//		for(int i=0;i<emplist.size();i++)
//		{
//			System.out.println(emplist.get(i).toString());
//		}
//		System.out.println(emplist.size());
		//return emplist;
		List<Schedule> schedulelist=arrayclassservice.ModeThree(emplist, 2015, 7, 1);
		for(int i=0;i<schedulelist.size();i++)
		{
			System.out.println(schedulelist.get(i).toString());
		}
		return schedulelist;
//		List<User> userlist=new ArrayList<User>();
//		User user=new User();
//		user.setUsername("abc");
//		user.setPasswd("111");
//		User user2=new User();
//		user2.setUsername("abcd");
//		user2.setPasswd("111");
//		User user3=new User();
//		user3.setUsername("abce");
//		user3.setPasswd("111");
//		userlist.add(user);
//		userlist.add(user2);
//		userlist.add(user3);
//		userservice.AddMulitUser(userlist);
//		return userlist;
	}
}