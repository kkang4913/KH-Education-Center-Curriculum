package model.vo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import exception.GradeException;

public class Teacher extends Acount {
	// 날짜로 로그인데이터 멤버변수를 생성
	private Date loginDate;
	
	
	public Teacher(String name) {
		setName(name);
		setPassword("11Aa");
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
		
		for (int i = 0; i < rand.nextInt(5) + 4; i++) {
			int idx = rand.nextInt(3);
			switch (idx) {
			case 0:
				newPass += (char)(rand.nextInt(26) + 97 );
				break;
			case 1:
				newPass += (char)(rand.nextInt(26) + 65 );
				break;
			case 2:
				newPass += rand.nextInt(10) + 1;
				break;

			}
		}
		setPassword(prefix + newPass);
		return prefix + newPass;
	}
	
	
	
	
}
