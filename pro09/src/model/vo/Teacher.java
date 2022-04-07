package model.vo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Teacher extends Acount {
	// 날짜로 로그인데이터 멤버변수를 생성
	private Date loginDate;
	
	
	public Teacher(String name) {
		setName(name);
		setPassword("1111");
	}
	
	public Teacher(String name, String passWord) {
		setName(name);
		setPassword(passWord);
	}

	
	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	
	public String getLoginDateFomat() {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy년 MM월 dd일 a hh시 mm분 ss초");
		return sFormat.format(loginDate);
	}
	
	public String resetPassword() {
		Random rand = new Random();
		String prefix = "TCH_";
		String newPass = "";
		
		for (int i = 0; i < 6; i++) {
			newPass += (char)(rand.nextInt(26) + 65);
		}
		setPassword(prefix + newPass);
		return prefix + newPass;
	}
	
	
	
	
}
