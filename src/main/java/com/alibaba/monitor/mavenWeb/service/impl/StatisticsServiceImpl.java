package com.alibaba.monitor.mavenWeb.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.monitor.mavenWeb.dao.ILogDao;
import com.alibaba.monitor.mavenWeb.dao.IStatisticsDao;
import com.alibaba.monitor.mavenWeb.pojos.Log;
import com.alibaba.monitor.mavenWeb.pojos.Statistics;
import com.alibaba.monitor.mavenWeb.service.IStatisticsService;
@Service
public class StatisticsServiceImpl implements IStatisticsService {
	@Autowired
	IStatisticsDao statisticsDao;
	@Autowired
	ILogDao logdao;
	@Override
	public Statistics getStatistics(Statistics statistics) {
		// TODO Auto-generated method stub
		return statisticsDao.LoadStatistics(statistics);
	}

	@Override
	public List<Statistics> getAllStatistics(Statistics statistics) {
		// TODO Auto-generated method stub
		return statisticsDao.LoadAllStatistics(statistics);
	}

	@Override
	public void AddStatistics(Statistics statistics) {
		// TODO Auto-generated method stub
		
		Log log=new Log();
		log.setEmpno(1);
		log.setDates(new Date());
		log.setTablename("schedule");
		log.setOperate("add");
		log.setBfupdate("");
		log.setUpdated(statistics.toString());
		logdao.AddLog(log);
		statisticsDao.AddStatistics(statistics);
	}

	@Override
	public void ModifyStatistics(Statistics statistics) {
		// TODO Auto-generated method stub
		
		Log log=new Log();
		log.setEmpno(1);
		log.setDates(new Date());
		log.setTablename("schedule");
		log.setOperate("update");
		log.setBfupdate(statisticsDao.LoadStatistics(statistics).toString());
		log.setUpdated(statistics.toString());
		logdao.AddLog(log);
		statisticsDao.ModifyStatistics(statistics);
	}

	@Override
	public void DeleteStatistics(Statistics statistics) {
		// TODO Auto-generated method stub
		
		Log log=new Log();
		log.setEmpno(1);
		log.setDates(new Date());
		log.setTablename("schedule");
		log.setOperate("delete");
		log.setBfupdate(statisticsDao.LoadStatistics(statistics).toString());
		log.setUpdated("");
		logdao.AddLog(log);
		statisticsDao.DeleteStatistics(statistics);
	}

	@Override
	public void AddMulitStatistics(List<Statistics> statisticslist) {
		// TODO Auto-generated method stub
		for(int i=0;i<statisticslist.size();i++)
		{
			AddStatistics(statisticslist.get(i));
		}
	}

	@Override
	public Statistics getStatisticsByEmpnoTime(Statistics statistics) {
		// TODO Auto-generated method stub
		return statisticsDao.loadStatisticsByEmpnoTime(statistics);
	}
}
