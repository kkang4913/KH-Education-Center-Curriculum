package exam11;

public class ProgrammerCalc extends Calculator implements ProgrammerOp {

	@Override
	public String binary(int n1) {
		// TODO Auto-generated method stub
		return "2진수";
	}

	@Override
	public String octal(int n1) {
		// TODO Auto-generated method stub
		return "8진수";
	}

	@Override
	public String hexa(int n1) {
		// TODO Auto-generated method stub
		return "16진수";
	}

	@Override
	public int binaryToDecimal(String binary) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int octalToDecimal(String octal) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int hexaToDecimal(String hexa) {
		// TODO Auto-generated method stub
		return 0;
	}

}
