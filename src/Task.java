
public class Task {

	private int time;
	private int process;
	
	public Task(int t, int p) {
		time = t;
		process = p;
	}
	
	public int getTime() {
		return time;
	}
	
	public int getProcessTime()  {
		return process;
	}
	
	public void setTime(int t) {
		time = t;
	}
	
	public void setProcessTime(int p) {
		process = p;
	}
}
