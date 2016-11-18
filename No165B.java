package Solved;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class No165B {

  public static void main(String[] args) {
    /*Scanner sc = null;
    try {
      sc = new Scanner(new File("C:/Users/John/workspace/CodeForces/src/input.txt"));
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }*/
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    int hi = n;
    int lo = 1;
    int mid = 1;
    while (lo < hi) {
      mid = lo + (hi - lo) / 2;
      if (finishes(mid, n, k)) 
        hi = mid;
      else 
        lo = mid + 1;
    }
    System.out.println(lo);
  }
  
  static boolean finishes(int v, int n, int k) {
    int lines = v;
    while (v / k > 0) {
      lines += v/k;
      v /= k;
    }
    return lines >= n;
  }
}
 