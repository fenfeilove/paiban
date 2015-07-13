package com.alibaba.monitor.mavenWeb.pojos;
/**
 * @author yangjiadi
 */
public class M_Schedule {
	private int id;
	private int empno;
	private int years;
	private int months;
	private boolean flag;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public int getYears() {
		return years;
	}
	public void setYears(int years) {
		this.years = years;
	}
	public int getMonths() {
		return months;
	}
	public void setMonths(int months) {
		this.months = months;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "M_Schedule [id=" + id + ", empno=" + empno + ", years=" + years
				+ ", months=" + months + ", flag=" + flag + "]";
	}
	
}
