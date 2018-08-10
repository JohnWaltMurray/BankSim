

public class OList<T extends Comparable> {
	private Node2<T> start;
	private int size;
	
	public OList() {
		start = null;
		size = 0;
	}
	
	public OList(OList L) {
		Node2<T> curr = L.getStart();
		T item = curr.getData();
		size = L.getSize();
		start = new Node2(item, null);
		Node2<T> save = start;
		Node2<T> newNode = null;
		for(int i=1; i<=size-1; i++) {
			curr = curr.getLink();
			item = curr.getData();
			newNode = new Node2(item, null);
			save.setLink(newNode);
			save = newNode;
		}
	}
	
	public void insert(T y) {
		Node2<T> curr = null;
		Node2<T> save = null;
		Node2<T> newNode = null;
		
		curr = start;
		while((curr != null) && (curr.getData().compareTo(y)<0)) {
			save = curr;
			curr = curr.getLink();
		}
		newNode = new Node2(y,curr);
		
		if(curr == start) {
			start = newNode;
		} else {
			save.setLink(newNode);
		}
		size++;
	}
	
	public void del(T y) {
		Node2<T> curr = null;
		Node2<T> save = null;
		
		curr = start;
		while((curr != null) && (curr.getData().compareTo(y) != 0)) {
			save = curr;
			curr = curr.getLink();
		}
		
		if(curr == null) {
			System.out.println("No deletion: " + y + " not on list.");
		} else {
			size--;
			if(curr == start) {
				start = curr.getLink();
			} else {
				save.setLink(curr.getLink());
			}
		}
	}
	
	public void printListBasic() {
		Node2<T> curr = start;
		System.out.println("List contents: ");
		while(curr != null) {
			T out = curr.getData();
			System.out.println(out);;
			curr = curr.getLink();
		}
		System.out.println(" ");
	}
	
	public void printList() {
		Node2<T> curr = start;
		System.out.println("List contents: ");
		while(curr != null) {
			T out = curr.getData();
			System.out.println(out.toString()); // Changed this to use toString instead since we did not have the PrintValue interface in class
			curr = curr.getLink();
		}
		System.out.println(" ");
	}
	
	public int getSize() {
		return size;
	}
	
	public Node2<T> getStart() {
		return start;
	}
	
	public T getData(int i) {
		Node2<T> curr = start;
		for(int j=1; j<i; j++) {
			curr = curr.getLink();
		}
		return curr.getData();
	}
}
