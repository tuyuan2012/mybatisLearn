package cn.itcast.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itcast.mybatis.po.User;

/**
 * 
 * <p>
 * Title: MybatisFirst
 * </p>
 * <p>
 * Description:入门程序
 * </p>
 * <p>
 * Company: www.itcast.com
 * </p>
 * 
 * @author 传智.燕青
 * @date 2015-6-27上午10:08:32
 * @version 1.0
 */
public class MybatisFirst {
	
	// 根据用户id查询用户信息
	@Test
	public void findUserById() throws IOException {
		// 全局配置文件
		String resource = "SqlMapConfig.xml";

		// 创建配置文件的流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 根据配置文件创建sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);

		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 通过sqlsession操作数据库
		// 第一个参数：statemnet的id，是namespace+"."+statemnet的id
		// 第二个参数：输入 参数
		User user = sqlSession.selectOne("test.findUserById", 1);

		System.out.println(user);

		// 手动关闭sqlsession
		sqlSession.close();

	}

	// 根据用户名称询用户信息
	@Test
	public void findUserByName() throws IOException {
		// 全局配置文件
		String resource = "SqlMapConfig.xml";

		// 创建配置文件的流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 根据配置文件创建sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);

		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 通过sqlsession操作数据库
		// 第一个参数：statemnet的id，是namespace+"."+statemnet的id
		// 第二个参数：输入 参数
		List<User> list = sqlSession.selectList("test.findUserByName", "张");

		System.out.println(list);

		// 关闭sqlsession
		sqlSession.close();

	}

	// 添加用户
	@Test
	public void insertUser() throws IOException {
		// 全局配置文件
		String resource = "SqlMapConfig.xml";

		// 创建配置文件的流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 根据配置文件创建sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);

		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 通过sqlsession操作数据库
		// 构造 一个user对象作为输入 参数
		User user = new User();
		user.setUsername("燕青1");
		user.setAddress("河南郑州");

		sqlSession.insert("test.insertUser", user);
		
		//得到用户新记录的id
		System.out.println(user.getId());

		// 提交
		sqlSession.commit();
		
		// 关闭sqlsession
		sqlSession.close();
	}

	// 删除
	@Test
	public void deleteUser() throws IOException {
		// 全局配置文件
		String resource = "SqlMapConfig.xml";

		// 创建配置文件的流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 根据配置文件创建sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);

		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 通过sqlsession操作数据库

		sqlSession.delete("test.deleteUser", 44);

		// 提交
		sqlSession.commit();

		// 关闭sqlsession
		sqlSession.close();
	}

	// 更新
	// 添加用户
	@Test
	public void updateUser() throws IOException {
		// 全局配置文件
		String resource = "SqlMapConfig.xml";

		// 创建配置文件的流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 根据配置文件创建sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);

		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 通过sqlsession操作数据库
		// 构造 一个user对象作为输入 参数，这里更新用户id必须设置
		User user = new User();
		user.setId(45);
		user.setUsername("苗润土");
		user.setAddress("河南郑州");

		sqlSession.update("test.updateUser", user);

		// 提交
		sqlSession.commit();

		// 关闭sqlsession
		sqlSession.close();
	}

}
