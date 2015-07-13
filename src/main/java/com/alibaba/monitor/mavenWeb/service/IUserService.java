package com.alibaba.monitor.mavenWeb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.monitor.mavenWeb.pojos.User;
/**
 * @author zhuohaidi
 */
@Service
public interface IUserService {
	public User getUser(User user);
	public void AddMulitUser(List<User> userlist);
}
