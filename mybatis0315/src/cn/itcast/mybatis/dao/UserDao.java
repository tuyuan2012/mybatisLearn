package cn.itcast.mybatis.dao;

import java.util.List;

import cn.itcast.mybatis.po.User;

/**
 * 
 * <p>Title: UserDao</p>
 * <p>Description:用户管理dao </p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2015-6-27下午2:55:50
 * @version 1.0
 */
public interface UserDao {
	
	//根据用户id查询用户信息
	public User findUserById(int id) throws Exception;
	
	//根据用户名称查询
	public List<User> findUserByName(String name) throws Exception;
	
	//插入用户信息
	public void insertUser(User user) throws Exception;
	
	//更新用户信息
	public void updateUser(User user) throws Exception;

}
