package com.alibaba.monitor.mavenWeb.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.monitor.mavenWeb.contral.ArrayClassModeFourAction;
import com.alibaba.monitor.mavenWeb.contral.ArrayClassModeOneAction;
import com.alibaba.monitor.mavenWeb.contral.ArrayClassModeThreeAction;
import com.alibaba.monitor.mavenWeb.contral.ArrayClassModeTwoAction;
import com.alibaba.monitor.mavenWeb.pojos.Emp;
import com.alibaba.monitor.mavenWeb.pojos.Schedule;
import com.alibaba.monitor.mavenWeb.service.IArrayClassService;
/**
 * @author zhuohaidi
 */
@Service
public class ArrayClassServiceImpl implements IArrayClassService {

	@Override
	public List<Schedule> ModeZero(List<Emp> emplist,int year,int month,int day) {
		// TODO Auto-generated method stub
		
		return new ArrayClassModeOneAction().getArrayger(emplist,year,month,day);
	}
	
	@Override
	public List<Schedule> ModeOne(List<Emp> emplist,int year,int month,int day) {
		// TODO Auto-generated method stub
		
		return new ArrayClassModeOneAction().getArrayger(emplist,year,month,day);
	}

	@Override
	public List<Schedule> ModeTow(List<Emp> emplist,int year,int month,int day) {
		// TODO Auto-generated method stub
		return new ArrayClassModeTwoAction().getArrayger(emplist, year, month,day);
	}

	@Override
	public List<Schedule> ModeThree(List<Emp> emplist,int year,int month,int day) {
		// TODO Auto-generated method stub
		return new ArrayClassModeThreeAction().getArrayger(emplist, year, month,day);
	}

	@Override
	public List<Schedule> ModeFour(List<Emp> emplist, int year, int month,
			int day) {
		// TODO Auto-generated method stub
		return new ArrayClassModeFourAction().getArrayger(emplist, year, month, day);
	}
}
