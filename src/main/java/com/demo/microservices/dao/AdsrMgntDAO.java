package com.demo.microservices.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.demo.microservices.model.AdsrMgnt;

@Mapper
public interface AdsrMgntDAO {
	/**
	 * 상담관리
	 * @return
	 * @throws Exception
	 */
	List<AdsrMgnt> selectAdsrAll(String custNo) throws Exception;
}
