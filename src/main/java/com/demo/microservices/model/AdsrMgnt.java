package com.demo.microservices.model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AdsrMgnt {
	private String custNo;
	private String msg;
	private String msgTime;
	private String sendId;
	private String adsrNo;
	private String adsrNm;
	private String departmentNm;
	private String dtlInfo;
}