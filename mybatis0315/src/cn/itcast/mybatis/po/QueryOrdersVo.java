package cn.itcast.mybatis.po;

import java.awt.ItemSelectable;
import java.util.List;

/**
 * 
 * <p>Title: QueryOrdersVo</p>
 * <p>Description:订单查询包装对象 </p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2015-6-29上午8:51:47
 * @version 1.0
 */
public class QueryOrdersVo {
	
	//订单id的集合对象，将来要到statement中通过foreach遍历拼接sql
	private List<Integer> ids;
	
	
	//包装很多的查询条件
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	//根据订单信息查询
	private Orders orders;

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	
	//根据商品查询
//	private Item items
	
	

}
