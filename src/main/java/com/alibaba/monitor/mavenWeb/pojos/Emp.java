package com.alibaba.monitor.mavenWeb.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * @author yangjiadi
 */
public class Emp {
	private int empno;
	private String ename;
	private int deptno;
	private String ephone;
	private String eemail;
	private String eaddress;
	@JsonIgnore
	private String passWord;
	private boolean arrayed=true;
	private boolean deleted;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
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
	public String getEphone() {
		return ephone;
	}
	public void setEphone(String ephone) {
		this.ephone = ephone;
	}
	public String getEemail() {
		return eemail;
	}
	public void setEemail(String eemail) {
		this.eemail = eemail;
	}
	public String getEaddress() {
		return eaddress;
	}
	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}
	
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	public boolean isDeleted() {
		return deleted;
	}
	
	public boolean isArrayed() {
		return arrayed;
	}
	public void setArrayed(boolean arrayed) {
		this.arrayed = arrayed;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", deptno="
				+ deptno + ", ephone=" + ephone + ", eemail=" + eemail
				+ ", eaddress=" + eaddress + ", passWord=" + passWord
				+ ", arrayed=" + arrayed + ", deleted=" + deleted + "]";
	}
	
}
