package exam01;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sample06 {
public static void main(String[] args) {
	/*
	 *  Date 클래스
	 * 		- 시스템으로 부터 현재 날짜, 시간 정보를 가져와서 사용할 수 있게 만들어진 클래스
	 */
	Date date = new Date();
	System.out.println(date);
	
	System.out.println(date.getTime());
	
	String year = String.format("%tY년", date);
	String month = String.format("%tm월", date);
	String day = String.format("%td일", date);
	System.out.printf("%s %s %s\n",year,month,day);
	
	String hour = String.format("%tH시", date);
	String minute = String.format("%tM분", date);
	String second = String.format("%tS초", date);
	System.out.printf("%s %s %s\n",hour,minute,second);
	
	/*
	 *  Calendar 클래스(날짜 관련)
	 *  	- new 연산자로 객체 생성을 할 수 없다.
	 */
	Calendar c = Calendar.getInstance(); //메서드로 객체를 생성
	
	System.out.println(c.get(Calendar.YEAR));
	System.out.println(c.get(Calendar.MONTH)+1); //월은 0부터 시작
	System.out.println(c.get(Calendar.DATE));
	System.out.println(c.get(Calendar.HOUR));
	System.out.println(c.get(Calendar.MINUTE));
	System.out.println(c.get(Calendar.SECOND));
	
	//날짜 더하기 ( +, -)
	c.add(Calendar.DATE, 1);
	c.add(Calendar.MONTH, -1);
	
	switch(c.get(Calendar.DAY_OF_WEEK)){
	case Calendar.MONDAY:
		System.out.println("월요일");
		break;
	case Calendar.TUESDAY:
		System.out.println("화요일");
		break;
	case Calendar.WEDNESDAY:
		System.out.println("수요일");
		break;
	case Calendar.THURSDAY:
		System.out.println("목요일");
		break;
	case Calendar.FRIDAY:
		System.out.println("금요일");
		break;
	case Calendar.SATURDAY:
		System.out.println("토요일");
		break;
	case Calendar.SUNDAY:
		System.out.println("일요일");
		break;
	}
	
	System.out.println(c.getTime());
	c.add(Calendar.DATE, 1);
	System.out.println(c.getTime());
	c.add(Calendar.MONTH, -1);
	System.out.println(c.getTime());
	c.add(Calendar.YEAR, -1);
	System.out.println(c.getTime());
	c.add(Calendar.HOUR, 1);
	System.out.println(c.getTime());
	c.add(Calendar.MINUTE, 1);
	System.out.println(c.getTime());
	c.add(Calendar.SECOND, 1);
	
	c.add(Calendar.DATE, 600);
	System.out.println(c.getTime());
	
	
	/*
	 * GregorianCalendar 클래스
	 * 		-Calendar 클래스를 상속하여 사용하는 클래스
	 */
	GregorianCalendar g = new GregorianCalendar(); //생성자 사용가능
	
	System.out.println(g.get(Calendar.YEAR));
	System.out.println(g.get(Calendar.MONTH)+1); //월은 0부터 시작
	System.out.println(g.get(Calendar.DATE));
	System.out.println(g.get(Calendar.HOUR));
	System.out.println(g.get(Calendar.MINUTE));
	System.out.println(g.get(Calendar.SECOND));
	
	System.out.println("윤년 : " +g.isLeapYear(g.get(Calendar.YEAR)+2));
	
	/*
	 * SimpleDateFormat 클래스
	 * 		- 날짜 포멧 형식을 자유롭게 만들기 위해 사용하는 클래스
	 */
	SimpleDateFormat sFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
	String strDate = sFormat.format(new Date());
	System.out.println("변경 후 날짜 : " + strDate);
	
	sFormat = new SimpleDateFormat("a hh:mm:dd");
	strDate = sFormat.format(new Date());
	System.out.println("변경 후 날짜 : " + strDate);
	
	
}
}
