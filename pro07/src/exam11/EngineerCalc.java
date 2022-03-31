package exam11;

public class EngineerCalc extends Calculator implements ScientificOp {

	@Override
	public int mod(int n1, int n2) {
		// TODO Auto-generated method stub
		return n1 %n2;
	}

	@Override
	public int sqrd(int n1, int n2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int abs(int n1) {
		// TODO Auto-generated method stub
		return -n1;
	}

	@Override
	public double abs(double n1) {
		// TODO Auto-generated method stub
		return -n1;
	}

}
