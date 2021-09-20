
public class BinOperations {

	public static boolean andGate(boolean a,boolean b) {
		if(a&&b)
			return true;
		else 
			return false;

	}
	public static boolean orGate(boolean a,boolean b) {
		if(a||b)
			return true;
		else 
			return false;

	}
	public static boolean notGate(boolean x) {
		return !x;
	}
	public static boolean xorGate(boolean a,boolean b) {
		if((!a&&b)||(a&&!b))
			return true;
		else 
			return false;

	}
	public static int bin2Int( boolean[] x) {
		int num=0;  
		for(int i=0; i < x.length; i++)
			if(x[i] == true)  
				num += Math.pow(2, x.length-i-1);
		return num;

	}
	public static boolean[] int2Bin(int num ,int n) {
		boolean[] x = new boolean[n];
		for(int i=0; i<n; i++)
			x[i] = false;
		for(int i=n-1; num !=0; i--) {
			if(num%2==0)
				x[i]= false;
			else
				x[i]= true;
			num /= 2;		
		}
		return x;
	}
}
