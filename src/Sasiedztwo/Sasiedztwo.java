package Sasiedztwo;

import Program.MatrixButtons;

import Program.MatrixButtons.*;
import Program.Mymatrix;
import java.net.SocketImpl;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Sasiedztwo {
    Mymatrix mymatrix;
    Mymatrix copy_matrix;
    ArrayList<Integer> S;
    ArrayList<Integer> B;

    public Sasiedztwo(Mymatrix mymatrix, ArrayList<Integer> s, ArrayList<Integer> b) {


        this.mymatrix = mymatrix;
        this.copy_matrix = new Mymatrix(mymatrix);
        S = s;
        B = b;
        this.program_glowny();
    }

    public void program_glowny() {
        System.out.println("Rozpoczynamy działanie programu, aby zakończyć działanie w którymś kroku wpisz q w konsoli");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        String line = "";
        while (line != "q") {
            copy_matrix = new Mymatrix(mymatrix);

            for (int i = 0; i < mymatrix.numRows(); i++) {
                for (int j = 0; j < mymatrix.numCols(); j++) {
                    if (i == 0 || j == 0 || i == mymatrix.numRows() - 1 || j == mymatrix.numCols() - 1) {
                        komorka_brzeg(i, j);

                    } else {
                        komorka_srodek(i, j);
                    }


                }
            }

            System.out.println();
            MatrixButtons.printmatrix(mymatrix);
            line = sc.nextLine();
        }
    }

    public void komorka_brzeg(int i, int j) {
    }

    public void komorka_srodek(int i, int j) {
        ArrayList<Integer> sasiedzi = new ArrayList<>();
        sasiedzi.add((int) copy_matrix.get(i, j - 1));
        sasiedzi.add((int) copy_matrix.get(i, j + 1));
        sasiedzi.add((int) copy_matrix.get(i - 1, j - 1));
        sasiedzi.add((int) copy_matrix.get(i - 1, j + 1));
        sasiedzi.add((int) copy_matrix.get(i - 1, j));
        sasiedzi.add((int) copy_matrix.get(i + 1, j - 1));
        sasiedzi.add((int) copy_matrix.get(i + 1, j + 1));
        sasiedzi.add((int) copy_matrix.get(i + 1, j));
        int liczba_sasiadow = (int) sasiedzi.stream().filter(w -> w == 1).count();

        if (mymatrix.get(i, j) == 1 && !S.contains(liczba_sasiadow)) {
            mymatrix.set(i, j, 0);

        } else if (mymatrix.get(i, j) == 0 && B.contains(liczba_sasiadow)) {
            mymatrix.set(i, j, 1);
        }


    }

    protected void sprawdzenie( int i, int j, int x, int z, ArrayList<Integer> sasiedzi) {

    }

}
