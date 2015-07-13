package com.alibaba.monitor.mavenWeb.contral;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.monitor.mavenWeb.pojos.Emp;
import com.alibaba.monitor.mavenWeb.pojos.Schedule;
/**
 * @author zhuohaidi
 */
public class ArrayClassModeOneAction {
	int n;
	int a[][]=new int[200][40];
	int daysOfmonth;
	private int random(int k)
	{
		int num=0;
		while(true)
		{
			
			num=(int)(Math.random()*n);
			//System.out.println(num);
			if(a[num][k-1]-a[num][k-7]<5&&a[num][k]==0)
			{
				a[num][k]=1;
				return num;
			}
		}
	}
	private void arrayger()
	{
		int k=n/2+1;
		//int kk=(int) Math.floor(n*22.0/30);
		for(int i=8;i<8+daysOfmonth;i++)
		{
			int t=0;
			while(t<k)
			{
				//int num=
				random(i);
				//System.out.print(num +" ");
				t++;
			}
			for(int j=0;j<n;j++)
			{
				if(i>11&&a[j][i-1]-a[j][i-5]<=2&&a[j][i]==0)
				{
					a[j][i]=1;
				}
				else if(i>12&&a[j][i-1]-a[j][i-6]<=3&&a[j][i]==0)
				{
					a[j][i]=1;
				}
				else if(i>13&&a[j][i-1]-a[j][i-7]<=4&&a[j][i]==0)
				{
					a[j][i]=1;
				}
				a[j][i]+=a[j][i-1];
			}
			//System.out.print("\n");
		}
	}
	public List<Schedule> getArrayger(List<Emp> emplist,int year,int month,int day)
	{
		this.n=emplist.size();
		this.daysOfmonth=DateAction.daysOfmonth(year, month);
		//System.out.println(this.n);
		arrayger();
		DateFormat dd=new SimpleDateFormat("yyyy-MM-dd");
		List<Schedule> schlist=new ArrayList<Schedule>();
		for(int i=0;i<n;i++)
		{
			//System.out.print(i+": ");
			for(int j=7+day;j<8+daysOfmonth;j++)
			{
				//System.out.print(a[i][j]+" ");
				if(a[i][j]-a[i][j-1]==1)
				{
					Schedule sch=new Schedule();
					sch.setEmpno(emplist.get(i).getEmpno());
					sch.setClassid(3);
					try {
						sch.setDates(dd.parse(year+"-"+month+"-"+(j-7)));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					schlist.add(sch);
				}
				else
				{
					Schedule sch=new Schedule();
					sch.setEmpno(emplist.get(i).getEmpno());
					sch.setClassid(4);
					try {
						sch.setDates(dd.parse(year+"-"+month+"-"+(j-7)));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					schlist.add(sch);
				}
			}
			//System.out.print("\n");
		}
		return schlist;
	}
	public static void main(String[] args)
	{
		//new ArrayClassAction().getArrayger(6);
		
	}
}

//package com.alibaba.monitor.mavenWeb.contral;
//
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//
//import com.alibaba.monitor.mavenWeb.pojos.Emp;
//import com.alibaba.monitor.mavenWeb.pojos.Schedule;
//@Service
//public class ArrayClassAction {
//	int a[][]=new int[100][40];
//	int n;
//	private int random(int k)
//	{
//		int num=0;
//		while(true)
//		{
//			num=(int)Math.random()*n;
//			if(a[num][k]-a[num][k-7]<5&&a[num][k]==0)
//			{
//				a[num][k]=1;
//				return num;
//			}
//		}
//	}
//	private void arrayger()
//	{
//		int k=n/2+1;
//		int kk=(int) Math.floor(n*22.0/30);
//		for(int i=8;i<38;i++)
//		{
//			int t=0;
//			while(t<k)
//			{
//				int num=random(i);
//				t++;
//			}
//			for(int j=0;j<n;j++)
//			{
//				if(i>11&&a[j][i-1]-a[j][i-5]<=2&&a[j][i]==0)
//				{
//					a[j][i]=1;
//				}
//				else if(i>12&&a[j][i-1]-a[j][i-6]<=3&&a[j][i]==0)
//				{
//					a[j][i]=1;
//				}
//				else if(i>13&&a[j][i-1]-a[j][i-7]<=4&&a[j][i]==0)
//				{
//					a[j][i]=1;
//				}
//				a[j][i]+=a[j][i-1];
//			}
//		}
//	}
//	public List<Schedule> getArrayger(List<Emp> emplist) throws ParseException
//	{
//		List<Schedule> schlist=new ArrayList<Schedule>();
//		DateFormat dd=new SimpleDateFormat("yyyy-MM-dd");
//		this.n=emplist.size();
//		arrayger();
//		for(int i=0;i<n;i++)
//		{
//			System.out.print(i+": ");
//			for(int j=8;j<38;j++)
//			{
//				System.out.print(a[i][j]+" ");
//				if(a[i][j]-a[i][j-1]==1)
//				{
//					Schedule sch=new Schedule();
//					sch.setEmpno(emplist.get(i).getEmpno());
//					sch.setClassid(3);
//					sch.setDates(dd.parse("2015-6-"+(j-7)));
//					schlist.add(sch);
//				}
//			}
//			System.out.print("\n");
//		}
//		return schlist;
//	}
//}
