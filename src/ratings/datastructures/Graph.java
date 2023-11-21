package ratings.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Graph<N> {

    private HashMap<N, ArrayList<N>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addEdge(N from, N to) {
        this.addNode(from);
        this.addNode(to);
        this.adjacencyList.get(from).add(to);
    }

    public HashMap<N, ArrayList<N>> returnAdjacencyList() {
        return this.adjacencyList;
    }


    public void addBidirectionalEdge(N node1, N node2) {
        this.addNode(node1);
        this.addNode(node2);
        this.adjacencyList.get(node1).add(node2);
        this.adjacencyList.get(node2).add(node1);
    }

    private void addNode(N a) {
        if (!this.adjacencyList.containsKey(a)) {
            this.adjacencyList.put(a, new ArrayList<>());
        }
    }

    @Override
    public String toString() {
        return this.adjacencyList.toString();
    }

    public HashMap<N, ArrayList<N>> getAdjacencyList() {
        return adjacencyList;
    }

    public ArrayList<N> getNeighbors(N node) {
        return this.adjacencyList.get(node);
    }


    public boolean areConnected(N from, N to) {
        return this.adjacencyList.containsKey(from) && this.adjacencyList.get(from).contains(to);
    }

    public boolean validPath(ArrayList<N> path) {
        for (int i = 0; i < path.size() - 1; i++) {
            N from = path.get(i);
            N to = path.get(i + 1);
            if (!this.areConnected(from, to)) {
                return false;
            }
        }
        return true;
    }
}