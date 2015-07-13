package com.alibaba.monitor.mavenWeb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.monitor.mavenWeb.dao.ILogDao;
import com.alibaba.monitor.mavenWeb.pojos.Log;
import com.alibaba.monitor.mavenWeb.service.ILogService;
@Service
public class LogServiceImpl implements ILogService {

	@Autowired
	ILogDao logdao;
	@Override
	public void addLog(Log log) {
		// TODO Auto-generated method stub
		logdao.AddLog(log);
	}
	
}
