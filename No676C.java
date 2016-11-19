import java.io.*;
import java.util.*;

public class No676C {
  public static void main (String [] args) throws IOException {
    No676C program = new No676C();
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
    int k = sc.nextInt();
    String s = sc.next();
    char[] ca = s.toCharArray();

    int maxBeauty = Integer.MIN_VALUE;
    
    List<Segment> A = new ArrayList<Segment>(); // a's are free, b's aren't
    List<Segment> B = new ArrayList<Segment>(); // b's are free, a's aren't
    
    A.add(new Segment(0, 0));
    A.add(new Segment(0, 0));
    B.add(new Segment(0, 0));
    B.add(new Segment(0, 0));
    
    int maxCostA = 0;
    int maxCostB = 0;
    
    int numAs = 0;
    int numBs = 0;
    
    for (char c : ca) {
      if (c == 'a') {
        // deal with A
        A.get(A.size() - 1).beauty++;
        
        // deal with B
        Segment last = B.get(B.size() - 1);
        B.add(new Segment(last.beauty + 1, last.cost + 1));
        B.add(new Segment(last.beauty + 1, last.cost + 1));
        maxCostB++;
        
        numAs++;
      }
      else {
        // deal with A
        Segment last = A.get(A.size() - 1);
        A.add(new Segment(last.beauty + 1, last.cost + 1));
        A.add(new Segment(last.beauty + 1, last.cost + 1));
        maxCostA++;
        
        // deal with B
        B.get(B.size() - 1).beauty++;
        
        numBs++;
      }
    }
    
    for (int i = 0; i < A.size(); i+= 2) {
      maxBeauty = Math.max(maxBeauty, A.get(i + 1).beauty - A.get(i).beauty);
    }
    for (int i = 0; i < B.size(); i+= 2) {
      maxBeauty = Math.max(maxBeauty, B.get(i + 1).beauty - B.get(i).beauty);
    }
    
    /*
    System.out.println("A: ");
    for (Segment a : A) {
      System.out.print("[" + a.beauty + ", " + a.cost + "] ");
    }

    System.out.println("\nB: ");
    for (Segment b : B) {
      System.out.print("[" + b.beauty + ", " + b.cost + "] ");
    }

    System.out.println("\n" + maxCostA);
    System.out.println(maxCostB);
    
    System.out.println("k is " + k);
    */
    
    // look for the best if a's are free
    int numReplaced = Math.min(numBs, k);
    for (int startCost = 0, endCost = startCost + numReplaced; endCost <= maxCostA; startCost++, endCost++) {
      //System.out.println("A: lowest beauty for " + startCost + " is " + findLowestBeauty(A, startCost));
      //System.out.println("A: higher beauty for " + endCost + " is " + findHighestBeauty(A, endCost));

      int diff = findHighestBeauty(A, endCost) - findLowestBeauty(A, startCost);
      maxBeauty = Math.max(maxBeauty, diff);
    }
    // look for the best if b's are free
    numReplaced = Math.min(numAs, k);
    for (int startCost = 0, endCost = startCost + numReplaced; endCost <= maxCostB; startCost++, endCost++) {
      //System.out.println("B: lowest beauty for " + startCost + " is " + findLowestBeauty(B, startCost));
      //System.out.println("B: higher beauty for " + endCost + " is " + findHighestBeauty(B, endCost));

      int diff = findHighestBeauty(B, endCost) - findLowestBeauty(B, startCost);
      maxBeauty = Math.max(maxBeauty, diff);
    }
    System.out.println(maxBeauty);
  }
  
  int findLowestBeauty(List<Segment> segments, int cost) {
    int lo = 0;
    int hi = segments.size() - 1;
    
    while (lo <= hi) {
      int mid = (hi + lo) / 2;
      Segment s = segments.get(mid);
      
      if (s.cost == cost) {
        if (mid == 0) {
          return s.beauty;
        }
        Segment l = segments.get(mid - 1);
        if (l.cost == s.cost) {
          hi = mid - 1;
        }
        else {
          return s.beauty;
        }
      }
      else if (s.cost > cost) {
        hi = mid - 1;
      }
      else {
        lo = mid + 1;
      }
    }
    return -1;
  }
  
  int findHighestBeauty(List<Segment> segments, int cost) {
    int lo = 0;
    int hi = segments.size() - 1;
    
    while (lo <= hi) {
      int mid = (hi + lo) / 2;
      Segment s = segments.get(mid);
      
      if (s.cost == cost) {
        if (mid == segments.size() - 1) {
          return s.beauty;
        }
        Segment r = segments.get(mid + 1);
        if (r.cost == s.cost) {
          lo = mid + 1;
        }
        else {
          return s.beauty;
        }
      }
      else if (s.cost > cost) {
        hi = mid - 1;
      }
      else {
        lo = mid + 1;
      }
    }
    return -1;
  }
  
  class Segment {
    int beauty;
    int cost;
    
    public Segment(int beauty, int cost) {
      this.beauty = beauty;
      this.cost = cost;
    }
  }
}

    