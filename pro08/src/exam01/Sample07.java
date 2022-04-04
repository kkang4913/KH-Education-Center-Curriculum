package exam01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Scanner;


public class Sample07 {
	Scanner sc = new Scanner(System.in);
	Date date = new Date();
	public void ex01() {	
		/*
		 *  현재 날짜를 구하고 다음 형식에 맞추어 출력하시오.
		 *  	1. 2022/01/01
		 *  	2. 2022년 01월 01일
		 *  	3. 1월 1일 
		 *  	4. 오전 12시 00분 월요일 
		 */
	SimpleDateFormat sFormat = new SimpleDateFormat("yyyy/MM/dd");
	String strDate = sFormat.format(date);
	System.out.println("1. " + strDate);
	
	sFormat.applyPattern("yyyy년MM월d일");
	strDate = sFormat.format(date);
	System.out.println("2. " + strDate);
	
	sFormat.applyPattern("MM월dd일");
	strDate = sFormat.format(date);
	System.out.println("3. " + strDate);
	
	sFormat.applyPattern("a hh시 mm분 E요일");
	strDate = sFormat.format(date);
	System.out.println("4. " + strDate);
	}
	public void ex02() {
		/*
		 *  사용자 입력을 이용하여 현재 날짜에서 n일을 추가하거나 뺐을 때의
		 *  날짜가 언제인지 확인할 수 있게 출력하시오.
		 *  	예)
		 *  		일자 : 10
		 *  		현재 날짜에서 10일 후 날짜는 2022년 04월 11일 입니다.
		 *  
		 *  		일자 :-10
		 *  		현재 날짜에서 10일 전 날짜는 2022년 03월 22일 입니다.
		 */
		System.out.print("일자 : ");
		String input =sc.nextLine();
		int addDay = Integer.parseInt(input);
		
		GregorianCalendar g =new GregorianCalendar();
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
		g.add(Calendar.DATE, addDay);
		
		String strDate =sFormat.format(g.getTime());
		String result = "";
		if(addDay > 0) {
			result = String.format("현재 날짜에서 %d일 후 날짜는 %s 입니다.", addDay,strDate);
		}else {
			result = String.format("현재 날짜에서 %d일 전 날짜는 %s 입니다.", addDay,strDate);
		}
		System.out.println(result);
	}
	public void ex03() {
		/*
		 * 주민등록 앞 번호의 생년월일을 입력하면 날짜로 변환되어 출력할 수 있도록 하시오.
		 */
		String input = "";
		while(true) {
			System.out.print("주민번호 앞자리만 입력 : ");
			input = sc.nextLine();
			if (input.matches("\\d{6}")) {
				break;
			}
			System.out.println("주민번호 앞자리 6자리만 입력하세요.");
		}
		
		SimpleDateFormat sFormat = new SimpleDateFormat("yyMMdd");
		try {
			Date d = sFormat.parse(input);
			System.out.println(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
	}
	public void ex04() {
		/*
		 * 자신의 올해 생일이 몇일 남았는지 알 수 있도록 해주는 코드를 작성하시오.
		 */
		GregorianCalendar now = new GregorianCalendar();
		GregorianCalendar birthDay = new GregorianCalendar();
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy.MM.dd");
		Scanner sc = new Scanner(System.in);
		
		String input = "";
		while(true) {
			System.out.print("자신의 생일을 \"월.일\" 형식으로 입력하세요 : ");
			input = sc.nextLine();
			
			if(input.matches("\\d{1,2}\\.\\d{1,2}")) {
				break;
			}
			System.out.println("입력 형식을 다시 확인하세요.");
		}
		
		try {
			birthDay.setTime(sFormat.parse(now.get(Calendar.YEAR) + "." + input));
			System.out.println(birthDay.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if (now.before(birthDay)) {
		long birth = (birthDay.getTimeInMillis() - now.getTimeInMillis()) / (24*60*60*1000);
		System.out.println(birth + "일");
		}
		
		System.out.println(now.after(birthDay));
		System.out.println(now.before(birthDay));
	}
	public void ex05() {
		/*
		 * 프로그램이 동작한 후 부터 종료할 때까지의 시간 기록을 남기기 위한 코드를 작성하시오.
		 * 기록을 남기기 위한 프로그램은 1 ~ 100,000 까지의 누적합을 구하는 코드로 한다.
		 *  - 동작이 잘이루어지게끔 로직을 구현하고
		 *  - 로직을 수정해서 최적화 할때 자주 사용된다.
		 */
		Date start =new Date();
		
		long tot =0;
		for (int i = 1; i < 1651000000L; i++) {
			tot+=i;
		}
		
		Date end =new Date();
		long time = end.getTime() - start.getTime();
		System.out.println("실행 시간 : " + time / 1000.0 + "밀리초");
	}
	public void ex06() {
		/*
		 *  2020년 부터 2099년 까지의 년도 중 윤년에 해당하는 년도를 정수 배열에 담아 출력하시오.
		 */
		// 1. 윤년을 구해야한다  -> GregorianCalendar
		
		GregorianCalendar gc = new GregorianCalendar();
		int[] leapYear = new int[0];
		for (int year = 2020; year < 2100; year++) {// 2020년 설정 
			if(gc.isLeapYear(year)) { 
			leapYear = Arrays.copyOf(leapYear, leapYear.length + 1);
			leapYear[leapYear.length - 1]  = year;
			}
		}
		System.out.println(Arrays.toString(leapYear));
	}
		public void ex07() {
		/*
		 * 2022년 4월에서 주말에 해당하는 날짜만 날짜 배열에 저장하세요.
		 */	Date[] dArr = new Date[0];
			GregorianCalendar gc =new GregorianCalendar();
			SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd E요일");
			gc.set(2022, 3,1);
													//해당월의 마지막 일을 알수 있다.
			for (int i = gc.get(Calendar.DATE); i <= gc.getActualMaximum(Calendar.DATE); i++) {
				gc.set(2022,3, i);
				//주말인지 아닌지 체크
				switch(gc.get(Calendar.DAY_OF_WEEK)){
				case Calendar.SATURDAY: case Calendar.SUNDAY:
				dArr = Arrays.copyOf(dArr, dArr.length + 1);
					dArr[dArr.length -1] = gc.getTime();
				}
			}
			for (int i = 0; i < dArr.length; i++) {
				System.out.println(sFormat.format(dArr[i]));
			}
			
			
		}
		public void ex08() {
			/*
			 * 유튜브에서는 영상 업로드가 언제 이루어졌는지를 보여주는 형식이 x초 전 또는 x분 전, x시간 전 
			 * x일 전 x주 전 x개월 전 y년 전으로만 출력
			 * 이를 동일하게 모방하여 사용자가 입력한 날짜가 현재 시간과 얼만큼의 차이가 있는지 출력하시오.
			 * 
			 */
			GregorianCalendar upload = new GregorianCalendar(2022,3 - 1, 20, 1, 46, 55);
			SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd a hh:mm:dd:ss"); //미리 정해놓으면 편하다
			Date now = new Date();
			System.out.println("업로드 시간 : " + sFormat.format(upload.getTime()));
			System.out.println("현재 시간 : " + sFormat.format(now));
			//Date      -> long 
			int beforeTime = (int)((now.getTime() - upload.getTime().getTime()) / 1000);

			
			if (beforeTime <= 60) {
				System.out.println(beforeTime + "초 전");
			}else if (beforeTime <= 60* 60) {
				System.out.println(beforeTime / 60 + "분 전");
			}else if(beforeTime <= 60*60*24) {
				System.out.println(beforeTime / (60 * 60) + "시간 전");
			}else if(beforeTime <= 60 *60 *24 *7) {
				System.out.println(beforeTime / (60 * 60 * 24) + "일 전");
			}else if(beforeTime <= 60 *60 *24 * 7 *4 ) {
				System.out.println(beforeTime / (60 * 60 * 24 * 7) + "주 전");
			}else if(beforeTime <= 60 *60 *24 * 7 * 4 *12 ) {
				System.out.println(beforeTime / (60 * 60 * 24 * 7 * 4) + "개월 전");
			}else {
				System.out.println(beforeTime / (60 * 60 * 24 * 7 * 4 * 12) + "년 전");
			}
			
		}
		public void ex09() {
			/*
			 * D-Day 계산기를 만들어 보시오.
			 * 	1. 현재 시간보다 과거의 시간을 입력한 경우 "D-Day n일 지남"으로 출력 -> +
			 * 	1. 현재 시간보다 미래의 시간을 입력한 경우 "D-Day n일 남음"으로 출력 -> -
			 */
			SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd"); //미리 정해놓으면 편하다
			GregorianCalendar userInputDay = new GregorianCalendar(2024,2 - 1, 28);
			Date now = new Date();
			
			System.out.println("입력한 날짜 : " + sFormat.format(userInputDay.getTime()));
			System.out.println("현재 날짜 : " + sFormat.format(now));
			//Date      -> long 
			int dDayTime = (int)((now.getTime() - userInputDay.getTime().getTime()) / 1000);
			
			String t = "지남";
			if (dDayTime < 0) {
				t = "남음";
				dDayTime = -dDayTime;
			}
			System.out.printf("D-Day %d일 %s",dDayTime /(60 * 60 * 24),t);
		}
	
	public static void main(String[] args) {
		Sample07 s = new Sample07();
		//s.ex01();
		//s.ex02();
		//s.ex03();
		//s.ex04();
		//s.ex05();
		//s.ex06();
		//s.ex07();
		s.ex08();
		s.ex09();
	
	
	}
}
