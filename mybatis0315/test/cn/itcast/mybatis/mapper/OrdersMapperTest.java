package cn.itcast.mybatis.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.po.Orders;
import cn.itcast.mybatis.po.OrdersCustom;
import cn.itcast.mybatis.po.QueryOrdersVo;
import cn.itcast.mybatis.po.User;

public class OrdersMapperTest {

	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		// 创建会话工厂
		// 全局配置文件
		String resource = "SqlMapConfig.xml";

		// 创建配置文件的流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 根据配置文件创建sqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
	}

	@Test
	public void testFindOrders() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建代理对象
		OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
		//调用ordersMapper方法
		//构造 查询条件
		QueryOrdersVo queryOrdersVo = new QueryOrdersVo();
		Orders orders =new Orders();
		orders.setId(3);
		queryOrdersVo.setOrders(orders);
		//构造 查询条件，多个id
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(3);
//		ids.add(4);
		queryOrdersVo.setIds(ids);
		List<Orders> list = ordersMapper.findOrders(queryOrdersVo);
		System.out.println(list);
		
		sqlSession.close();
	}
	
	@Test
	public void testfindOrdersAndUserList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建代理对象
		OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
		//调用ordersMapper方法
		
		List<OrdersCustom> list = ordersMapper.findOrdersAndUserList();
		System.out.println(list);
		
		sqlSession.close();
	}
	
	//一对一查询使用reusltMap
	
	@Test
	public void testfindOrdersAndUserListResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建代理对象
		OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
		//调用ordersMapper方法
		
		List<Orders> list = ordersMapper.findOrdersAndUserListResultMap();
		System.out.println(list);
		
		sqlSession.close();
	}
	//一对多
	@Test
	public void testfindOrdersAndDetailList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建代理对象
		OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
		//调用ordersMapper方法
		
		List<Orders> list = ordersMapper.findOrdersAndDetailList();
		System.out.println(list);
		
		sqlSession.close();
	}
	
	//多对多查询
	@Test
	public void testfindUserAndItemsList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建代理对象
		OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
		//调用ordersMapper方法
		
		List<User> list = ordersMapper.findUserAndItemsList();
		System.out.println(list);
		
		sqlSession.close();
	}
	
	//延迟加载测试
	@Test
	public void testfindOrdersUserLazyLoad() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建代理对象
		OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
		//调用ordersMapper方法
		//第一次查询只查询订单信息
		List<Orders> list = ordersMapper.findOrdersUserLazyLoad();
		
		//如果从List中取订单关联的用户信息时，执行延迟加载
		Orders orders = list.get(0);
		User user = orders.getUser();
		System.out.println(user);
		
		sqlSession.close();
	}
	
	
	
	
	

}
