package com.demo.microservices.controller;


import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.microservices.dao.AdsrMgntDAO;
import com.demo.microservices.dao.RentCntrMgntDAO;
import com.demo.microservices.model.AdsrMgnt;
import com.demo.microservices.model.RentCntr;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AdsrMgntController {
	
	@Autowired
	private AdsrMgntDAO adsrMgntDAO;

	@Value("${garage.product.server}")
	String productServer;
	
	@Value("${garage.product.port}")
	String productPort;
	
	@ApiOperation(value="전체 상담이력 가져오기")
	@GetMapping(value="/AdsrAll/{custNo}")
	public ResponseEntity <List<AdsrMgnt>> getselectAdsrAll(@PathVariable String custNo) { 
		
		List<AdsrMgnt> list = null;
		try {
			log.info("Start db select");
			list = adsrMgntDAO.selectAdsrAll(custNo);
		} catch (Exception e) {
			log.error("ERROR", e);
			throw new RuntimeException(e);
		}
		
		log.info("user counts :"+list.size());
		
		return new ResponseEntity<List<AdsrMgnt>> (list, HttpStatus.OK);
	}
	
}
