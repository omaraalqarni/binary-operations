
public class intAdder {
	int A,B,S;
	boolean Cin,Cout;
	fullAdder[] Adders= null;
	
	
	public intAdder(int n) {
		Adders= new fullAdder[n];
		for(int i=0; i<n; i++) 
			Adders[i]= new fullAdder();
		Adders[n-1].setCin(false);
	}
	public  int getA() {
		return A;
	}

	public  void setA(int a) {
		A = a;
	}

	public  int getB() {
		return B;
	}

	public  void setB(int b) {
		B = b;
	}

	public boolean getCin() {
		return Cin;
	}

	public void setCin(boolean cin) {
		Cin = cin;
	}
	public boolean getCout() {
		return Cout;
	}
	public  int getS() {
		return S;
	}
	public  void add() {
		boolean[] a= BinOperations.int2Bin(A,Adders.length);  
		boolean[] b= BinOperations.int2Bin(B,Adders.length);
		boolean[] Sum= new boolean [Adders.length];
		for(int i = Adders.length-1;i>=0;i--) {
			Adders[i].setA(a[i]);
			Adders[i].setB(b[i]);
			if( i < Adders.length-1)
				Adders[i].setCin(Adders[i+1].getCout());
			Adders[i].run();

			Sum[i]= Adders[i].getS();
		}
		Cout = Adders[0].getCout();
		S= BinOperations.bin2Int(Sum);
	}

}
