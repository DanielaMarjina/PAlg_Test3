import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class celMaiPopular {

    public static void citireFisier(Scanner scanner) throws IOException {
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[][] a = new int[n][n];
            scanner.nextLine();
            for (int i = 0; i < n; i++) {
                String linie = scanner.nextLine();
                String[] parts = linie.split("\\s+");
                for (String part : parts) {
                    int k = Integer.parseInt(part);
                    a[k][k]++;
                }
            }
//            for (int i = 0; i < n; i++) {
//                System.out.println(Arrays.toString(a[i]));
//            }
            celMaiPopular(a,n);

        }
    }

    public static void celMaiPopular(int[][] a,int n) throws IOException {
        FileWriter fileWriter=new FileWriter("outputCelMaiPopular.txt");
        int max=-1;
        int persoana=-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(a[i][j]>max && i==j) {
                    max = a[i][j];
                    persoana=i;
                }
            }
        }
        fileWriter.write(persoana+" ");
        fileWriter.close();
    }
}
