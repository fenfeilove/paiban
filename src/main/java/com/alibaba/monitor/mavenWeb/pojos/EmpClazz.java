package com.alibaba.monitor.mavenWeb.pojos;

import java.util.Arrays;
/**
 * @author yangjiadi
 */
public class EmpClazz {
	private Emp emp;
	private int a[];
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	public int[] getA() {
		return a;
	}
	public void setA(int[] a) {
		this.a = a;
	}
	@Override
	public String toString() {
		return "EmpClazz [emp=" + emp + ", a=" + Arrays.toString(a) + "]";
	}
	
}
