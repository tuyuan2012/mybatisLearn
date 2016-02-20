package cn.itcast.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.itcast.mybatis.po.User;

public class UserDaoImpl implements UserDao {
	
	private SqlSessionFactory sqlSessionFactory;
	
	

	//通过构造 方法进行注入
	//将来和spring整合后，通过set方法进行注入
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User findUserById(int id) throws Exception {
		SqlSession sqlSession = null;
		User user = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			
			// 通过sqlsession操作数据库
			// 第一个参数：statemnet的id，是namespace+"."+statemnet的id
			// 第二个参数：输入 参数
			user = sqlSession.selectOne("test.findUserById", 1);

			System.out.println(user);

		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
		
		
		
		return user;
	}

	@Override
	public List<User> findUserByName(String name) throws Exception {
		SqlSession sqlSession = null;
		List<User> list = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			
			list = sqlSession.selectList("test.findUserByName", name);

		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
		return list;
	}

	@Override
	public void insertUser(User user) throws Exception {
		SqlSession sqlSession = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			sqlSession.insert("test.insertUser", user);
			
			//得到用户新记录的id
			System.out.println(user.getId());
			

			// 提交
			sqlSession.commit();

		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
		
	}

	@Override
	public void updateUser(User user) throws Exception {
		SqlSession sqlSession = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			sqlSession.update("test.updateUser", user);
			
			// 提交
			sqlSession.commit();

		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
		
	}
	
	

}
