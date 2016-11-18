package Solved;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class No599A {

  public static void main(String[] args) {
    /*Scanner sc = null;
    try {
      sc = new Scanner(new File("C:/Users/John/workspace/CodeForces/src/input.txt"));
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }*/
    Scanner sc = new Scanner(System.in);
    int d1 = sc.nextInt();
    int d2 = sc.nextInt();
    int d3 = sc.nextInt();
    int distance = Math.min(d1, d2) + Math.min(d1 + d2, d3);
    // Took d1 first
    if (d1 < d2) {
      distance += Math.min(d2, d1 + d3);
    }
    // Took d2 first
    else {
      distance += Math.min(d1, d2 + d3);
    }
    System.out.println(distance);
  }
}
