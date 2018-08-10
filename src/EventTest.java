
public class EventTest {

	public static void main(String[] args) {
		OList<Event> eventList = new OList();
		eventList.insert(new Event(10, 3));
		eventList.insert(new Event(0, 5));
		eventList.insert(new Event(50, 7));
		eventList.insert(new Event(60, 3));
		eventList.insert(new Event(60, 5));
		eventList.insert(new Event(10, 1));
		eventList.insert(new Event(10, 5));
		eventList.printList();
	}

}
