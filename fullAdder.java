
public class fullAdder {

	private boolean A, B, Cin, S, Cout;

	public boolean getA() {
		return A;
	}

	public void setA(boolean a) {
		A = a;
	}

	public boolean getB() {
		return B;
	}

	public void setB(boolean b) {
		B = b;
	}

	public boolean getCin() {
		return Cin;
	}

	public void setCin(boolean cin) {
		Cin = cin;
	}

	public boolean getS() {
		return S;
	}


	public boolean getCout() {
		return Cout;
	}
	public void run() {
		this.S = BinOperations.xorGate(BinOperations.xorGate(A, B),Cin);
		this.Cout = BinOperations.orGate(BinOperations.andGate(A, B),BinOperations.andGate(Cin,BinOperations.xorGate(A,B)));
	}


	

}
