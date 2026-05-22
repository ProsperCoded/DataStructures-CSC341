package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public class GraphAdjList {
  private final Map<String, LinkedHashSet<String>> adjacency;

  public GraphAdjList() {
    this.adjacency = new LinkedHashMap<>();
  }

  public void addVertex(String vertex) {
    if (vertex == null || adjacency.containsKey(vertex)) {
      return;
    }
    adjacency.put(vertex, new LinkedHashSet<>());
  }

  public void removeVertex(String vertex) {
    if (vertex == null || !adjacency.containsKey(vertex)) {
      return;
    }
    adjacency.remove(vertex);
    for (var neighbors : adjacency.values()) {
      neighbors.remove(vertex);
    }
  }

  public void addEdge(String from, String to) {
    if (from == null || to == null) {
      return;
    }
    addVertex(from);
    addVertex(to);
    adjacency.get(from).add(to);
    adjacency.get(to).add(from);
  }

  public void removeEdge(String from, String to) {
    if (from == null || to == null) {
      return;
    }
    var fromNeighbors = adjacency.get(from);
    if (fromNeighbors != null) {
      fromNeighbors.remove(to);
    }
    var toNeighbors = adjacency.get(to);
    if (toNeighbors != null) {
      toNeighbors.remove(from);
    }
  }

  public List<String> bfs(String start) {
    if (start == null || !adjacency.containsKey(start)) {
      return List.of();
    }
    var visited = new LinkedHashSet<String>();
    var order = new ArrayList<String>();
    var queue = new ArrayDeque<String>();
    queue.add(start);
    visited.add(start);
    while (!queue.isEmpty()) {
      var current = queue.remove();
      order.add(current);
      for (var neighbor : adjacency.get(current)) {
        if (visited.add(neighbor)) {
          queue.add(neighbor);
        }
      }
    }
    return order;
  }

  public List<String> dfs(String start) {
    if (start == null || !adjacency.containsKey(start)) {
      return List.of();
    }
    var visited = new LinkedHashSet<String>();
    var order = new ArrayList<String>();
    dfsRecursive(start, visited, order);
    return order;
  }

  private void dfsRecursive(String vertex, LinkedHashSet<String> visited, List<String> order) {
    visited.add(vertex);
    order.add(vertex);
    for (var neighbor : adjacency.get(vertex)) {
      if (!visited.contains(neighbor)) {
        dfsRecursive(neighbor, visited, order);
      }
    }
  }

  @Override
  public String toString() {
    return adjacency.toString();
  }
}
