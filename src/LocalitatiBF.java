import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class LocalitatiBF {

    public static void citireFisier(Scanner scanner) throws IOException {
        while (scanner.hasNext()){
            int n= scanner.nextInt();
            int[][] a=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    int c= scanner.nextInt();
                    a[i][j]=c;
                }
            }
            int localitateaA= scanner.nextInt();
            int localitateaB= scanner.nextInt();
            int Dmax= scanner.nextInt();
//            for(int i=0;i<n;i++){
//                System.out.println(Arrays.toString(a[i]));
//            }
            bf(a,n,localitateaA,localitateaB,Dmax);
        }
    }

    public static void bf(int[][] a, int n, int start, int end,int Dmax) throws IOException {
        FileWriter fileWriter=new FileWriter("outputLocalitatiBF.txt");
        Queue<Integer> coada=new LinkedList<>();

        List<Integer> ordineBF=new ArrayList<>();

        int[] vizitat=new int[n];
        Arrays.fill(vizitat,0);

        int[] tata=new int[n];
        Arrays.fill(tata,-1);

        coada.add(start);

        vizitat[start]=1;

        boolean gasit=false;

        while(!coada.isEmpty()){
            int nodCurent= coada.poll();
            if(nodCurent==end){
                gasit=true;
                break;
            }

            for(int i=0;i<n;i++){
                if(vizitat[i]==0 && a[nodCurent][i]<=Dmax){
                    coada.add(i);
                    vizitat[i]=1;
                    tata[i]=nodCurent;
                }
            }
        }
        if(!gasit){
            fileWriter.write("Nu exista drum!");
        }
        else {
            int x=end;
            while (x != -1)
            {
                ordineBF.add(x);
                x = tata[x];
            }
            Collections.reverse(ordineBF);
            fileWriter.write("Drum: "+start+" -> "+end+" : ");
            for(int nr:ordineBF){
                fileWriter.write(nr+" ");
            }
        }
        fileWriter.close();
    }
}
