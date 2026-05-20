import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class NoduriIzolate {
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
//            for(int i=0;i<n;i++){
//                System.out.println(Arrays.toString(a[i]));
//            }
            noduriIzolate(a, n);
        }
    }

    public static void noduriIzolate(int[][] a, int n) throws IOException {
        FileWriter fileWriter=new FileWriter("outputNoduriIzolate.txt");
        int cnt = 0;

        for (int i = 0; i < n; i++) {

            boolean izolat = true;

            for (int j = 0; j < n; j++) {

                if (a[i][j] == 1) {

                    izolat = false;
                    break;
                }
            }

            if (izolat) {
                cnt++;
                fileWriter.write(i+"\n");
            }
        }

        fileWriter.write(cnt+" ");
        fileWriter.close();
    }

}
