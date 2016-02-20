package cn.itcast.mybatis.mapper;

import java.util.List;

import cn.itcast.mybatis.po.Orders;
import cn.itcast.mybatis.po.OrdersCustom;
import cn.itcast.mybatis.po.QueryOrdersVo;
import cn.itcast.mybatis.po.User;

public interface OrdersMapper {
	//订单查询
	public List<Orders> findOrders(QueryOrdersVo queryOrdersVo) throws Exception;
	
	//查询订单关联查询用户
	public List<OrdersCustom> findOrdersAndUserList() throws Exception;
	//一对一使用reusltMap
	public List<Orders> findOrdersAndUserListResultMap() throws Exception;
	//一对多
	public List<Orders> findOrdersAndDetailList() throws Exception;
	//多对多查询
	public List<User> findUserAndItemsList()throws Exception;
	
	//一对一查询延迟加载
	public List<Orders> findOrdersUserLazyLoad()throws Exception;
	
	
}
