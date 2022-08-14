package com.demo.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.microservices.dao.CustMgntDAO;
import com.demo.microservices.dao.RentCntrMgntDAO;
import com.demo.microservices.model.RentCntr;
import com.demo.microservices.model.UsePossCust;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CustMgntController {
	@Autowired
	private CustMgntDAO custMgntDAO ;

	@Value("${garage.product.server}")
	String productServer;
	
	@Value("${garage.product.port}")
	String productPort;
	
	@ApiOperation(value="사용가능유저리스트조회")
	@CrossOrigin
	@GetMapping(value="/UsePossCust")
	public ResponseEntity <List<UsePossCust>> getUsePossCustAll() { 
		
		List<UsePossCust> list = null;
		try {
			
			log.info("Start db select");
			list = custMgntDAO.selectUsePossCust();
			log.info("End db select");
			
		} catch (Exception e) {
			log.error("ERROR", e);
			throw new RuntimeException(e);
		}
		
		log.info("user counts :"+list.size());
		
		return new ResponseEntity<List<UsePossCust>> (list, HttpStatus.OK);
	}
	
	@ApiOperation(value="사용자 수정")
	@CrossOrigin
	@PutMapping(value="/CustUseCnt/{custNo}")
	public ResponseEntity <String> updateCustUseCnt(@PathVariable String custNo) { 
		
		int rc = 0;
		String msg = null;
		
		try {
			
			log.info("Start update DB");
			rc = custMgntDAO.updateCustUseCnt(custNo);
			log.info("End update DB");
			
		} catch (Exception e) {
			log.error("ERROR", e);
			throw new RuntimeException(e);
		}
		log.info("update user rc:"+rc);
		
		if (rc > 0) {
			msg =  "수정 성공";
		}
		
		return new ResponseEntity<String> (msg, HttpStatus.OK);
	}	

}
