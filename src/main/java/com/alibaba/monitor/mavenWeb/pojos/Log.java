package com.alibaba.monitor.mavenWeb.pojos;

import java.util.Date;
/**
 * @author yangjiadi
 */
public class Log {
	private int logid;
	private int empno;
	private Date dates;
	private String tablename;
	private String operate;
	private String bfupdate;
	private String updated;
	public int getLogid() {
		return logid;
	}
	public void setLogid(int logid) {
		this.logid = logid;
	}
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public Date getDates() {
		return dates;
	}
	public void setDates(Date dates) {
		this.dates = dates;
	}
	public String getTablename() {
		return tablename;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	public String getOperate() {
		return operate;
	}
	public void setOperate(String operate) {
		this.operate = operate;
	}
	public String getBfupdate() {
		return bfupdate;
	}
	public void setBfupdate(String bfupdate) {
		this.bfupdate = bfupdate;
	}
	public String getUpdated() {
		return updated;
	}
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	@Override
	public String toString() {
		return "Log [logid=" + logid + ", empno=" + empno + ", dates=" + dates
				+ ", tablename=" + tablename + ", operate=" + operate
				+ ", bfupdate=" + bfupdate + ", updated=" + updated + "]";
	}
	
}
