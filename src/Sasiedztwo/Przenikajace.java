package Sasiedztwo;

import org.ejml.simple.SimpleMatrix;

import java.util.ArrayList;

public class Przenikajace extends Sasiedztwo{
    public Przenikajace(SimpleMatrix simpleMatrix, ArrayList<Integer> s, ArrayList<Integer> b) {
        super(simpleMatrix, s, b);
    }

    @Override
    public void komorka_brzeg(int i, int j) {


            ArrayList<Integer> sasiedzi = new ArrayList<>();
            // Add neighboring cells to the ArrayList, taking into account the cells at the opposite edge of the matrix
            sasiedzi.add((int) copy_matrix.get((i-1+simpleMatrix.numRows())%simpleMatrix.numRows(), (j-1+simpleMatrix.numCols())%simpleMatrix.numCols()));
            sasiedzi.add((int) copy_matrix.get((i-1+simpleMatrix.numRows())%simpleMatrix.numRows(), j));
            sasiedzi.add((int) copy_matrix.get((i-1+simpleMatrix.numRows())%simpleMatrix.numRows(), (j+1)%simpleMatrix.numCols()));
            sasiedzi.add((int) copy_matrix.get(i, (j-1+simpleMatrix.numCols())%simpleMatrix.numCols()));
            sasiedzi.add((int) copy_matrix.get(i, (j+1)%simpleMatrix.numCols()));
            sasiedzi.add((int) copy_matrix.get((i+1)%simpleMatrix.numRows(), (j-1+simpleMatrix.numCols())%simpleMatrix.numCols()));
            sasiedzi.add((int) copy_matrix.get((i+1)%simpleMatrix.numRows(), j));
            sasiedzi.add((int) copy_matrix.get((i+1)%simpleMatrix.numRows(), (j+1)%simpleMatrix.numCols()));
        int liczba_sasiadow = (int) sasiedzi.stream().filter(w-> w==1).count();

        if(simpleMatrix.get(i,j) ==1 && !S.contains(liczba_sasiadow)){
            simpleMatrix.set(i,j,0);

        } else if (simpleMatrix.get(i,j) ==0 && B.contains(liczba_sasiadow)) {
            simpleMatrix.set(i,j,1);
        }




    }


}
