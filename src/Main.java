import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(new FileReader("inputBFDF.txt"));
        BFDF.citireFisier(scanner);

        Scanner scanner1=new Scanner(new FileReader("inputVrajitor.txt"));
        Vrajitorul_nepopular.citireFisier(scanner1);

        Scanner scanner2=new Scanner(new FileReader("inputRFW.txt"));
        Roy_Floyd_Warshall.citireFisier(scanner2);

        Scanner scanner3=new Scanner(new FileReader("inputDijkstra.txt"));
        Dijkstra.citireFisier(scanner3);

        Scanner scanner4=new Scanner(new FileReader("inputFacebook.txt"));
        Facebook.citireFisier(scanner4);

        Scanner scanner5=new Scanner(new FileReader("inputCC.txt"));
        ComponenteConexe.citireFisier(scanner5);

        Scanner scanner6=new Scanner(new FileReader("inputColindatori.txt"));
        Colindatori.citireFisier(scanner6);

        Scanner scanner7=new Scanner(new FileReader("inputNoduriIzolate.txt"));
        NoduriIzolate.citireFisier(scanner7);

        Scanner scanner8=new Scanner(new FileReader("inputCelMaiPopular.txt"));
        celMaiPopular.citireFisier(scanner8);

        Scanner scanner9=new Scanner(new FileReader("inputLocalitatiBF.txt"));
        LocalitatiBF.citireFisier(scanner9);

        Scanner scanner10=new Scanner(new FileReader("inputLabirintBF.txt"));
        LabirintBF.citireFisier(scanner10);
    }
}