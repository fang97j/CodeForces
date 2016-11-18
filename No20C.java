import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class No20C {

  static List<Node> nodes;
  
  public static void main(String[] args) {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    /*BufferedReader br = null;
    try {
      br = new BufferedReader(new FileReader(new File("C:/Users/John/workspace/CodeForces/src/input.txt")));
    }
    catch (FileNotFoundException e1) {}*/
    int n = 0;
    int m = 0;
    try {
      String line = br.readLine();
      String[] split = line.split("\\s+");
      n = Integer.valueOf(split[0]);
      m = Integer.valueOf(split[1]);
    }
    catch (IOException e) {}

    // Create nodes in adjacency list
    nodes = new ArrayList<Node>();
    Set<Node> setNodes = new HashSet<Node>();
    for (int i = 0; i < n; i++) {
      nodes.add(new Node(i));
    }

    // Create edges in adjacency list
    for (int i = 0; i < m; i++) {
      String line;
      try {
        line = br.readLine();
        String[] split = line.split("\\s+");
        int source = Integer.valueOf(split[0]) - 1;
        int destination = Integer.valueOf(split[1]) - 1;
        int weight = Integer.valueOf(split[2]);
        nodes.get(source).addNeighbour(nodes.get(destination), weight);
        nodes.get(destination).addNeighbour(nodes.get(source), weight);
      }
      catch (IOException e) {}
    }
    nodes.get(0).pathDistance = 0;
    PriorityQueue<Node> pq = new PriorityQueue<>(1, new Comparator<Node>() {
      @Override
      public int compare(Node n1, Node n2) {
        return n1.pathDistance - n2.pathDistance;
      }
    });

    // Dijkstra's algorithm
    pq.add(nodes.get(0));
    while(!pq.isEmpty()) {
      Node node = pq.poll();
      if (setNodes.contains(node)) continue;
      setNodes.add(node);
      for (Node neighbour : node.neighbours.keySet()) {
        // Evaluate shortest paths
        int distance = node.neighbours.get(neighbour);
        if (!setNodes.contains(neighbour) && neighbour.pathDistance > node.pathDistance + distance) {
          neighbour.pathDistance = node.pathDistance + distance;
          neighbour.previous = node;
          pq.add(neighbour);
        }
      }
    }

    Node currentNode = nodes.get(n - 1);
    if (currentNode.previous == null) {
      System.out.println("-1");
    }
    else {
      StringBuilder sb = new StringBuilder();
      StringBuilder sb2;
      while (currentNode != null) {
        sb2 = new StringBuilder(String.valueOf(currentNode.number + 1)).append(" ");
        sb2.reverse();
        sb.append(sb2);
        currentNode = currentNode.previous;
      }
      System.out.println(sb.reverse().toString());
    }
    try {
      br.close();
    }
    catch (IOException e) {}
  }
}

class Node {
  public Map<Node, Integer> neighbours;
  public Node previous;
  public int pathDistance;
  public int number;
  public Node(int number) {
    neighbours = new HashMap<>();
    pathDistance = Integer.MAX_VALUE;
    this.number = number;
  }
  
  void addNeighbour(Node destination, int weight) {
    if (neighbours.containsKey(destination) && neighbours.get(destination) <= weight) {
      return;
    }
    neighbours.put(destination, weight);
  }
}