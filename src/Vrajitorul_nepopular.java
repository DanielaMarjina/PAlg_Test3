import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Vrajitorul_nepopular {

    public static void citireFisier(Scanner scanner) throws IOException {
        FileWriter fileWriter=new FileWriter("outputVrajitor.txt");
        int t = scanner.nextInt();
        while (t != 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < m; i++) {
                int x = scanner.nextInt();   // cine pe cine prefera [x]-->[y]
                int y = scanner.nextInt();
                a[x][y] = 1;
            }

            int popularitateInitiala=determinaPopularitatea(0,a);
            //System.out.println(popularitateInitiala);

            int v = scanner.nextInt();
            scanner.nextLine();
            for (int k = 0; k < v; k++) {
                String nume = scanner.next();
                int persoana = scanner.nextInt();
                Vraja vraja = new Vraja(nume, persoana);
                aplicaVraja(vraja,a);
            }

            int popularitateFinala=determinaPopularitatea(0,a);
            fileWriter.write(popularitateFinala-popularitateInitiala+"\n");
            t--;
        }
        fileWriter.close();

    }

    public static int determinaPopularitatea(int nod,int[][] a){
        int popularitate=0;
        for(int i=0;i<a.length;i++){
            popularitate+=a[i][nod];  //cati il prefera pe vrajitor care e 0  [x]-->[y]
        }
        return popularitate;
    }

    public static void aplicaVraja(Vraja vraja, int[][] a){
        int n=a.length;
        switch (vraja.nume){
            case "Inverseaza":

                for(int j=0;j<n;j++){
                    a[vraja.persoana][j]=1-a[vraja.persoana][j]; //inverseaza toate preferintele
                    a[vraja.persoana][vraja.persoana]=0;
                }

                break;

            case "Popular":

                if(vraja.persoana==0)
                    break;

                for(int j=0;j<n;j++){
                    a[j][vraja.persoana]=1; //toti il plac
                    a[vraja.persoana][vraja.persoana]=0;
                }

                break;

            case "Nepopular":

                for(int j=0;j<n;j++){
                    a[j][vraja.persoana]=0; //nimeni nu il place
                }

                break;
        }
    }
}

