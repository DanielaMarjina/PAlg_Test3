import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Roy_Floyd_Warshall {

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
//            for(int i=0;i<n;i++){
//                System.out.println(Arrays.toString(a[i]));
//            }
            RoyFloydWarshall(a);
        }
    }

    public static void RoyFloydWarshall(int[][] a) throws IOException {
        FileWriter fileWriter = new FileWriter("outputRFW.txt");
        int n = a.length;
        int[][] costMinim = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                costMinim[i][j] = a[i][j];
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (costMinim[i][k] != Integer.MAX_VALUE && costMinim[k][j] != Integer.MAX_VALUE
                            && costMinim[i][j] > costMinim[i][k] + costMinim[k][j]) {

                        costMinim[i][j] = costMinim[i][k] + costMinim[k][j];

                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                fileWriter.write(costMinim[i][j] + " ");
            }
            fileWriter.write("\n");
        }
        fileWriter.close();

    }
}
