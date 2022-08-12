package com.demo.microservices.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UsePossCust {
	private String custNo;
	private String custNm;
	private int useCnt;
}
