import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private int number;
    private boolean beingVisited;
    private boolean visited;
    private List<Vertex> adjacencyList;

    public Vertex(int number) {
        this.number = number;
        this.adjacencyList = new ArrayList<>();
    }

    public void addNeighbor(Vertex adjacent) {
        this.adjacencyList.add(adjacent);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isBeingVisited() {
        return beingVisited;
    }

    public void setBeingVisited(boolean beingVisited) {
        this.beingVisited = beingVisited;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex> getAdjacencyList() {
        return adjacencyList;
    }

    public void setAdjacencyList(List<Vertex> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }
}
