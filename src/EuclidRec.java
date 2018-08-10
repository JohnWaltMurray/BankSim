
public class EuclidRec {

	private int stepCounter = 0;

	public int GCD(int n, int m) {
		stepCounter++;			//Runtime counted in number of calls to GCD.
		if(n == 0) {
			return m;
		} else if (m == 0) {
			return n;
		}
		return GCD(m,n%m);
	}
	public int avgRuntime(int n) {
		for(int i = 0; i < n; i++) {
			GCD(n, i);
		}
		int temp = stepCounter;
		stepCounter = 0;
		return temp/(n+1);
	}
	
	public int experimentalRuntime(int n) {
		for(int i = 0; i < 10; i++) {
			GCD(n, (int)(Math.random()*n));
		}
		int temp = stepCounter;
		stepCounter = 0;
		return temp/10;
	}
}
