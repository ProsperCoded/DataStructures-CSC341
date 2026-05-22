package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class GraphAdjMatrix {
  private final List<String> vertices;
  private boolean[][] matrix;

  public GraphAdjMatrix() {
    this.vertices = new ArrayList<>();
    this.matrix = new boolean[0][0];
  }

  public void addVertex(String vertex) {
    if (vertex == null || vertices.contains(vertex)) {
      return;
    }
    vertices.add(vertex);
    resizeMatrix(vertices.size());
  }

  public void removeVertex(String vertex) {
    int index = vertices.indexOf(vertex);
    if (index < 0) {
      return;
    }
    vertices.remove(index);
    boolean[][] newMatrix = new boolean[vertices.size()][vertices.size()];
    int newRow = 0;
    for (int i = 0; i < matrix.length; i++) {
      if (i == index) {
        continue;
      }
      int newCol = 0;
      for (int j = 0; j < matrix.length; j++) {
        if (j == index) {
          continue;
        }
        newMatrix[newRow][newCol] = matrix[i][j];
        newCol++;
      }
      newRow++;
    }
    matrix = newMatrix;
  }

  public void addEdge(String from, String to) {
    if (from == null || to == null) {
      return;
    }
    addVertex(from);
    addVertex(to);
    int fromIndex = vertices.indexOf(from);
    int toIndex = vertices.indexOf(to);
    matrix[fromIndex][toIndex] = true;
    matrix[toIndex][fromIndex] = true;
  }

  public void removeEdge(String from, String to) {
    int fromIndex = vertices.indexOf(from);
    int toIndex = vertices.indexOf(to);
    if (fromIndex < 0 || toIndex < 0) {
      return;
    }
    matrix[fromIndex][toIndex] = false;
    matrix[toIndex][fromIndex] = false;
  }

  public List<String> bfs(String start) {
    int startIndex = vertices.indexOf(start);
    if (startIndex < 0) {
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
      int currentIndex = vertices.indexOf(current);
      for (int i = 0; i < vertices.size(); i++) {
        if (matrix[currentIndex][i]) {
          String neighbor = vertices.get(i);
          if (visited.add(neighbor)) {
            queue.add(neighbor);
          }
        }
      }
    }
    return order;
  }

  public List<String> dfs(String start) {
    int startIndex = vertices.indexOf(start);
    if (startIndex < 0) {
      return List.of();
    }
    var visited = new LinkedHashSet<String>();
    var order = new ArrayList<String>();
    dfsRecursive(startIndex, visited, order);
    return order;
  }

  private void dfsRecursive(int index, LinkedHashSet<String> visited, List<String> order) {
    String vertex = vertices.get(index);
    visited.add(vertex);
    order.add(vertex);
    for (int i = 0; i < vertices.size(); i++) {
      if (matrix[index][i]) {
        String neighbor = vertices.get(i);
        if (!visited.contains(neighbor)) {
          dfsRecursive(i, visited, order);
        }
      }
    }
  }

  private void resizeMatrix(int size) {
    boolean[][] newMatrix = new boolean[size][size];
    for (int i = 0; i < matrix.length; i++) {
      System.arraycopy(matrix[i], 0, newMatrix[i], 0, matrix[i].length);
    }
    matrix = newMatrix;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Vertices: ").append(vertices).append('\n');
    builder.append("Matrix:").append('\n');
    for (int i = 0; i < vertices.size(); i++) {
      builder.append(vertices.get(i)).append(": ");
      for (int j = 0; j < vertices.size(); j++) {
        builder.append(matrix[i][j] ? "1" : "0");
        if (j < vertices.size() - 1) {
          builder.append(' ');
        }
      }
      if (i < vertices.size() - 1) {
        builder.append('\n');
      }
    }
    return builder.toString();
  }
}
