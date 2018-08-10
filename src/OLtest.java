
public class OLtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OList<Integer> L = new OList();
		L.insert(55);
		L.insert(2);
		L.insert(34);
		L.insert(56);
		L.insert(-3);
		
		System.out.println("Printing L. . .");
		L.printListBasic();
		
		OList<Integer> M = new OList(L);
		
		OList<Integer> P = L;
		
		L.del(-3);
		L.del(55);
		
		System.out.println("Deleting values -3 and 55 then printing L. . .");
		L.printListBasic();
		System.out.println("Printing M. . .");
		M.printListBasic();
		System.out.println("Printing P. . .");
		P.printListBasic();
		
		System.out.println("Deleting M's 3rd element and printing. . .");
		M.del(M.getData(3));
		M.printListBasic();
		
		System.out.println("Creating OList N and printing. . .");
		OList<Double> N = new OList();
		N.insert(3.14159);
		N.insert(-12.2);
		N.insert(22.2);
		N.insert(6.2);
		N.insert(-13.1);
		N.printListBasic();
		
		System.out.println("Adding 20 to N's 4th element and replacing. . .");
		Double temp = N.getData(4);
		N.del(N.getData(4));
		N.insert(temp+20);
		N.printListBasic();
		
		System.out.println("Creating OList Q and printing. . .");
		OList<String> Q = new OList();
		Q.insert("an apple a day");
		Q.insert("keeps the doctor away");
		Q.insert("ZZZ");
		Q.insert(" keeps the doctor away");
		Q.insert("aZa");
		Q.insert("ZaZ");
		Q.printListBasic();
		
		System.out.println("Deleting string \"ZZZ\" from Q and printing. . .");
		Q.del("ZZZ");
		Q.printListBasic();
		
		System.out.println("Concatenating two of Q's values and printing. . .");
		Q.insert(Q.getData(4)+Q.getData(0));
		Q.del("an apple a day");
		Q.del(" keeps the doctor away");
		Q.printListBasic();
	}

}
