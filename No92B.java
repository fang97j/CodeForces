import java.io.*;
import java.util.*;

public class No92B {
  public static void main (String [] args) throws IOException {
    No92B program = new No92B();
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
    String s = sc.nextLine();
    
    char[] ca = s.toCharArray();
    
    int r = ca.length - 1;
    int moves = 0;
    
    while (r > 0){
      // sequence of 0's
      if (ca[r] == '0'){
        int l = r;
        while (l - 1 >= 0 && ca[l - 1] == '0') {
          l--;
        }
        int length = r - l + 1;
        r = l - 1;
        moves += length;
      }
      // sequence of 1's
      else {
        int l = r;
        while (l - 1 >= 0 && ca[l - 1] == '1') {
          l--;
        }
        int length = r - l + 1;
        r = l - 1;
        moves += length + 1;
        
        if (r >= 0){
          ca[r] = '1';
        }
      }
    }
    System.out.println(moves);
  }
}