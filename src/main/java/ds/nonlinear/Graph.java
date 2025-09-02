package ds.nonlinear;



import java.util.*;

public class Graph {
    private Map<Integer, List<Integer>> adjList = new HashMap<>();

    public void addVertex(int v) {
        adjList.putIfAbsent(v, new ArrayList<>());
    }

    public void addEdge(int src, int dest) {
        adjList.putIfAbsent(src, new ArrayList<>());
        adjList.putIfAbsent(dest, new ArrayList<>());
        adjList.get(src).add(dest);
    }

    public List<Integer> getNeighbors(int v) {
        return adjList.getOrDefault(v, Collections.emptyList());
    }

    public Map<Integer, List<Integer>> getAdjList() {
        return adjList;
    }
}

