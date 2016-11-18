package Solved;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class No405A {

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
    ArrayList<Integer> columns = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      columns.add(sc.nextInt());
    }
    Collections.sort(columns);
    for (int i = 0; i < n; i++) {
      System.out.print(columns.get(i) + " ");
    }
  }
}
