import java.util.Scanner;

public class Stack1genTest
{
 public static void main(String[] args)
 {
  Stack1gen<Integer> s = new Stack1gen<Integer>();
  s.push(2);
  s.push(5);
  s.push(17);
  s.push(24);
  System.out.println(s.pop());
  s.push(3);
  int j = s.getSize();
  for(int k = 1; k<=j; k++)
  {
    System.out.println(s.pop());
  }
  Stack1gen<Double> f = new Stack1gen<Double>();
  f.push(3.14159);
  f.push(0.001);
  f.push(2.0);
  f.pop();
  f.push(1.234);
  f.push(5.678);
  j = f.getSize();
  for(int k = 1; k<=j; k++)
  {
    System.out.println(f.pop());
  }
 }
}
