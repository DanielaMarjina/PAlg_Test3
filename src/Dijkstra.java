import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Dijkstra {

    public static void citireFisier(Scanner scanner) throws IOException {
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] a = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j)
                        a[i][j] = 0;
                    else
                        a[i][j] = Integer.MAX_VALUE;
                }
            }

            for (int k = 0; k < m; k++) {
                int i = scanner.nextInt();
                int j = scanner.nextInt();
                int c = scanner.nextInt();

                a[i][j] = c;
                a[j][i] = c;
            }

            int start = scanner.nextInt();

//            for(int i=0;i<n;i++){
//                System.out.println(Arrays.toString(a[i]));
//            }

            Dijkstra(a, start, n);

        }
    }

    public static void Dijkstra(int[][] a, int start, int n) throws IOException {

        FileWriter fileWriter=new FileWriter("outputDijkstra.txt");

        int[] vizitat = new int[n];

        Arrays.fill(vizitat, 0);

        vizitat[start] = 1;

        int[] tata = new int[n];
        int[] dist = new int[n];

        dist[start]=0;
        tata[start]=-1;

        for (int i = 0; i < n; i++) {
            dist[i] = a[start][i];
            if (start != i && a[start][i] != Integer.MAX_VALUE) {
                tata[i] = start;
            } else {
                tata[i] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int p = -1;

            for (int j = 0; j < n; j++) {
                if (vizitat[j] == 0 && dist[j] < min) {
                    min = dist[j];
                    p = j;
                }
            }

            if(p==-1)
                break;

            vizitat[p] = 1;

            for (int j = 0; j < n; j++) {
                if (vizitat[j] == 0 && dist[j] > dist[p] + a[p][j]
                        && dist[p] != Integer.MAX_VALUE && a[p][j] != Integer.MAX_VALUE) {
                    dist[j] = dist[p] + a[p][j];
                    tata[j] = p;
                }
            }

        }

        System.out.println("tata: "+Arrays.toString(tata));

        for(int x:dist)
            fileWriter.write(x+" ");

        fileWriter.close();

        System.out.println("Distanta de la nodul de start la celelalte: "+
                Arrays.toString(dist));

        for (int i = 0; i < n; i++) {
            afiseazaDrum(start, i, tata, dist);
        }

    }

    public static List<Integer> afiseazaDrum(int nodStart, int nodFinal,
                                             int[] tata, int[] dist)
    {
        List<Integer> drum = new ArrayList<>();
        int x = nodFinal;
        while (x != -1)
        {
            drum.add(x);
            x = tata[x];
        }
        Collections.reverse(drum);
        System.out.print("Drum: " + drum +
                " Cost: " + dist[nodFinal]);
        System.out.println();
        return drum;
    }


}
