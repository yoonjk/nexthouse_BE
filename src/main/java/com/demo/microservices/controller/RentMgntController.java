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
import com.demo.microservices.dao.RentCntrMgntDAO;
import com.demo.microservices.model.RentCntrList;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class RentMgntController {
	
	@Autowired
	private RentCntrMgntDAO rentCntrMgntDAO;

	@Value("${garage.product.server}")
	String productServer;
	
	@Value("${garage.product.port}")
	String productPort;
	

	
	@ApiOperation(value="전체 임대계약목록 정보 가져오기")
	@GetMapping(value="/RentCntrList/{custNo}")
	public ResponseEntity <List<RentCntrList>> getRentCntrListAll(@PathVariable String custNo) { 
		
		List<RentCntrList> list = null;
		try {
			log.info("Start db select");
			list = rentCntrMgntDAO.selectRentCntrAll(custNo);
		} catch (Exception e) {
			log.error("ERROR", e);
			throw new RuntimeException(e);
		}
		
		log.info("user counts :"+list.size());
		
		return new ResponseEntity<List<RentCntrList>> (list, HttpStatus.OK);
	}

	@ApiOperation(value="고객선호모델임대계약등록########")
	@PostMapping(value="/RentCntrIn/custNo={custNo}&modelNo={modelNo}")
	public ResponseEntity <String> insertRentCntr(@PathVariable String custNo, @PathVariable String modelNo ) { 
		
		String msg = null;
		
		try {
			rentCntrMgntDAO.insertRentCntr(custNo, modelNo);
			rentCntrMgntDAO.deleteCustRegModel(custNo, modelNo);
		} catch (Exception e) {
			log.error("ERROR", e);
			throw new RuntimeException(e);
		}
		msg = "임대계약등록 성공";
		return new ResponseEntity<String> (msg, HttpStatus.OK);
	}
	
	@ApiOperation(value="임대계약다음단계처리")
	@PostMapping(value="/RentCntrNextStep/rentCntrNo={rentCntrNo}&progress={progress}")
	public ResponseEntity <String> updateRentCntrStep(@PathVariable String rentCntrNo, @PathVariable int progress ) { 
		
		String msg = null;
		char cd = 'A';
		progress = progress + 1;
		
		if(progress == 5) { cd = 'C'; }
		
		try {
			rentCntrMgntDAO.updateRentCntrStep(rentCntrNo, progress, cd);
		} catch (Exception e) {
			log.error("ERROR", e);
			throw new RuntimeException(e);
		}
		msg = "임대계약다음단계처리";
		return new ResponseEntity<String> (msg, HttpStatus.OK);
	}
}

