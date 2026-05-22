package Graph;

public class Main {
  public static void main(String[] args) {
    GraphAdjList listGraph = new GraphAdjList();
    listGraph.addEdge("A", "B");
    listGraph.addEdge("A", "C");
    listGraph.addEdge("B", "D");
    listGraph.addEdge("C", "D");
    listGraph.addEdge("D", "E");

    System.out.println("Adjacency List: " + listGraph);
    System.out.println("List BFS from A: " + listGraph.bfs("A"));
    System.out.println("List DFS from A: " + listGraph.dfs("A"));

    GraphAdjMatrix matrixGraph = new GraphAdjMatrix();
    matrixGraph.addEdge("A", "B");
    matrixGraph.addEdge("A", "C");
    matrixGraph.addEdge("B", "D");
    matrixGraph.addEdge("C", "D");
    matrixGraph.addEdge("D", "E");

    System.out.println("\nAdjacency Matrix:\n" + matrixGraph);
    System.out.println("Matrix BFS from A: " + matrixGraph.bfs("A"));
    System.out.println("Matrix DFS from A: " + matrixGraph.dfs("A"));
  }
}
