package com.demo.microservices.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.demo.microservices.model.RentCntrList;

@Mapper
public interface RentCntrMgntDAO {
	/**
	 * 전세계약관리
	 * @return
	 * @throws Exception
	 */
	List<RentCntrList> selectRentCntrAll(String rentCntrNo) throws Exception;
}
