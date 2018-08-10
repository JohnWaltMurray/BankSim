//Queue2.java: link implementation

public class Queue2<T>
{
  private Node2<T> front;
  private Node2<T> back;
  private int size;

  //constructor
  public Queue2()
  {
    front = null;
    back = null;
    size = 0;
  }

  //member methods
  public void enqueue(T y)
  {
    Node2 newnode = new Node2(y, null);
    assert(newnode != null);
    size ++;
    if(back == null)
    {
      front = newnode;
      back = newnode;
    }
    else
    {
      back.setLink(newnode);
      back = newnode;
    }
  }

  public T dequeue()
  {
    assert(front != null);
    T dq = front.getData();
    Node2 save = front.getLink();
    front = save;
    size --;
    if(size == 0)
    {
       back = null;
    }
    return dq;
  }
  
  public T dequeue(Customer c)
  {
    assert(front != null);
    T dq = front.getData();
    Node2 save = front.getLink();
    front = save;
    size --;
    if(size == 0)
    {
       back = null;
    }
    return dq;
  }

  public int getSize()
  {
    return size;
  }

  public T getFrontData()
  {
    return front.getData();
  }

  public void printQ()
  {
    Node2 curr = front;
    if(front == null)
    {
      System.out.println("queue is empty");
      return;
    }
    while(curr != null)
    {
      System.out.println(curr.getData());
      curr = curr.getLink();
    }
    System.out.println("  ");
  }

// public Node2 getFront()

// public Node2 getBack()

// public void setFront(Node2 newfront)

// public void setBack(Node2 newback)

   public void reverseQ() //reverse the order of the elements
   {
     Stack1gen<T> s = new Stack1gen<T>();
     while(size > 0)
     {
       s.push(dequeue());
     }
     while(s.getSize()>0)
     {
       enqueue(s.pop());
     }
   }

   public static void shift(Queue2 A, int n, Queue2 B)
   //A must be nonempty; keep the first n elements of A (n >= 0);
   //shift the remaining elements of A to the rear of B,
   //keeping the same order.
   {
     //dummy code
     A.dequeue();
   }

//Exercise: Give a new implementation of reverse(), which does not
//use stacks, enqueue(), or dequeue(), but just uses the shift() method. 

}
