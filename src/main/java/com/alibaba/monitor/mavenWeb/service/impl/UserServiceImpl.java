package com.alibaba.monitor.mavenWeb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.monitor.mavenWeb.dao.IUserDao;
import com.alibaba.monitor.mavenWeb.pojos.User;
import com.alibaba.monitor.mavenWeb.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	IUserDao userDao;
	public User getUser(User user) {
		return userDao.LoadUser(user);
	}
	@Override
	public void AddMulitUser(List<User> userlist) {
		// TODO Auto-generated method stub
		userDao.AddMulitUser(userlist);
	}
}
