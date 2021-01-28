import java.util.Arrays;

public class PrimGraph {

    public PrimGraph() {
    }

    public void Prim(int[][] matrix, int vertex) {
        int INF = 9999999;

        int no_edge; // broj veza (edgeva)

        boolean[] selected = new boolean[vertex];

        // Pocetno postavljamo da su selectovani cvorovi prazni
        Arrays.fill(selected, false);

        no_edge = 0;

        selected[0] = true;

        System.out.println("Grana : Tezina");

        while (no_edge < vertex - 1) {

            int min = INF;
            int x = 0;
            int y = 0;

            for (int i = 0; i < vertex; i++) {
                if (selected[i]) {
                    for (int j = 0; j < vertex; j++) {
                        // nije u selektovanom ali postoji veza
                        if (!selected[j] && matrix[i][j] != 0) {
                            if (min > matrix[i][j]) {
                                min = matrix[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }
            System.out.println(x + " - " + y + " :  " + matrix[x][y]);
            selected[y] = true;
            no_edge++;
        }
    }
}