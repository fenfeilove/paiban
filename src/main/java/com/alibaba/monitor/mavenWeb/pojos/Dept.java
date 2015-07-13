package com.alibaba.monitor.mavenWeb.pojos;
/**
 * @author yangjiadi
 */
public class Dept {
	private int deptno;
	private String dname;
	private String describes="";
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDescribes() {
		return describes;
	}
	public void setDescribes(String describes) {
		this.describes = describes;
	}
	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", describes="
				+ describes + "]";
	}
	
}
