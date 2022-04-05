package model.vo;

public class Grade extends Subject {
	private double score;
	private char level;
	private char[] levelArr = new char[] {'F','F','F','F','E','E','D','C','B','A','A'};
	
	
	

	public Grade(String name) {
		super(name);
		this.level ='F';
	}
	
	

	public Grade(String name, double score) {
		super(name);
		this.score = score;
	}
	
	
	public double getScoer() {
		return score;
	}
	public void setScoer(double scoer) {
		this.score = scoer;
		this.level = this.levelArr[(int)(this.score /10)];
		
//		if(score <= 100 && score >= 90) {
//			this.level = 'A';
//		}else if(score < 90 && score >= 80) {
//			this.level = 'B';
//		}else if(score < 80 && score >= 70) {
//			this.level = 'C';
//		}else if(score < 70 && score >= 60) {
//			this.level = 'D';
//		}else if(score < 60 && score >= 50) {
//			this.level = 'E';
//		}else if(score < 40) {
//			this.level = 'F';
//		}
	}
	public char getLevel() {
		
		return level;
	}
	public void setLevel(char level) {
		 
	}
	
	
	
}
