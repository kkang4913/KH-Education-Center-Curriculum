package model.vo;

public class Grade extends Subject {
	private double scoer;
	private char level;
	
	
	
	public Grade(String name) {
		super(name);
	}
	public Grade(String name, double score) {
		super(name);
		this.scoer = score;
	}
	
	
	
	public double getScoer() {
		return scoer;
	}
	public void setScoer(double scoer) {
		this.scoer = scoer;
	}
	public char getLevel() {
		return level;
	}
	public void setLevel(char level) {
		this.level = level;
	}
	
	
	
}
