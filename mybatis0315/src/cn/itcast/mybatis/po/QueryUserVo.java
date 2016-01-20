package cn.itcast.mybatis.po;

import java.awt.event.ItemEvent;

/**
 * 
 * <p>Title: QueryUserVo</p>
 * <p>Description: 用户信息查询的包装类型</p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2015-6-27下午4:44:27
 * @version 1.0
 */
public class QueryUserVo {
	
	//可能要包括很多pojo类型作为它的属性
	
	//用户信息
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	//商品信息
	//private Items items;
	
	//订单信息
	//private Orders orders;
	
	

}
