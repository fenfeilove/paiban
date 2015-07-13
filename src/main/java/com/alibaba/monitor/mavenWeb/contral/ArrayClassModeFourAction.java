package com.alibaba.monitor.mavenWeb.contral;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.monitor.mavenWeb.pojos.Emp;
import com.alibaba.monitor.mavenWeb.pojos.Schedule;
/**
 * @author zhuohaidi
 */
public class ArrayClassModeFourAction {
	private int n;
	private int daysOfmonth;
	private int shift[];
	private int year=2015;
	private int month=6;
	public List<Schedule> getArrayger(List<Emp> emplist, int year, int month,int day){
		this.n = emplist.size();
		this.year=year;
		this.month=month;
		this.daysOfmonth = DateAction.daysOfmonth(year, month);
		method();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Schedule> schlist = new ArrayList<Schedule>();
		for (int i = 0; i < n; i++) {
			for (int j = day; j <= daysOfmonth; j++){
				Schedule sch = new Schedule();
				sch.setEmpno(emplist.get(i).getEmpno());
				sch.setClassid(shift[j]);
				try {
					sch.setDates(sdf.parse(year + "-" + month + "-" + j));
				} catch (ParseException e) {}
				//System.out.println(sch.toString());
				schlist.add(sch);
			}
		}
		return schlist;
	}
	private void method()
	{
		shift=new int[daysOfmonth+1];
		for(int i=1;i<=daysOfmonth;i++)
		{
			int day=DateAction.DayOfWeekWhithInt(year+"-"+month+"-"+i);
			if(day==6||day==0) shift[i]=4;
			else shift[i]=3;
		}
	}
}
