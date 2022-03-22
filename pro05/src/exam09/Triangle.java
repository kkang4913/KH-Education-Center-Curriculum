package exam09;

public class Triangle {
	private int side;
	private int round;
	
	public Triangle(int side) {
		this.side =side;
		_round();	
		}


	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
		_round();
	}

	public int getRound() {
		return round;
	
	}
	
	public void _round() {
		round = side *3;
	}
	
	
	
	
}

