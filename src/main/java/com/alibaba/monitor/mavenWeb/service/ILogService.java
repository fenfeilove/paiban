package com.alibaba.monitor.mavenWeb.service;

import org.springframework.stereotype.Repository;
import com.alibaba.monitor.mavenWeb.pojos.Log;
/**
 * @author zhuohaidi
 */
@Repository
public interface ILogService {
	public void addLog(Log log);
}
