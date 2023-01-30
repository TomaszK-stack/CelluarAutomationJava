package Sasiedztwo;

import Program.MatrixButtons;
import org.ejml.simple.SimpleMatrix;
import Program.MatrixButtons.*;

import java.net.SocketImpl;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Sasiedztwo {
    SimpleMatrix simpleMatrix;
    SimpleMatrix copy_matrix;
    ArrayList<Integer> S;
    ArrayList<Integer> B;

    public Sasiedztwo(SimpleMatrix simpleMatrix, ArrayList<Integer> s, ArrayList<Integer> b) {


        this.simpleMatrix = simpleMatrix;
        this.copy_matrix = new SimpleMatrix(simpleMatrix);
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
            copy_matrix = new SimpleMatrix(simpleMatrix);

            for (int i = 0; i < simpleMatrix.numRows(); i++) {
                for (int j = 0; j < simpleMatrix.numRows(); j++) {
                    if (i == 0 || j == 0 || i == simpleMatrix.numRows() - 1 || j == simpleMatrix.numCols() - 1) {
                        komorka_brzeg(i, j);

                    } else {
                        komorka_srodek(i, j);
                    }


                }
            }

            System.out.println();
            MatrixButtons.printmatrix(simpleMatrix);
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

        if (simpleMatrix.get(i, j) == 1 && !S.contains(liczba_sasiadow)) {
            simpleMatrix.set(i, j, 0);

        } else if (simpleMatrix.get(i, j) == 0 && B.contains(liczba_sasiadow)) {
            simpleMatrix.set(i, j, 1);
        }


    }

    protected void sprawdzenie( int i, int j, int x, int z, ArrayList<Integer> sasiedzi) {

    }

}
