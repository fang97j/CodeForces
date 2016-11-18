import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class No378C {
  int[] dX = {0, 1, 0, -1};
  int[] dY = {1, 0, -1, 0};
  char[][] maze = null;
  boolean[][] visited = null;
  int n = 0;
  int m = 0;
  int k = 0;

  Set<TreeNode> leaves = new HashSet<TreeNode>();
  int numLeaves = 0;

  public static void main(String[] args) throws IOException {
    No378C program = new No378C();
    program.solve();

  }

  public void solve() throws IOException {

    /*Scanner sc = null;
    try {
      sc = new Scanner(new File("C:/Users/John/workspace/USACO/src/input.txt"));
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }*/

    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();
    k = sc.nextInt();

    Coordinate firstEmpty = null;

    // read in maze
    maze = new char[n][m];
    visited = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      String line = sc.next();
      for (int j = 0; j < m; j++) {
        maze[i][j] = line.charAt(j);
        if (firstEmpty == null && maze[i][j] == '.') {
          firstEmpty = new Coordinate(i, j);
        }
      }
    }

    // construct the graph
    List<TreeNode> graph = constructTree(firstEmpty);

    TreeNode root = graph.get(0);
    
    leaves = new HashSet<TreeNode>();
    numLeaves = 0;

    findKLeaves(root);
    for (TreeNode toRemove : leaves) {
      maze[toRemove.coordinate.x][toRemove.coordinate.y] = 'X';
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(maze[i][j]);
      }
      System.out.println();
    }
  }

  void findKLeaves(TreeNode root) {
    if (numLeaves == k) {
      return;
    }

    // if it has children, empty those out first
    if (!root.children.isEmpty()) {
      for (TreeNode child : root.children) {
        findKLeaves(child);
      }
    }

    // finally empty out yourself
    if (numLeaves == k) {
      return;
    }
    leaves.add(root);
    numLeaves++;
  }

  List<TreeNode> constructTree(Coordinate c) {
    List<TreeNode> graph = new ArrayList<TreeNode>();

    TreeNode root = new TreeNode(c);
    visited[c.x][c.y] = true;

    Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
    queue.add(root);

    while (!queue.isEmpty()) {
      TreeNode current = queue.poll();
      graph.add(current);

      for (int i = 0; i < 4; i++) {
        int newX = current.coordinate.x + dX[i];
        int newY = current.coordinate.y + dY[i];
        if (inBounds(newX, newY) && maze[newX][newY] == '.'
            && !visited[newX][newY]) {
          TreeNode child = new TreeNode(new Coordinate(newX, newY));
          current.children.add(child);
          current.numChildren++;
          visited[newX][newY] = true;
          queue.add(child);
        }
      }
    }
    return graph;
  }

  boolean inBounds(int x, int y) {
    return x >= 0 && x < n && y >= 0 && y < m;
  }

  class Coordinate {
    int x;
    int y;
    public Coordinate(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  class TreeNode {
    Coordinate coordinate;
    Set<TreeNode> children;
    int numChildren;

    public TreeNode(Coordinate coordinate) {
      this.coordinate = coordinate;
      this.children = new HashSet<TreeNode>();
      this.numChildren = 0;
    }
  }
}