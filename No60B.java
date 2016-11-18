import java.io.*;
import java.util.*;

public class No60B {
  int[] dX = {1, -1, 0, 0, 0, 0};
  int[] dY = {0, 0, 1, -1, 0, 0};
  int[] dZ = {0, 0, 0, 0, 1, -1};
  
  int k;
  int n;
  int m;
  
  public static void main (String [] args) throws IOException {
    No60B program = new No60B();
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
    
    k = sc.nextInt();
    n = sc.nextInt();
    m = sc.nextInt();
    
    boolean[][][] empty = new boolean[k][n][m];
    boolean[][][] visited = new boolean[k][n][m];
    
    for (int a = 0; a < k; a++) {
      for (int b = 0; b < n; b++) {
        String line = sc.next();
        for (int c = 0; c < m; c++) {
          char character = line.charAt(c);
          
          empty[a][b][c] = character == '.';
        }
      }
    }
    int x = sc.nextInt() - 1;
    int y = sc.nextInt() - 1;
    
    Coordinate start = new Coordinate(0, x, y);
    Deque<Coordinate> queue = new ArrayDeque<Coordinate>();
    queue.add(start);
    
    int size = 0;
    
    while (!queue.isEmpty()) {
      Coordinate c = queue.poll();
      if (visited[c.x][c.y][c.z]) {
        continue;
      }
      else {
        size++;
        visited[c.x][c.y][c.z] = true;
      }
      
      for (int i = 0; i < 6; i++) {
        int newX = c.x + dX[i];
        int newY = c.y + dY[i];
        int newZ = c.z + dZ[i];
        
        if (inBounds(newX, newY, newZ) && empty[newX][newY][newZ] &&
            !visited[newX][newY][newZ]) {
          queue.add(new Coordinate(newX, newY, newZ));
        }
      }
    }
    
    System.out.println(size);
  }
  
  private boolean inBounds(int x, int y, int z) {
    return  x >= 0 && x < k &&
            y >= 0 && y < n &&
            z >= 0 && z < m;
  }
  
  class Coordinate {
    int x;
    int y;
    int z;

    public Coordinate(int x, int y, int z) {
      this.x = x;
      this.y = y;
      this.z = z;
    }
  }
}