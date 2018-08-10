import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BankSim {
	
	public static void main(String[] args) {
		OList<Event> eventList = new OList<Event>();
		Queue2<Customer> customerQueue = new Queue2<Customer>();
		Stack1gen<Task> taskStack = new Stack1gen<Task>();
		PriorityQueue<Customer> PQ = new PriorityQueue<Customer>();
		int currTime = 10, numProcessed = 0, totalTime = 0, tempTime = 0;
		Customer nextCustomer = null;
		Customer nextQuit = new Customer(8, 10, 14, -1, 0);
		Customer Teller1 = new Customer(2, 9, -1, -1, 0);
		Customer Teller2 = new Customer(3, 7, -1, -1, 0);
		Customer Teller3 = new Customer(5, 7, -1, -1, 0);
		Customer Meeting = null;
		Task currentTask = null;
		Task nextTask = new Task(15, 6);
		ArrayList<Customer> customerFile = new ArrayList<Customer>();
		ArrayList<Task> taskFile = new ArrayList<Task>();
		
		customerFile.add(new Customer(15, 6, -1, 25, 10));
		customerFile.add(new Customer(18, 0, -1, 20, 5));
		customerFile.add(new Customer(20, 0, -1, 15, 10));
		customerFile.add(new Customer(25, 6, 30, -1, 0));
		taskFile.add(new Task(15, 6));
		taskFile.add(new Task(24, 10));
		taskStack.push(new Task(10, 5));
		eventList.insert(new Event(10, 2));
		eventList.insert(new Event(11, 1));
		eventList.insert(new Event(12, 3));
		eventList.insert(new Event(12, 7));
		eventList.insert(new Event(14, 4));
		eventList.insert(new Event(15, 6));
		customerQueue.enqueue(new Customer(6, 10, 20, -1, 0));
		customerQueue.enqueue(nextQuit);
		customerQueue.enqueue(new Customer(9, 3, 15, 15, 10));
		
		nextCustomer = customerFile.remove(0);
		while(currTime < 75) {
			while(eventList.getSize()!=0) {
				switch (eventList.getStart().getData().getType()) {
				case 1:
					currTime = eventList.getStart().getData().getTime();
					eventList.del(eventList.getStart().getData());
					tempTime = currTime-Teller1.getTime();
					totalTime += tempTime;
					System.out.println("Customer exits teller 1 with throughtime "+tempTime+", Currtime: "+currTime);
					if(Teller1.getLength() > 0) {
						Teller1.setProcessTime(-1);
						PQ.add(Teller1);
					}
					if(customerQueue.getSize() > 0) {
						Teller1 = customerQueue.dequeue();
					}
					while(customerQueue.getSize() > 0) {
						if(Teller1.getTime()+Teller1.getQuitTime() < currTime) {
							Teller1 = customerQueue.dequeue();
						} else {
							eventList.insert(new Event(currTime+Teller1.getProcessTime(), 1));
							numProcessed++;
							break;
						}
					}
					break;
				case 2:
					currTime = eventList.getStart().getData().getTime();
					eventList.del(eventList.getStart().getData());
					tempTime = currTime-Teller2.getTime();
					totalTime += tempTime;
					System.out.println("Customer exits teller 2 with throughtime "+tempTime+", Currtime: "+currTime);
					if(Teller2.getLength() > 0) {
						Teller2.setProcessTime(-1);
						PQ.add(Teller2);
					}
					if(customerQueue.getSize() > 0) {
						Teller2 = customerQueue.dequeue();
					}
					while(customerQueue.getSize() > 0) {
						if(Teller2.getTime()+Teller2.getQuitTime() < currTime) {
							Teller2 = customerQueue.dequeue();
						} else {
							eventList.insert(new Event(currTime+Teller2.getProcessTime(), 2));
							numProcessed++;
							break;
						}
					}
					break;
				case 3:
					currTime = eventList.getStart().getData().getTime();
					eventList.del(eventList.getStart().getData());
					tempTime = currTime-Teller3.getTime();
					totalTime += tempTime;
					System.out.println("Customer exits teller 3 with throughtime "+tempTime+", Currtime: "+currTime);
					if(Teller3.getLength() > 0) {
						Teller3.setProcessTime(-1);
						PQ.add(Teller3);
					}
					if(taskStack.getSize() > 0) {
						Teller3 = null;
						currentTask = taskStack.pop();
						eventList.insert(new Event(currTime+currentTask.getProcessTime(), 5));
					} else {
						while(customerQueue.getSize() > 0) {
							if(Teller3.getTime()+Teller3.getQuitTime() < currTime) {
								Teller3 = customerQueue.dequeue();
							} else {
								eventList.insert(new Event(currTime+Teller3.getProcessTime(), 3));
								numProcessed++;
								break;
							}
						}
					}
					break;
				case 4:
					currTime = eventList.getStart().getData().getTime();
					eventList.del(eventList.getStart().getData());
					ArrayList<Customer> tempList = new ArrayList<Customer>();
					System.out.println("Customer quits queue, Currtime: "+currTime);
					while(customerQueue.getSize() > 0) {
						tempList.add(customerQueue.dequeue());
					}
					tempList.remove(nextQuit);
					nextQuit.setProcessTime(-1);
					nextQuit.setQuitTime(0);
					if(nextQuit.getLength() > 0) {
						if(Meeting == null) {
							Meeting = nextQuit;
							eventList.insert(new Event(nextQuit.getLength()+currTime, 8));
						} else {
							PQ.add(nextQuit);
						}
					}
					for(Customer c: tempList) {
						if(c.getQuitTime() > nextQuit.getQuitTime()) {
							if(tempList.size() > 0) {
								nextQuit = c;
							} else {
								nextQuit = null;
							}
						}
						customerQueue.enqueue(c);
					}
					if(nextQuit!=null&&nextQuit.getQuitTime() > 0&&nextQuit.getProcessTime() > 0){
						eventList.insert(new Event(nextQuit.getQuitTime()+nextQuit.getTime(), 4));
					}
					break;
				case 5:
					currTime = eventList.getStart().getData().getTime();
					eventList.del(eventList.getStart().getData());
					System.out.println("Task Arrival, Currtime: "+currTime);
					if(taskStack.getSize() > 0 && Teller3 == null) {
						currentTask = taskStack.pop();
						eventList.insert(new Event(currTime+currentTask.getProcessTime(), 5));
					} else {
						while(customerQueue.getSize() > 0) {
							if(Teller3==null||Teller3.getTime()+Teller3.getQuitTime() < currTime) {
								Teller3 = customerQueue.dequeue();
							} else {
								eventList.insert(new Event(currTime+Teller3.getProcessTime(), 3));
								numProcessed++;
								break;
							}
						}
					}
					break;
				case 6:
					currTime = eventList.getStart().getData().getTime();
					eventList.del(eventList.getStart().getData());
					System.out.println("Task Completed, Currtime: "+currTime);
					taskStack.push(nextTask);
					if(taskFile.size() > 0) {
						nextTask = taskFile.remove(0);
						eventList.insert(new Event(nextTask.getTime(), 6));
					}
					break;
				case 7:
					currTime = eventList.getStart().getData().getTime();
					eventList.del(eventList.getStart().getData());
					System.out.println("Customer arrival, Currtime: "+currTime);
					if(nextCustomer.getLength() > 0&&nextCustomer.getApptTime()<currTime) {
						nextCustomer.setApptTime(currTime);
					}
					if(nextCustomer.getLength() > 0 && ((Meeting != null)||(!PQ.isEmpty()))) {
						nextCustomer.setApptTime(Meeting.getApptTime()+Meeting.getLength());
					} else if(nextCustomer.getLength() > 0 && nextCustomer.getProcessTime() <= 0) {
						PQ.add(nextCustomer);
					} else if (nextCustomer.getLength() <= 0 && nextCustomer.getProcessTime() > 0) {
						customerQueue.enqueue(nextCustomer);
						if(nextCustomer.getQuitTime()+nextCustomer.getTime() > nextQuit.getQuitTime()+nextQuit.getTime()) {
							eventList.del(new Event(nextQuit.getQuitTime()+nextQuit.getTime(), 4));
							nextQuit = nextCustomer;
							eventList.insert(new Event(nextQuit.getQuitTime()+nextQuit.getTime(), 4));
						}
					} else if (nextCustomer.getLength() > 0 && nextCustomer.getProcessTime() > 0) {
						nextCustomer.setQuitTime(nextCustomer.getApptTime());
						if(customerQueue.getSize() == 0) {
							if(Teller1 == null) {
								Teller1 = nextCustomer;
								eventList.insert(new Event(nextCustomer.getProcessTime()+currTime, 1));
							}
							else if(Teller2 == null) {
								Teller2 = nextCustomer;
								eventList.insert(new Event(nextCustomer.getProcessTime()+currTime, 2));
							}
							else if(Teller3 == null) {
								Teller3 = nextCustomer;
								eventList.insert(new Event(nextCustomer.getProcessTime()+currTime, 3));
							}
						} else {
							nextCustomer.setQuitTime(nextCustomer.getApptTime());
							customerQueue.enqueue(nextCustomer);
							if(nextCustomer.getQuitTime()+nextCustomer.getTime() > nextQuit.getQuitTime()+nextQuit.getTime()) {
								eventList.del(new Event(nextQuit.getQuitTime()+nextQuit.getTime(), 4));
								nextQuit = nextCustomer;
								eventList.insert(new Event(nextQuit.getQuitTime()+nextQuit.getTime(), 4));
							}
						}
					}
					if(customerFile.size() > 0) {
						nextCustomer = customerFile.remove(0);
						eventList.insert(new Event(nextCustomer.getTime(), 7));
					}
					break;
				case 8:
					currTime = eventList.getStart().getData().getTime();
					eventList.del(eventList.getStart().getData());
					System.out.println("Meeting exit, Currtime: "+currTime);
					if(Meeting.getQuitTime() <= 0) {
						tempTime = currTime-Meeting.getTime();
						totalTime += tempTime;
						System.out.println("Customer leaves with through time "+tempTime);
						numProcessed++;
					}
					else {
						customerQueue.enqueue(Meeting);
					}
					if(!PQ.isEmpty()) {
						Meeting = PQ.poll();
						eventList.insert(new Event(Meeting.getLength()+currTime, 8));
					} else {
						Meeting = null;
					}
				}
			}
			
		}
		System.out.println("Total Time: "+totalTime+"\nCustomers Processed: "+numProcessed);
	}
}
