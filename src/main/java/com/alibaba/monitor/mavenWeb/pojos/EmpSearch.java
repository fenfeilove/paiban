package com.alibaba.monitor.mavenWeb.pojos;
/**
 * @author yangjiadi
 */
public class EmpSearch {
	private String keyword;
	private int deptno;
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	@Override
	public String toString() {
		return "EmpSearch [keyword=" + keyword + ", deptno=" + deptno + "]";
	}
}
