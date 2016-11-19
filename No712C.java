import java.io.*;
import java.util.*;

public class No712C {
  public static void main (String [] args) throws IOException {
    No712C program = new No712C();
    program.solve();
    
  }
  
  int x;
  int y;
  
  public void solve() throws IOException {
    /*Scanner sc = null;
    try {
      sc = new Scanner(new File("C:/Users/John/workspace/CodeForces/src/input.txt"));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }*/
    Scanner sc = new Scanner(System.in);
    x = sc.nextInt();
    y = sc.nextInt();
    
    int[] triangle = new int[] {y, y, y};
    int steps = 0;

    while(triangle[0] != x || triangle[1] != x  || triangle[2] != x) {
      int minIndex = minIndex(triangle);
      
      int cap = triangle[0] + triangle[1] + triangle[2] - triangle[minIndex];
      triangle[minIndex] = Math.min(x, cap - 1);
      
      steps++;
    }
    System.out.println(steps);
  }
  
  int minIndex(int[] triangle) {
    int minIndex = 0;
    int minVal = Integer.MAX_VALUE;
    for (int i = 0; i < 3; i++) {
      if (triangle[i] < minVal) {
        minIndex = i;
        minVal = triangle[i];
      }
    }
    return minIndex;
  }
}