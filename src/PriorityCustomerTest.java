import java.util.ArrayList;
import java.util.PriorityQueue;


public class PriorityCustomerTest {

	public static void main(String[] args) {
		ArrayList<PriorityCustomer> custData = new ArrayList<PriorityCustomer>();
		custData.add(new PriorityCustomer(5, 25, 10, 10, 10));
		custData.add(new PriorityCustomer(15, 20, 10, 20, 15));
		custData.add(new PriorityCustomer(25, 20, 10, 35, 5));
		custData.add(new PriorityCustomer(30, 20, 10, 45, 10));
		custData.add(new PriorityCustomer(0, 20, 10, 0, 10));
		custData.add(new PriorityCustomer(45, 20, 10, 55, 5));
		
		PriorityQueue<PriorityCustomer> priorityTest = new PriorityQueue<PriorityCustomer>(custData);
		while(!priorityTest.isEmpty()) {
			System.out.println(priorityTest.poll());
		}
	}

}
