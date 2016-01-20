package cn.itcast.mybatis.mapper;

import java.util.List;

import cn.itcast.mybatis.po.QueryUserVo;
import cn.itcast.mybatis.po.User;

public interface UserMapperCustom {

	//用户信息信息
	public List<User> findUserList(QueryUserVo queryUserVo) throws Exception;
	//查询用户总数
	public int findUserCount(QueryUserVo queryUserVo)throws Exception;
	
	//查询用户使用resultMap
	public List<User> findUserListByResultMap(QueryUserVo queryUserVo)throws Exception;
}
