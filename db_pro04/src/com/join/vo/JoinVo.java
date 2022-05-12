package com.join.vo;

import java.sql.Date;

/*
 *  회원 정보를 담아 두기 위한 객체로 활용
 *  가입정보,수정, 조회, 등등... value object만 존재
 */
public class JoinVo {
	private String userid;		//아이디
	private String userpw;		//패스워드
	private String username;	//이름
	private char gender;		//성별 (M /F)
	private int age;			//나이
	private Date createDate;	//가입일 (데이터베이스 관련 날짜 java.sql)
	
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public void setGender(String gender) {
		if (gender.charAt(0) =='남'|| gender.charAt(0) =='M') {
			this.gender = 'M';
		}else if(gender.charAt(0) =='여'|| gender.charAt(0) == 'F')
			this.gender = 'F';
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setAge(String age) {
		this.age = Integer.parseInt(age);
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
	

}
