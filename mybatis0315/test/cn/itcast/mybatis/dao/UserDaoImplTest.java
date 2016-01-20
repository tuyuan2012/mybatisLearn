package cn.itcast.mybatis.dao;

import static org.junit.Assert.*;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.po.User;

public class UserDaoImplTest {

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
		// 构造 dao对象
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		// 调用dao的方法进行测试
		User user = userDao.findUserById(1);
		
		System.out.println(user);

	}

}
