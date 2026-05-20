import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class LabirintBF {

    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void citireFisier(Scanner scanner) throws IOException {

        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine();

        int[][] a = new int[m][n];

        for (int i = 0; i < m; i++) {
            String line = scanner.nextLine().replaceAll("\\s+", "");

            int j = 0, col = 0;

            while (col < n) {

                if (line.startsWith("-1", j)) {
                    a[i][col] = -1;
                    j += 2;
                } else {
                    a[i][col] = 0;
                    j += 1;
                }

                col++;
            }
        }

        int startI = scanner.nextInt();
        int startJ = scanner.nextInt();
        int finalI = scanner.nextInt();
        int finalJ = scanner.nextInt();

        bfs(a, m, n, startI, startJ, finalI, finalJ);
    }

    public static void bfs(int[][] a, int m, int n,
                           int startI, int startJ,
                           int finalI, int finalJ) throws IOException {

        FileWriter fw = new FileWriter("outputLabirintBF.txt");

        int[][] vizitat = new int[m][n];
        int[][] dist = new int[m][n];
        int[][] parinteI = new int[m][n];
        int[][] parinteJ = new int[m][n];

        for (int[] row : dist)
            Arrays.fill(row, -1);

        for (int i = 0; i < m; i++) {
            Arrays.fill(parinteI[i], -1);
            Arrays.fill(parinteJ[i], -1);
        }

        Queue<Punct> coada = new LinkedList<>();

        coada.add(new Punct(startI, startJ));
        vizitat[startI][startJ] = 1;

        dist[startI][startJ] = 1;

        while (!coada.isEmpty()) {

            Punct p = coada.poll();
            int x = p.getX();
            int y = p.getY();

            for (int d = 0; d < 4; d++) {

                int nx = x + di[d];
                int ny = y + dj[d];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {

                    if (vizitat[nx][ny]==0 && a[nx][ny] == 0) {

                        vizitat[nx][ny] = 1;
                        dist[nx][ny] = dist[x][y] + 1;

                        parinteI[nx][ny] = x;
                        parinteJ[nx][ny] = y;

                        coada.add(new Punct(nx, ny));
                    }
                }
            }
        }

        if (vizitat[finalI][finalJ]==0) {
            fw.write("Nu exista solutie");
            fw.close();
            return;
        }

        List<Punct> drum = new ArrayList<>();

        int x = finalI, y = finalJ;

        while (x != -1) {
            drum.add(new Punct(x, y));
            int tx = parinteI[x][y];
            int ty = parinteJ[x][y];
            x = tx;
            y = ty;
        }

        Collections.reverse(drum);

        fw.write(drum.size() + "\n");

        for (Punct p : drum) {
            fw.write(p.getX() + " " + p.getY() + "\n");
        }

        fw.close();
    }
}