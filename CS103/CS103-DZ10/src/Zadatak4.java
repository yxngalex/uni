public class Zadatak4 {
    public static void main(String[] args) {
        Graph graph = new Graph();

        Vertex vertex1 = new Vertex(1);
        Vertex vertex2 = new Vertex(2);
        Vertex vertex3 = new Vertex(3);
        Vertex vertex4 = new Vertex(4);

        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);
        graph.addVertex(vertex4);

        graph.addEdge(vertex1, vertex2);
        graph.addEdge(vertex2, vertex3);
        graph.addEdge(vertex3, vertex1);
        graph.addEdge(vertex4, vertex3);

        System.out.println(graph.hasCycle());

    }
}
