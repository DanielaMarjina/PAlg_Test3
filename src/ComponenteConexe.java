import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class ComponenteConexe {

    public static void citireFisier(Scanner scanner) throws IOException {

        while (scanner.hasNext()) {

            int n = scanner.nextInt();
            int m = scanner.nextInt();

            int[][] a = new int[n][n];

            for (int k = 0; k < m; k++) {
                int i = scanner.nextInt();
                int j = scanner.nextInt();
                a[i][j] = 1;
                a[j][i] = 1;
            }

            componenteConexe(a, n);
        }
    }

    public static void componenteConexe(int[][] a, int n) throws IOException {

        FileWriter fileWriter = new FileWriter("outputCC.txt");

        boolean existaNodNevizitat = true;
        int compConexa = 0;
        int[] vizitat = new int[n];

        StringBuilder rezultat = new StringBuilder();

        while (existaNodNevizitat) {

            existaNodNevizitat = false;

            for (int i = 0; i < n; i++) {

                if (vizitat[i] == 0) {

                    existaNodNevizitat = true;
                    compConexa++;

                    df(a, n, vizitat, i, compConexa, rezultat);

                    rezultat.append("\n");
                }
            }
        }
        fileWriter.write(compConexa + "\n");
        fileWriter.write(rezultat.toString().trim());
        fileWriter.close();

    }

    public static void df(int[][] a, int n, int[] vizitat, int nod, int compConexa, StringBuilder rezultat) {

        vizitat[nod] = compConexa;
        rezultat.append(nod).append(" ");

        for (int j = 0; j < n; j++) {
            if (a[nod][j] == 1 && vizitat[j] == 0) {
                df(a, n, vizitat, j, compConexa, rezultat);
            }
        }
    }
}