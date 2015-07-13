package com.alibaba.monitor.mavenWeb.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.alibaba.monitor.mavenWeb.pojos.User;
/**
 * @author zhuohaidi
 */
@Repository
public interface IUserDao {
	public User LoadUser(User user);
	public void AddMulitUser(List<User> userlist);
}
