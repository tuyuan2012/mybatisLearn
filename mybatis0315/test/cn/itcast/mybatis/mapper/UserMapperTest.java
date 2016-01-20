package cn.itcast.mybatis.mapper;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.po.User;

public class UserMapperTest {

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
	public void testFindUserById() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//使用sqlSession创建代理对象
		//参数：mapper接口类型
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//调用mapper方法
		User user = userMapper.findUserById(1);
		System.out.println(user);
		
		sqlSession.close();
		
	}
	
	@Test
	public void testFindUserByName() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//使用sqlSession创建代理对象
		//参数：mapper接口类型
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//调用mapper方法
		List<User> list = userMapper.findUserByName("张");
		System.out.println(list);
		
		sqlSession.close();
		
	}

	@Test
	public void testInsertUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//使用sqlSession创建代理对象
		//参数：mapper接口类型
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//调用mapper方法
		User user = new User();
		user.setUsername("燕青");
		user.setAddress("河南郑州");
		userMapper.insertUser(user);
		sqlSession.commit();
		System.out.println(user);
		sqlSession.close();
		
	}

}
