import java.io.*;
import java.util.*;

public class No545C {
  public static void main (String [] args) throws IOException {
    No545C program = new No545C();
    program.solve();
    
  }
  int n;
  Tree[] trees;
  
  public void solve() throws IOException {
    /*Scanner sc = null;
    try {
      sc = new Scanner(new File("C:/Users/John/workspace/CodeForces/src/input.txt"));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }*/
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    
    if (n <= 2) {
      System.out.println(n);
      return;
    }
    trees = new Tree[n];

    int numCuts = 0;
    
    int coordinate = sc.nextInt();
    int height = sc.nextInt();
    trees[0] = new Tree(0, coordinate, height, Status.LEFT);
    numCuts++;
    
    for (int i = 1; i < n - 1; i++) {
      coordinate = sc.nextInt();
      height = sc.nextInt();
      trees[i] = new Tree(i, coordinate, height, Status.UNCUT);

      Tree prev = trees[i - 1];
      
      switch(prev.status) {
        case UNCUT: {
          // cut prev right and cur left for free
          if (prev.coordinate + prev.height < coordinate - height) {
            trees[i - 1].status = Status.RIGHT;
            trees[i].status = Status.LEFT;
            numCuts += 2;
          } 
          // cut prev right. cur can't cut left
          else if (prev.coordinate + prev.height < coordinate) {
            trees[i - 1].status = Status.RIGHT;
            numCuts++;
          }
          // if prev can't be cut, cut cur left
          else if (prev.coordinate < coordinate - height) {
            trees[i].status = Status.LEFT;
            numCuts++;
          }
          break;
        }
        case LEFT: {
          // cut current left for free
          if (prev.coordinate < coordinate - height) {
            trees[i].status = Status.LEFT;
            numCuts++;
          }
          break;
        }
        default:
      }
    }
    coordinate = sc.nextInt();
    height = sc.nextInt();
    trees[n - 1] = new Tree(n - 1, coordinate, height, Status.RIGHT);
    numCuts++;

    if (trees[n - 2].status == Status.UNCUT && trees[n - 2].coordinate + trees[n - 2].height < trees[n - 1].coordinate) {
      trees[n - 2].status = Status.RIGHT;
      numCuts++;
    }

    System.out.println(numCuts);
  }
  
  
  class Tree {
    int i;
    int coordinate;
    int height;
    Status status;
    
    public Tree (int i, int coordinate, int height, Status s) {
      this.i = i;
      this.coordinate = coordinate;
      this.height = height;
      this.status = s;
    }
  }
  
  enum Status {
    LEFT, RIGHT, UNCUT
  }
}