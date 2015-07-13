package com.alibaba.monitor.mavenWeb.pojos;
/**
 * @author yangjiadi
 */
public class User {
	private String userid;
	private String username;
	private String passwd;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username
				+ ", passwd=" + passwd + "]";
	}
}
