package com.alibaba.monitor.mavenWeb.pojos;

import java.util.Date;
/**
 * @author yangjiadi
 */
public class ScheduleSearch {
	private int empno;
	private Date leftdate;
	private Date rightdate;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public Date getLeftdate() {
		return leftdate;
	}
	public void setLeftdate(Date leftdate) {
		this.leftdate = leftdate;
	}
	public Date getRightdate() {
		return rightdate;
	}
	public void setRightdate(Date rightdate) {
		this.rightdate = rightdate;
	}
	@Override
	public String toString() {
		return "ScheduleSearch [empno=" + empno + ", leftdate=" + leftdate
				+ ", rightdate=" + rightdate + "]";
	}
	
}
