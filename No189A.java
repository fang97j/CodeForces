package Solved;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class No189A {

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
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    int[] solutions = new int[n + 1];
    ArrayList<Integer> values = new ArrayList<>(Arrays.asList(a, b, c));
    for (Integer value : values) { 
      if (value <= n)
        solutions[value] = 1;
    }
    
    for (int i = 0; i < n + 1; i++) {
      int max = solutions[i];
      for (Integer value : values) {
        if (i - value >= 0 && solutions[i - value] != 0)
          max = Math.max(max, solutions[i - value] + 1);
      }
      solutions[i] = max;
    }
    System.out.println(solutions[n]);
  }
}
