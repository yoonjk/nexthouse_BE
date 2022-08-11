package com.demo.microservices.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.demo.microservices.model.AdsrMgnt;
import com.demo.microservices.model.AdsrSearch;

@Mapper
public interface AdsrMgntDAO {
	/**
	 * 상담관리
	 * @return
	 * @throws Exception
	 */
	List<AdsrMgnt> selectAdsrAll(String custNo, String msgTime) throws Exception;
	
	int insertAdsr(AdsrMgnt adsrMgnt) throws Exception;
	
	List<AdsrSearch> adsrSearch(String custNo) throws Exception;
}
