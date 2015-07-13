package com.alibaba.monitor.mavenWeb.contral;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * @author zhuohaidi
 */
public class DateAction {
	//返回星期几
	public static int DayOfWeekWhithInt(String date)
	{
		SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		Date dates = new Date();
		try {
			dates = sdfInput.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		calendar.setTime(dates);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)-1;
		if(dayOfWeek<0)dayOfWeek=0;
		return dayOfWeek;
	}
	public static String DayOfWeekWhithStr(String date)
	{
		SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd");
		Date dates = new Date();
		try {
			dates = sdfInput.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		sdfInput.applyPattern("E");
		return sdfInput.format(dates).toString();
	}
	public static int DayOfWeekWhithInt(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)-1;
		if(dayOfWeek<0)dayOfWeek=0;
		return dayOfWeek;
	}
	public static String DayOfWeekWhithStr(Date date)
	{
		SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd");
		sdfInput.applyPattern("E");
		return sdfInput.format(date).toString();
	}
	
	public static Date getDateBefore(Date d, int day) {  
        Calendar now = Calendar.getInstance();  
        now.setTime(d);  
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);  
        return now.getTime();  
    }
    public static Date getDateAfter(Date d, int day) {  
        Calendar now = Calendar.getInstance();  
        now.setTime(d);  
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);  
        return now.getTime();  
    }
    
	public static Date getWeekDay()
	{
		Calendar calendar=Calendar.getInstance();//使用日历类
		int year = calendar.get(Calendar.YEAR);// 得到年
		int month = calendar.get(Calendar.MONTH) + 1;// 得到月，因为从0开始的，所以要加1
		int day = calendar.get(Calendar.DAY_OF_MONTH);// 得到天
		String dates=year+"-"+month+"-"+day;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try {
			date = sdf.parse(dates);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	int dayOfweek = calendar.get(Calendar.DAY_OF_WEEK);
    	dayOfweek-=1;
    	if(dayOfweek==0) dayOfweek=7;
    	return getDateBefore(date,dayOfweek-1);
	}
	public static int daysOfmonth(int year,int month)
	{
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
		{
			return 31;
		}
		else if(month==2)
		{
			if(year%4==0&&year%100!=0||year%400==0)
			{
				return 29;
			}
			else 
			{
				return 28;
			}
		}
		else{
			return 30;
		}
	}
	public static Date StringtoDate(String date) throws Exception
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dates = new Date();
		dates = sdf.parse(date);

		return dates;
	}
	public static int getMonth()
	{
		Calendar calendar=Calendar.getInstance();//使用日历类
		int month = calendar.get(Calendar.MONTH) + 1;// 得到月，因为从0开始的，所以要加1
		return month;
	}
	public static int getYear()
	{
		Calendar calendar=Calendar.getInstance();//使用日历类
		int year = calendar.get(Calendar.YEAR);// 得到年
		return year;
	}
//	public static void main(String[] args)
//	{
//		String s="2015-06-05";
//		Date date=new Date();
//		System.out.println(DayOfWeekWhithInt(s));
//		System.out.println(DayOfWeekWhithInt(date));
//		System.out.println(DayOfWeekWhithStr(s));
//		System.out.println(DayOfWeekWhithStr(date));
//	}
}
