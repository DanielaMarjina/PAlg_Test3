import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Colindatori {

    public static void citireFisier(Scanner scanner) throws IOException {
        int t= scanner.nextInt();
        while (t!=0){
            int n= scanner.nextInt();
            int[][] a=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    a[i][j]= scanner.nextInt();
                }
            }
//            for(int i=0;i<n;i++){
//                System.out.println(Arrays.toString(a[i]));
//            }
            componenteConexe(a,n);
            t--;
        }
    }

    public static void componenteConexe(int[][] a,int n) throws IOException {
        int[] vizitat=new int[n];
        List<Integer> dimensiuni=new ArrayList<>();
        FileWriter fileWriter=new FileWriter("outputColindatori.txt",true);

        for(int i=0;i<n;i++){
            if(vizitat[i]==0){
                int dim=df(a,n,vizitat,i);
                dimensiuni.add(dim);
            }
        }

        Collections.sort(dimensiuni);
        for(Integer x:dimensiuni){
            fileWriter.write(x+" ");
        }
        fileWriter.write("\n");

        fileWriter.close();
    }

    public static int df(int[][] a, int n, int[] vizitat, int nod){
        int cnt=1;
        vizitat[nod]=1;
        for(int i=0;i<n;i++){
            if(a[nod][i]==1 && vizitat[i]==0){
                cnt+=df(a, n, vizitat, i);
            }
        }
        return cnt;
    }


}
