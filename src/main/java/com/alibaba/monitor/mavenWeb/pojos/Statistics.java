package com.alibaba.monitor.mavenWeb.pojos;
/**
 * @author yangjiadi
 */
public class Statistics {
	private int stano;
	private int empno;
	private String ename;
	private int deptno;
	private int years;
	private int months;
	private int totalhours;
	private int dayshift;
	private int nightshift;
	private int normalshift;
	private int holidayshift;
	public int getStano() {
		return stano;
	}
	public void setStano(int stano) {
		this.stano = stano;
	}
	
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public int getMonths() {
		return months;
	}
	public void setMonths(int months) {
		this.months = months;
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
	public int getTotalhours() {
		return totalhours;
	}
	public void setTotalhours(int totalhours) {
		this.totalhours = totalhours;
	}
	public int getDayshift() {
		return dayshift;
	}
	public void setDayshift(int dayshift) {
		this.dayshift = dayshift;
	}
	public int getNightshift() {
		return nightshift;
	}
	public void setNightshift(int nightshift) {
		this.nightshift = nightshift;
	}
	public int getNormalshift() {
		return normalshift;
	}
	public void setNormalshift(int normalshift) {
		this.normalshift = normalshift;
	}
	public int getHolidayshift() {
		return holidayshift;
	}
	public void setHolidayshift(int holidayshift) {
		this.holidayshift = holidayshift;
	}
	public void cntTotalhours()
	{
		this.totalhours = this.dayshift * 10 + this.nightshift * 10
				+ this.normalshift * 8;
	}
	@Override
	public String toString() {
		return "Statistics [stano=" + stano + ", empno=" + empno + ", ename="
				+ ename + ", deptno=" + deptno + ", years=" + years
				+ ", months=" + months + ", totalhours=" + totalhours
				+ ", dayshift=" + dayshift + ", nightshift=" + nightshift
				+ ", normalshift=" + normalshift + ", holidayshift="
				+ holidayshift + "]";
	}
	
	
}
