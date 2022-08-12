package com.demo.microservices.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.demo.microservices.model.UsePossCust;

@Mapper
public interface CustMgntDAO {
	List<UsePossCust> selectUsePossCust() throws Exception;
	
	int updateCustUseCnt(String custNo) throws Exception;
}