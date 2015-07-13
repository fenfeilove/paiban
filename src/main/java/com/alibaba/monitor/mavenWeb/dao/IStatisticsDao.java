package com.alibaba.monitor.mavenWeb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.monitor.mavenWeb.pojos.Statistics;
/**
 * @author zhuohaidi
 */
@Repository
public interface IStatisticsDao {
	public Statistics LoadStatistics(Statistics statistics);
	public List<Statistics> LoadAllStatistics(Statistics statistics);
	public Statistics loadStatisticsByEmpnoTime(Statistics statistics);
	public void AddStatistics(Statistics statistics);
	public void ModifyStatistics(Statistics statistics);
	public void DeleteStatistics(Statistics statistics);
}
