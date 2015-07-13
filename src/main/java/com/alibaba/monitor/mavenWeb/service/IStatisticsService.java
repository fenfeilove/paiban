package com.alibaba.monitor.mavenWeb.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.monitor.mavenWeb.pojos.Statistics;
/**
 * @author zhuohaidi
 */
@Repository
public interface IStatisticsService {
	public Statistics getStatistics(Statistics statistics);
	public List<Statistics> getAllStatistics(Statistics statistics);
	public Statistics getStatisticsByEmpnoTime(Statistics statistics);
	public void AddStatistics(Statistics statistics);
	public void AddMulitStatistics(List<Statistics> statisticslist);
	public void ModifyStatistics(Statistics statistics);
	public void DeleteStatistics(Statistics statistics);
}
