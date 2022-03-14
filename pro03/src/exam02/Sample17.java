package exam02;

import java.util.Random;
import java.util.Scanner;

public class Sample17 {
	public static void main(String[] args) {
		System.out.println("========강사님 코드 ========");

		Scanner sc = new Scanner(System.in);
		Random rd = new Random(); 
		String name, player, sCom = "";
		int computer = 0;
		int result = 0;
		int count = 0,win = 0,same = 0,lose = 0;
		
		System.out.print("당신의 이름을 입력하세요. : ");
		name = sc.nextLine();

		for (;;) {
			System.out.print("가위 바위 보 입력 : "); // 반복해서 입력해야하는 구문
			player = sc.nextLine(); 			  // 반복의 횟수는 x, "exit" 값이 입력되면 종료
			computer = rd.nextInt(3);			  // 0(가위), 1(바위) 2(보)
			
			if (computer == 0) {
				sCom =  "가위";
			}else if (computer ==1) {
				sCom =  "바위";
			}else if (computer ==2) {
				sCom =  "보";
			}
			
			if (player.equals("exit")) {                    // 종료 조건
				System.out.println("=======게임 종료=======");
				System.out.printf("%d전%d승%d무%d패\n",count, win, same ,lose);
				break;
			} else if (player.equals("가위") || player.equals("바위") || player.equals("보")) {//가위바우보 승리 패 비김 조건
				System.out.println("컴퓨터 : " + sCom);
				System.out.println(name + " : " + player);
				count++;
				// result = 0; //비긴경우에는 굳이 아래의 if문에 들어갈 필요가 없다?  -> 이겼다, 졌다 정도만 조건으로
				if (player.equals("가위")) {
					if (computer == 0) {
						result = 0;
					}else if (computer ==1) {
						result = -1;
					}else if (computer ==2) {
						result = 1;
					}	
				}else if (player.equals("바위")) {
					if (computer ==0) {
						result = 1;
					}else if (computer ==1) {
						result = 0;
					}else if (computer ==2) {
						result = -1;
					}
				}else if (player.equals("보")) {
					if (computer ==0) {
						result = -1;
					}else if (computer ==1) {
						result = 1;
					}else if (computer ==2) {
						result = 0;
					}
				}
				switch (result) {
				case -1:
					System.out.println("졌습니다");
					lose++; break;
				case 0:
					System.out.println("비겼습니다.");
					same++; break;
				case 1:
					System.out.println("이겼습니다.");
					win++; break;
				}
				}else {
					System.out.println("잘못 입력했습니다. 다시 입력하세요.");
			} 
			}
			}
		}
