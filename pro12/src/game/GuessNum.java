package game;

import java.util.Random;

public class GuessNum {
	private Random rand = new Random();
	private int number;
	private int limitCnt =10;
	
	//임의의 숫자
	public GuessNum() {
		this.number = rand.nextInt(100) + 1;
	}
	//임의의 숫자 최대값
	public GuessNum(int rangeMax) {
		this.number = rand.nextInt(rangeMax) + 1;
	}
	//임의의 숫자 최대값 / 횟수 설정
	public GuessNum(int rangeMax, int count) {
		this.number = rand.nextInt(rangeMax) + 1;
		this.limitCnt = count;
	}
	//임의의 숫자 최대값 / 횟수 설정
	public GuessNum(int rangeMin, int rangeMax, int count) {
		this.number = rand.nextInt(rangeMax -rangeMin) + ( rangeMin) + 1;
		this.limitCnt = count;

	}
	
	public Result guessing(int num) {
		Result res = new Fail();
		this.limitCnt--;
		if (this.limitCnt > 0) {
			if (this.number > num) {
				res = new Up();
			}else if (this.number < num) {
				res = new Down();
			}else if (this.number == num) {
				res = new Correct();
			}
		}else if (this.limitCnt ==0) {
			if (this.number == num) {
				res = new Correct();
			}
		}
		return res;
	}
	
}
