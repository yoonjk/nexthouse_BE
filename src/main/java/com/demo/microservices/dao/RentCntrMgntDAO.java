package com.demo.microservices.dao;

import java.time.LocalDate;
import java.util.List; 

import org.apache.ibatis.annotations.Mapper;

import com.demo.microservices.model.RentCntr;
import com.demo.microservices.model.RentCntrRslt;
import com.demo.microservices.model.RentDepoSendInfo;

@Mapper
public interface RentCntrMgntDAO {
	/**
	 * 전세계약관리
	 * @return
	 * @throws Exception
	 */
	List<RentCntr> selectRentCntrAll(String custNo) throws Exception;
	
	int insertRentCntr(String custNo, String modelNo);
	
	int deleteCustRegModel(String custNo, String modelNo);
	
	int updateRentCntrStep(String rentCntrNo, int progress, char cd, String rentStDt, String fixDt, String entDt);
	
	List<RentCntrRslt> selectRentCntrRslt(String rentCntrNo) throws Exception;
	
	List<RentDepoSendInfo> selectRentDepoSendInfo(String custNo) throws Exception;
}
