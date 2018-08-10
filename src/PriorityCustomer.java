
public class PriorityCustomer implements Comparable<PriorityCustomer>  {

	private int time;
	private int process;
	private int quit;
	private int apptTime;
	private int apptProcess;
	
	public PriorityCustomer(int t, int p, int q, int aT, int aP) {
		time = t;
		process = p;
		quit = q;
		setApptTime(aT);
		setApptProcess(aP);
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
	
	public void setTime(int t) {
		time = t;
	}
	
	public void setProcessTime(int p) {
		process = p;
	}
	
	public void setQuitTime(int q) {
		quit = q;
	}
	
	public String printVal() {
		return "Arrival Time: "+time+"  Process Time: "+process+"  Quit Time: "+quit;
	}
	
	public String toString() {
		return "\nArrival Time: "+time+"  Process Time: "+process+"  Quit Time: "+quit+"  Appointment Time: "+apptTime+"  Appointment Service Time: "+apptProcess;
	}

	public int compareTo(PriorityCustomer c) {
		int temp = apptTime-c.getApptTime();
		if (temp == 0) {
			return 0;
		} else if (temp > 0) {
			return 1;
		}
		return -1;
	}

	public int getApptProcess() {
		return apptProcess;
	}

	public void setApptProcess(int apptProcess) {
		this.apptProcess = apptProcess;
	}

	public int getApptTime() {
		return apptTime;
	}

	public void setApptTime(int apptTime) {
		this.apptTime = apptTime;
	}
}
