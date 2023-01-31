package Sasiedztwo;

import Program.Mymatrix;


import java.util.ArrayList;

public class Przenikajace extends Sasiedztwo{
    public Przenikajace(Mymatrix mymatrix, ArrayList<Integer> s, ArrayList<Integer> b) {
        super(mymatrix, s, b);
    }

    @Override
    public void komorka_brzeg(int i, int j) {


            ArrayList<Integer> sasiedzi = new ArrayList<>();
            // Add neighboring cells to the ArrayList, taking into account the cells at the opposite edge of the matrix
            sasiedzi.add((int) copy_matrix.get((i-1+mymatrix.numRows())%mymatrix.numRows(), (j-1+mymatrix.numCols())%mymatrix.numCols()));
            sasiedzi.add((int) copy_matrix.get((i-1+mymatrix.numRows())%mymatrix.numRows(), j));
            sasiedzi.add((int) copy_matrix.get((i-1+mymatrix.numRows())%mymatrix.numRows(), (j+1)%mymatrix.numCols()));
            sasiedzi.add((int) copy_matrix.get(i, (j-1+mymatrix.numCols())%mymatrix.numCols()));
            sasiedzi.add((int) copy_matrix.get(i, (j+1)%mymatrix.numCols()));
            sasiedzi.add((int) copy_matrix.get((i+1)%mymatrix.numRows(), (j-1+mymatrix.numCols())%mymatrix.numCols()));
            sasiedzi.add((int) copy_matrix.get((i+1)%mymatrix.numRows(), j));
            sasiedzi.add((int) copy_matrix.get((i+1)%mymatrix.numRows(), (j+1)%mymatrix.numCols()));
        int liczba_sasiadow = (int) sasiedzi.stream().filter(w-> w==1).count();

        if(mymatrix.get(i,j) ==1 && !S.contains(liczba_sasiadow)){
            mymatrix.set(i,j,0);

        } else if (mymatrix.get(i,j) ==0 && B.contains(liczba_sasiadow)) {
            mymatrix.set(i,j,1);
        }




    }


}
