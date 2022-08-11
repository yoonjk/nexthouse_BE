package com.demo.microservices.controller;


import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.microservices.dao.AdsrMgntDAO;
import com.demo.microservices.dao.RentCntrMgntDAO;
import com.demo.microservices.model.AdsrMgnt;
import com.demo.microservices.model.AdsrSearch;
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
	@GetMapping(value="/adsrMsgAll/{custNo}")
	public ResponseEntity <List<AdsrMgnt>> getselectAdsrAll(@PathVariable String custNo) { 
		
		List<AdsrMgnt> list = null;
		String msgTime = null;
		
		try {
			log.info("Start db select");
			list = adsrMgntDAO.selectAdsrAll(custNo, msgTime);
		} catch (Exception e) {
			log.error("ERROR", e);
			throw new RuntimeException(e);
		}
		
		log.info("user counts :"+list.size());
		
		return new ResponseEntity<List<AdsrMgnt>> (list, HttpStatus.OK);
	}
	
	@ApiOperation(value="채팅 등록이후 상담이력 가져오기")
	@PostMapping(value="/inselAdsr")
	public ResponseEntity <List<AdsrMgnt>> inselAdsr(@RequestBody AdsrMgnt adsrMgnt) { 
		
		//List<AdsrMgnt> list = null;
		int rc = 0;
		String msg = null;
		List<AdsrMgnt> list = null;
		
		try {
			log.info("Start insert DB");
			rc = adsrMgntDAO.insertAdsr(adsrMgnt);
			log.info("End insert DB");
			list = adsrMgntDAO.selectAdsrAll(adsrMgnt.getCustNo(), adsrMgnt.getMsgTime().toString());
		} catch (Exception e) {
			log.error("ERROR", e);
			throw new RuntimeException(e);
		}
		
		if (rc > 0) {
			msg =  "등록 성공";
		}

		return new ResponseEntity<List<AdsrMgnt>>(list, HttpStatus.OK);
	}
	
	@ApiOperation(value="현재상담사조회")
	@GetMapping(value="/curAdsrSel/{custNo}")
	public ResponseEntity <List<AdsrSearch>> getCurAdsr(@PathVariable String custNo) { 
		
		List<AdsrSearch> list = null;
		
		try {
			log.info("Start db select");
			list = adsrMgntDAO.adsrSearch(custNo);
		} catch (Exception e) {
			log.error("ERROR", e);
			throw new RuntimeException(e);
		}
		
		log.info("user counts :"+list.size());
		
		return new ResponseEntity<List<AdsrSearch>> (list, HttpStatus.OK);
	}
}
