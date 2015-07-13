package com.alibaba.monitor.mavenWeb.pojos;
/**
 * @author yangjiadi
 */
public class Clazz {
	private int classid;
	private String classtype;
	private int intervals;
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public String getClasstype() {
		return classtype;
	}
	public void setClasstype(String classtype) {
		this.classtype = classtype;
	}
	public int getIntervals() {
		return intervals;
	}
	public void setIntervals(int intervals) {
		this.intervals = intervals;
	}
	@Override
	public String toString() {
		return "Clazz [classid=" + classid + ", classtype=" + classtype
				+ ", intervals=" + intervals + "]";
	}
	
}
