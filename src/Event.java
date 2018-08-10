
public class Event implements Comparable<Event> {
	private int type;
	private int time;
	
	public Event(int i, int t) {
		type = t;
		time = i;
	}
	
	public int getType() {
		return type;
	}
	public int getTime() {
		return time;
	}
	
	public void setType(int t) {
		type = t;
	}
	public void setTime(int i) {
		time = i;
	}
	
	public int compareTo(Event e) {
		int temp = time-e.getTime();
		if (temp == 0) {
			return type-e.getType();
		}
		return time-e.getTime();
	}
	
	public String printVal() {
		return "Time: "+time+"  Type: "+type;
	}
	
	public String toString() {
		return "Time: "+time+"  Type: "+type;
	}
}
