package com.demo.microservices.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.demo.microservices.model.SampleUser;

@Mapper
public interface SampleUserDao {	
	
	/**
	 * 사용자 전체 정보 가져오기 
	 * @return
	 * @throws Exception
	 */
	List<SampleUser> selectUserAll() throws Exception;
	
	SampleUser selectUser(String userId) throws Exception;
	
	int insertUser(SampleUser user) throws Exception;
	
	int updateUser(SampleUser user) throws Exception;
	
	int deleteUser(String userId) throws Exception;
}
