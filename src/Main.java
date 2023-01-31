import Program.MatrixButtons;
import Program.Mymatrix;
import Program.TextFieldFrame;
import Program.Wczytaj_z_pliku;
import Sasiedztwo.Sasiedztwo;
import Sasiedztwo.Pochlaniajace;
import Sasiedztwo.Przenikajace;
import Sasiedztwo.Odbijajace;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Czy chcesz ustawić własne pozycje startowe czy skorzystać z gotowych? własne - w, gotowe - g, " + "\n" +
                "jeżeli chcesz wybrać własne to wyświetli się panel wyboru miejsc z żywymi komórkami, gdy już wybierzesz komórki naciśnij przycisk gotowe, dalsze instrukcje pojawią się w konsoli");
        Scanner sc = new Scanner(System.in);
        String line = "";
        while (!line.equals("g") && !line.equals("w")){
            line = sc.nextLine();

        }
        if(line.equals("w")){
            new MatrixButtons(11,20);

        }else {
            String wzorzec = "";
            String filename = "";
            String S;
            String B;
            ArrayList<Integer> zbior_S = new ArrayList<>();
            ArrayList<Integer> zbior_B = new ArrayList<>();
            System.out.println("Czy chcesz zmienić wartość zbioró S i B? chcę podawać - t, nie chce - n (Domyślne wartości to (2,3), (3))");
            String line_2 = sc.nextLine();
            while (!line_2.equals("n") && !line_2.equals("t")) {
                System.out.println("Podaj prawidłową wartość");
                line_2 = sc.nextLine();

            }
            if (line.equals("t")) {
                System.out.println("Podaj wartość zbioru S");
                S = sc.nextLine();
                System.out.println("Podaj wartość zbioru B");

                B = sc.nextLine();

                Arrays.stream(S.split(",")).forEach(e -> zbior_S.add(Integer.parseInt(e)));
                Arrays.stream(B.split(",")).forEach(c -> zbior_B.add(Integer.parseInt(c)));
                System.out.println(zbior_S);
                System.out.println(zbior_B);
            }else{
                zbior_S.add(2);
                zbior_S.add(3);
                zbior_B.add(3);
            }
            String warunek = "";
            System.out.println("Teraz wybierz warunek brzegowy pochłaniający = p, przenikający - s , odbijający - o");
            warunek = sc.nextLine();
            while (!warunek.equals("s") && !warunek.equals("o") && !warunek.equals("p")) {
                System.out.println("Podaj prawidłową wartość");
                warunek = sc.nextLine();

            }



            System.out.println("Wzorce startowe do wyboru:");
            System.out.println("1. Blinkers");
            System.out.println("2. Spaceship patterns");
            System.out.println("3. Beacons");
            System.out.println("4. lightweit");
            System.out.println("5. LifeSpace");
            wzorzec = sc.nextLine();

            zbior_B.add(3);
            zbior_S.add(3);
            zbior_S.add(2);
            if(wzorzec.equals("1")){
                filename = "Samples_files/Blinkers.txt";
            } else if (wzorzec.equals("2")) {
                filename = "Samples_files/spaceship_pattern.txt";
            }else if (wzorzec.equals("3")) {
                filename = "Samples_files/Beacons.txt";
            }
            else if (wzorzec.equals("4")) {
                filename = "Samples_files/lightweit.txt";
            }else if (wzorzec.equals("5")) {
                filename = "Samples_files/LifeSpace.txt";
            }
            Mymatrix matrix = new Mymatrix(Wczytaj_z_pliku.fileToArray(filename));

            if(warunek.equals("s")){

                new TextFieldFrame(new  Przenikajace(matrix, zbior_S, zbior_B));

            }else if(warunek.equals("o")){
                new TextFieldFrame(new Odbijajace(matrix, zbior_S,zbior_B));

            } else{

                new TextFieldFrame(new Pochlaniajace(matrix, zbior_S, zbior_B));

            }



//            if (wzorzec.equals("1")){
//                Mymatrix mymatrix = new Mymatrix(Wczytaj_z_pliku.fileToArray("Samples_files/Blinkers.txt"));
//
//                Pochlaniajace pochlaniajace = new Pochlaniajace(mymatrix, zbior_S,zbior_B);
//                TextFieldFrame textFieldFrame = new TextFieldFrame(pochlaniajace);
//            }

        }



    }

    public static void printmatrix(int[][] tablica) {
        DecimalFormat decimalFormat = new DecimalFormat("0");

        for (int i = 0; i < tablica.length; i++) {
            for (int j = 0; j < tablica[0].length; j++) {
                System.out.printf(decimalFormat.format(tablica[i][j]) + " ");

            }
            System.out.println();
        }


    }


}