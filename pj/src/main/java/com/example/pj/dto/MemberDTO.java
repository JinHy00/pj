package com.example.pj.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {
	private String userid;
	private String name;
	private String passwd;
	private String email;
	private String phoneNum;
	private String zipcode;
	private String mainAddress;
	private String detailAddress;
	private Date joinDate;
}
