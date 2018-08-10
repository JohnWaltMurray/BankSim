import java.util.Scanner;

public class Qtest
{
  public static void main(String[] args)
  {
    Queue2<Integer>  a = new Queue2<Integer>();
    a.enqueue(33);
    a.enqueue(4);
    a.enqueue(17);
    a.enqueue(2);
    a.printQ();
    System.out.println("front:" + a.dequeue());
    a.printQ();
    Queue2<String> b = new Queue2<String>();
    b.enqueue("happy days are here again");
    b.enqueue("rise and shine");
    b.enqueue("once in a blue moon");
    b.enqueue("the bear crossed over the mountain");
    b.printQ();
    System.out.println("front:" + b.dequeue());
    b.printQ();
    a.reverseQ();
    a.printQ();
    Queue2<Integer> c = new Queue2<Integer>();
    c.enqueue(55);
    c.enqueue(77);
    Queue2.shift(c,3,a);
    c.printQ();

  }
}
