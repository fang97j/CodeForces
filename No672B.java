import java.io.*;
import java.util.*;

public class No672B {
  public static void main (String [] args) throws IOException {
    No672B program = new No672B();
    program.solve();
    
  }
  
  public void solve() throws IOException {
    /*Scanner sc = null;
    try {
      sc = new Scanner(new File("C:/Users/John/workspace/USACO/src/input.txt"));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }*/
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    
    if (n > 26) {
      System.out.println("-1");
      return;
    }
    
    String s = sc.next();
    Map<Character, Integer> histogram = new HashMap<Character, Integer>();
    for (char c = 'a'; c <= 'z'; c++) {
      histogram.put(c, 0);
    }
    
    for (char c : s.toCharArray()) {
      histogram.put(c, histogram.get(c) + 1);
    }
    
    int changes = 0;
    for (char c : histogram.keySet()) {
      int frequency = histogram.get(c); 
      if (frequency > 0) {
        changes += frequency - 1;
      }
    }
    System.out.println(changes);
  }
}