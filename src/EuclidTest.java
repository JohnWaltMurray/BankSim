
public class EuclidTest {
	public static void main(String[] args) {
		EuclidRec euclid = new EuclidRec();
		System.out.println("n	A(n)	A(n)/log2(n)		E(n)	E(n)/log2(n)");
		for(int n = 50; n <=150; n++) {
			int experimental = euclid.experimentalRuntime(n);
			int average =  euclid.avgRuntime(n);
			System.out.println(n+"\t"+average
					+"\t"+(((double)average)/(Math.log10(n)/Math.log10(2)))
					+"\t"+experimental
					+"\t"+(((double)experimental)/(Math.log10(n)/Math.log10(2))));
		}
	}
}
