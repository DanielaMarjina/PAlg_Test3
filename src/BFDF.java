import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class BFDF {

    public static int n;
    public static int m;

    public static void citireFisier(Scanner scanner) throws IOException {
        while(scanner.hasNext()){
            n= scanner.nextInt();
            m= scanner.nextInt();
            int[][] a=new int[n][n];
            for(int k=0;k<m;k++){
                int i= scanner.nextInt();
                int j=scanner.nextInt();
                a[i][j]=1;
                a[j][i]=1;
            }
            int start= scanner.nextInt();
//            for(int i=0;i<n;i++){
//                System.out.println(Arrays.toString(a[i]));
//            }

            bf(a,start);

            df(a,start);

        }
    }

    public static void bf(int[][] a, int start) throws IOException {
        FileWriter fileWriter=new FileWriter("outputBF.txt");
        List<Integer> ordineBF=new ArrayList<>();
        int[] vizitat=new int[n];
        Arrays.fill(vizitat,0);
        Queue<Integer> coada=new LinkedList<>();
        coada.add(start);
        vizitat[start]=1;
        while(!coada.isEmpty()){
            int nodCurent=coada.poll();
            ordineBF.add(nodCurent);
            for(int j=0;j<n;j++){
                if(a[nodCurent][j]==1 & vizitat[j]==0){
                    coada.add(j);
                    vizitat[j]=1;
                }
            }
        }
        for(int x:ordineBF){
            fileWriter.write(x+"\n");
        }
        fileWriter.close();
    }

    public static void df(int[][] a, int start) throws IOException {
        FileWriter fileWriter=new FileWriter("outputDF.txt");
        int n=a.length;
        List<Integer> ordineDF=new ArrayList<>();

        int[] vizitat=new int[n];
        vizitat[start]=1;
        ordineDF.add(start);

        Stack<Integer> stiva=new Stack<>();
        stiva.push(start);

        while(!stiva.isEmpty()){
            int nodCurent=stiva.peek();
            boolean found=false;
            for(int j=0;j<n;j++){
                if(a[nodCurent][j]==1 & vizitat[j]==0){
                    stiva.push(j);
                    vizitat[j]=1;
                    ordineDF.add(j);

                    found=true;
                    break;
                }
            }
            if(!found)
                stiva.pop();
        }

        for(int x:ordineDF){
            fileWriter.write(x+"\n");
        }
        fileWriter.close();
    }
}
