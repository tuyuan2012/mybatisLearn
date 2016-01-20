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

public class UserMapperCustomTest {

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
	public void testFindUserList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建代理对象
		UserMapperCustom mapper = sqlSession.getMapper(UserMapperCustom.class);
		//构造 queryUserVo（存放 查询条件)
		QueryUserVo queryUserVo = new QueryUserVo();
		User user  = new User();
		user.setUsername("张");
		queryUserVo.setUser(user);
		
		List<User> list = mapper.findUserList(queryUserVo);
		
		System.out.println(list);
		
		sqlSession.close();
	}
	
	@Test
	public void testFindUserCount() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建代理对象
		UserMapperCustom mapper = sqlSession.getMapper(UserMapperCustom.class);
		//构造 queryUserVo（存放 查询条件)
		QueryUserVo queryUserVo = new QueryUserVo();
		User user  = new User();
		user.setUsername("张");
		queryUserVo.setUser(user);
		
		int count = mapper.findUserCount(queryUserVo);
		
		System.out.println(count);
		
		sqlSession.close();
	}
	@Test
	public void testfindUserListByResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建代理对象
		UserMapperCustom mapper = sqlSession.getMapper(UserMapperCustom.class);
		//构造 queryUserVo（存放 查询条件)
		QueryUserVo queryUserVo = new QueryUserVo();
		User user  = new User();
		user.setUsername("张");
		queryUserVo.setUser(user);
		
		List<User> list = mapper.findUserListByResultMap(queryUserVo);
		
		System.out.println(list);
		
		sqlSession.close();
	}
	

}
