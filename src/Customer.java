
public class Customer implements Comparable<Customer>  {

	private int time;
	private int process;
	private int quit;
	private int apptTime;
	private int length;
	private boolean completedTeller = false;
	
	public Customer(int t, int p, int q, int a, int l) {
		time = t;
		process = p;
		quit = q;
		setApptTime(a);
		setLength(l);
	}
	
	public int getTime() {
		return time;
	}
	
	public int getProcessTime()  {
		return process;
	}
	
	public int getQuitTime() {
		return quit;
	}
	
	public boolean getCompleted() {
		return completedTeller;
	}
	
	public void setTime(int t) {
		time = t;
	}
	
	public void setProcessTime(int p) {
		process = p;
	}
	
	public void setQuitTime(int q) {
		quit = q;
	}
	public void setCompleted() {
		completedTeller = true;
	}
	
	public String printVal() {
		return "Arrival Time: "+time+"  Process Time: "+process+"  Quit Time: "+quit;
	}
	
	public String toString() {
		return "Arrival Time: "+time+"  Process Time: "+process+"  Quit Time: "+quit;
	}

	public int compareTo(Customer c) {
		if(process <= 0) {
			return apptTime-c.getApptTime();
		}
		int temp = time-c.getTime();
		if (temp == 0) {
			return process-c.getProcessTime();
		}
		return time-c.getTime();
	}

	public int getApptTime() {
		return apptTime;
	}

	public void setApptTime(int apptTime) {
		this.apptTime = apptTime;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
}
