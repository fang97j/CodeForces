import java.io.*;
import java.util.*;

public class No267A {
  public static void main (String [] args) throws IOException {
    No267A program = new No267A();
    program.solve();
    
  }
  
  public void solve() throws IOException {
    /*Scanner sc = null;
    try {
      sc = new Scanner(new File("C:/Users/John/workspace/CodeForces/src/input.txt"));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }*/
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      
      long steps = numOperations(a, b);
      System.out.println(steps);
    }
  }
  
  long numOperations(int a, int b) {
    long steps = 0;
    while (a > 0 && b > 0) {
      if (a == b) {
        steps++;
        break;
      }
      else {
        int l = Math.max(a, b);
        int s = Math.min(a, b);
        
        steps += Math.floor(l / s);
        a = l % s;
        b = s;
      }
    }
    return steps;
  }
}