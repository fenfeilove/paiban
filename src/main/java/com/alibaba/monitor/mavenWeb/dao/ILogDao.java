package com.alibaba.monitor.mavenWeb.dao;

import org.springframework.stereotype.Repository;

import com.alibaba.monitor.mavenWeb.pojos.Log;
/**
 * @author zhuohaidi
 */
@Repository
public interface ILogDao{
	public void AddLog(Log log);
}