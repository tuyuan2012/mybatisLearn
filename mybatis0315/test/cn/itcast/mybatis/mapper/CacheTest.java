package cn.itcast.mybatis.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.po.QueryUserVo;
import cn.itcast.mybatis.po.User;

public class CacheTest {

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

	//一级缓存测试
	
	@Test
	public void testCache1() throws Exception{
		//创建一个sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//代理对象
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		
		//第一次查询根据用户id查询用户信息
		User user = mapper.findUserById(1);
		System.out.println(user);
		
		//在中间执行commit操作（用户修改、添加、删除），可以清空一级缓存。
		//......
		
		//第二次查询根据用户id查询用户信息
		user = mapper.findUserById(1);
		System.out.println(user);
		
		sqlSession.close();
	}
	
	//二级缓存测试
	@Test
	public void testCache2() throws Exception{
		//创建sqlsession
		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		
		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		
		SqlSession sqlSession3 = sqlSessionFactory.openSession();
		//代理对象
		UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
		
		UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
		
		UserMapper mapper3 = sqlSession3.getMapper(UserMapper.class);
		
		
		//第一次查询根据用户id查询用户信息
		User user1 = mapper1.findUserById(1);
		System.out.println(user1);
		
		//注意：将sqlSession1.close时将数据存入二级缓存
		sqlSession1.close();
		
		//使用sqlSession3进行用户添加、修改、删除执行commit，会清空二级缓存
		//.....
		
		//第二次查询根据用户id查询用户信息
		User user2 = mapper2.findUserById(1);
		System.out.println(user2);
		
		sqlSession2.close();
		
		
	}
	
	
	

}
