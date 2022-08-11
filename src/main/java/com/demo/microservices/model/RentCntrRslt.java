package com.demo.microservices.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RentCntrRslt {
	private String modelAddr;
	private String ownerNm;
	private String ownerTelNo;
	private String price;
	private String fixDt;
	private String entDt;
	private String rentStDt;
	private String rentEndDt;
}
