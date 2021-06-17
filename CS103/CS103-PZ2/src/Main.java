import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("CS103 - Projektni zadatak 2\n" +
                "Izaberite koji algoritam za pretragu minimalnog grafa zelite da iskoristite.\n" +
                "1 za primov, 2 za kruskalov algoritam.");

        int n = sc.nextInt();

        if (n == 1) {
            System.out.println("Izabrali ste primov algoritam!" +
                    "\n");
            PrimGraph graph = new PrimGraph();
            int V = 5;

            int[][] G = {
                    {0, 9, 75, 0, 0},
                    {9, 0, 95, 19, 42},
                    {75, 95, 0, 51, 66},
                    {0, 19, 51, 0, 31},
                    {0, 42, 66, 31, 0}
            };

            graph.Prim(G, V);

        } else if (n == 2) {
            System.out.println("Izabrali ste kruskalov algoritam!" +
                    "\n");
            int vertices = 6;
            int edges = 8;

            KruskalGraph kruskal = new KruskalGraph(vertices, edges);

            kruskal.edge[0].src = 0;
            kruskal.edge[0].dest = 1;
            kruskal.edge[0].weight = 4;

            kruskal.edge[1].src = 0;
            kruskal.edge[1].dest = 2;
            kruskal.edge[1].weight = 4;

            kruskal.edge[2].src = 1;
            kruskal.edge[2].dest = 2;
            kruskal.edge[2].weight = 2;

            kruskal.edge[3].src = 2;
            kruskal.edge[3].dest = 3;
            kruskal.edge[3].weight = 3;

            kruskal.edge[4].src = 2;
            kruskal.edge[4].dest = 5;
            kruskal.edge[4].weight = 2;

            kruskal.edge[5].src = 2;
            kruskal.edge[5].dest = 4;
            kruskal.edge[5].weight = 4;

            kruskal.edge[6].src = 3;
            kruskal.edge[6].dest = 4;
            kruskal.edge[6].weight = 3;

            kruskal.edge[7].src = 5;
            kruskal.edge[7].dest = 4;
            kruskal.edge[7].weight = 3;
            kruskal.KruskalAlgo();

        } else {
            System.err.println("Izaberite 1 ili 2.");
        }
        sc.close();
        System.out.println("\n" +
                "Uradio Aleksa Cekic 4173");
    }
}
