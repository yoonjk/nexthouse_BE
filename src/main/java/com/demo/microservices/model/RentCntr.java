package com.demo.microservices.model;
import java.math.BigInteger;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RentCntr {
	private String cntrDiv;
	private String modelNo;
	private String modelNm;
	private String modelAddr;
	private String price;
	private int progress;
	private String rentStDt;
	private String rentEndDt;
	private String rentCntrNo;
}
