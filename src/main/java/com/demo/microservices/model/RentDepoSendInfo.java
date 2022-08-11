package com.demo.microservices.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RentDepoSendInfo {
	private String custNm;
	private String acctBankNm;
	private String acctNo;
	private String cntrDt;
	private String price;
}
