import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Facebook {

    public static void citireFisier(Scanner scanner) throws IOException {
        FileWriter fileWriter=new FileWriter("outputFacebook.txt");
        int t= scanner.nextInt();
        while(t!=0){
            int n= scanner.nextInt();
            int m= scanner.nextInt();
            int L=scanner.nextInt();
            int[][] a=new int[n][n];
            for(int k=0;k<m;k++){
                int i= scanner.nextInt();
                int j=scanner.nextInt();
                a[i][j]=1;
                a[j][i]=1;
            }

            for(int i=0;i<n;i++){
                int suma=bfFacebook(a,i,L);
                fileWriter.write(suma+" ");
            }
            fileWriter.write("\n");
            t--;

        }
        fileWriter.close();
    }

    public static int bfFacebook(int[][] a, int start, int L) throws IOException {
        int n=a.length;
        int[] vizitat=new int[n];
        Arrays.fill(vizitat,0);
        vizitat[start]=1;
        Queue<NodNivel> coada=new LinkedList<>();
        coada.add(new NodNivel(start,0));

        int suma=0;

        while(!coada.isEmpty()){
            NodNivel nodNivel=coada.poll();
            int nod=nodNivel.getNod();
            int nivel=nodNivel.getNivel();

            if(nivel>0){
                suma+= (int) Math.floor(L/Math.pow(2,nivel-1));
            }

            for(int j=0;j<n;j++){
                if(vizitat[j]==0 && a[nod][j]==1){
                    coada.add(new NodNivel(j,nivel+1));
                    vizitat[j]=1;
                }
            }
        }
        return suma;


    }

}
