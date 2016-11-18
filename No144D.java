import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class No144D {

  public static void main(String[] args) throws IOException {
    No144D program = new No144D();
    program.solve();

  }

  public void solve() {

    /*Scanner sc = null;
    try {
      sc = new Scanner(new File("C:/Users/John/workspace/USACO/src/input.txt"));
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }*/

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int s = sc.nextInt() - 1;

    // Create nodes in adjacency list
    List<Node> nodes = new ArrayList<Node>();

    for (int i = 0; i < n; i++) {
      nodes.add(new Node(i));
    }
    // Create edges in adjacency list
    for (int i = 0; i < m; i++) {
      int source = sc.nextInt() - 1;
      int destination = sc.nextInt() - 1;
      int weight = sc.nextInt();
      nodes.get(source).addNeighbour(weight, destination);
      nodes.get(destination).addNeighbour(weight, source);
    }
    // Get distance to silos
    int siloDistance = sc.nextInt();
    int numSilos = 0;
    int numMidpoints = 0;

    // Dijkstra's algorithm
    nodes.get(s).pathDistance = 0;

    PriorityQueue<NodeWrapper> minHeap = new PriorityQueue<NodeWrapper>();
    minHeap.add(new NodeWrapper(nodes.get(s), 0));

    while (!minHeap.isEmpty()) {
      NodeWrapper minNodeWrapper = minHeap.remove();
      Node minNode = minNodeWrapper.node;
      
      if (minNode.set) {
        continue;
      }
      else {
        minNode.set = true;
        minNode.pathDistance = minNodeWrapper.value;
      }
      
      for (Edge e : minNode.neighbours) {
        Node destination = nodes.get(e.destination);
        if (!destination.set && destination.pathDistance > minNode.pathDistance + e.weight) {
          // destination.pathDistance = minNode.pathDistance + e.weight;
          minHeap.add(new NodeWrapper(destination, minNode.pathDistance + e.weight));
        }
      }
    }

    // Evaluate silo locations
    for (int i = 0; i < nodes.size(); i++) {
      Node src = nodes.get(i);
      if (src.pathDistance == siloDistance) {
        numSilos++;
      }
      else if (src.pathDistance < siloDistance) {
        for (Edge e : src.neighbours) {
          Node dest = nodes.get(e.destination);
          int edgeWeight = e.weight;

          if (siloDistance >= src.pathDistance + edgeWeight) {
            continue;
          }

          // silo could be between src and dest city
          int srcToSilo = siloDistance - src.pathDistance;
          int destToSilo = edgeWeight - srcToSilo;

          // check that dest can't reach silo in a shorter path
          if (siloDistance < dest.pathDistance + destToSilo) {
            numSilos++;
          }
          // silo is in the midpoint
          else if (siloDistance == dest.pathDistance + destToSilo) {
            numSilos++;
            numMidpoints++;
          }
        }
      }
    }
    System.out.println(numSilos - (numMidpoints / 2));
  }

  class Node {
    List<Edge> neighbours;
    int number;
    int pathDistance;
    boolean set;
    public Node(int number) {
      this.number = number;
      this.neighbours = new ArrayList<Edge>();
      this.pathDistance = Integer.MAX_VALUE;
      this.set = false;
    }

    void addNeighbour(int weight, int destination) {
      neighbours.add(new Edge(weight, destination));
    }
  }

  class Edge {
    int weight;
    int destination;
    public Edge(int weight, int destination) {
      this.weight = weight;
      this.destination = destination;
    }
  }
  
  class NodeWrapper implements Comparable<NodeWrapper> {
    Node node;
    int value;
    
    public NodeWrapper(Node node, int value) {
      this.node = node;
      this.value = value;
    }
    
    @Override
    public int compareTo(NodeWrapper o) {
      return value - o.value;
    }
  }
}
