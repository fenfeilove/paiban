package com.alibaba.monitor.mavenWeb.pojos;

import java.util.Date;
/**
 * @author yangjiadi
 */
public class Schedule {
	private int schno;
	private int empno;
	private int classid;
	private Date Dates;
	
	public int getSchno() {
		return schno;
	}
	public void setSchno(int schno) {
		this.schno = schno;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public Date getDates() {
		return Dates;
	}
	public void setDates(Date dates) {
		Dates = dates;
	}
	@Override
	public String toString() {
		return "Schedule [schno=" + schno + ", empno=" + empno + ", classid="
				+ classid + ", Dates=" + Dates + "]";
	}
	
}
