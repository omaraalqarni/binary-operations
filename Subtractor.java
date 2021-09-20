
public class Subtractor {
	intAdder addition;
	public Subtractor(int n) {
		addition= new intAdder(n);
		//we set Cin to 1 for the 1`complement addition
		addition.Adders[n-1].setCin(true);
	}
	public  int getA() {
		return addition.getA();
	}
	public  void setA(int a) {
		addition.setA(a);
	}
	public  int getB() {
		return addition.getB();
	}
	public  void setB(int b) {
		addition.setB(b);
	}
	public boolean getCin() {
		return addition.getCin();
	}
	public void setCin(boolean cin) {
		addition.setCin(cin);
	}
	public boolean getCout() {
		return addition.getCout();
	}
	public  int getS() {
		return addition.getS();
	}
	public void substract() {
		
		boolean[] complement = BinOperations.int2Bin(getB(), addition.Adders.length);
		//we take the 1`s complement by sending b to notGate
		for(int i=0; i< complement.length; i++)
			complement[i]= BinOperations.notGate(complement[i]);
		setB(BinOperations.bin2Int(complement));
		addition.add();
		//if the Cout is 0 it takes the 2`s complement and return the number negative 
		if(addition.Cout == false) {
			boolean[] x = BinOperations.int2Bin(addition.getS(), addition.Adders.length);
			for(int i=0; i< x.length; i++)
				x[i]= BinOperations.notGate(x[i]);
			intAdder resultComp= new intAdder(complement.length);
			resultComp.setA(BinOperations.bin2Int(x));
			resultComp.setB(1);
			resultComp.add();
			addition.S = -1*resultComp.getS();
		}			
	}

}
