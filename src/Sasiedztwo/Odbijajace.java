package Sasiedztwo;

import Program.Mymatrix;

import java.util.ArrayList;

public class Odbijajace extends Sasiedztwo{
    public Odbijajace(Mymatrix mymatrix, ArrayList<Integer> s, ArrayList<Integer> b) {
        super(mymatrix, s, b);
    }

    @Override
    public void komorka_brzeg(int i, int j) {
        ArrayList<Integer> sasiedzi = new ArrayList<>();
        sprawdzenie(i,j,  i, j-1, sasiedzi );
        sprawdzenie(i,j,  i, j+1, sasiedzi );
        sprawdzenie(i,j,  i-1, j-1, sasiedzi );
        sprawdzenie(i,j,  i-1, j+1, sasiedzi );
        sprawdzenie(i,j,  i-1, j, sasiedzi );
        sprawdzenie(i,j,  i+1, j-1, sasiedzi );
        sprawdzenie(i,j,  i+1, j+1, sasiedzi );
        sprawdzenie(i,j,  i+1, j, sasiedzi );

        int liczba_sasiadow = (int) sasiedzi.stream().filter(w-> w==1).count();

        if(mymatrix.get(i,j) ==1 && !S.contains(liczba_sasiadow)){
            mymatrix.set(i,j,0);

        } else if (mymatrix.get(i,j) ==0 && B.contains(liczba_sasiadow)) {
            mymatrix.set(i,j,1);
        }


    }

    @Override
    protected void sprawdzenie(int i, int j, int x, int z, ArrayList<Integer> sasiedzi) {

        if (x < 0 || copy_matrix.numRows() <= x || z < 0 || z >= copy_matrix.numCols()) {
            if (copy_matrix.get(i, j) == 1) {
                sasiedzi.add(0);
            } else {
                sasiedzi.add(1);
            }

        }else{sasiedzi.add((int) copy_matrix.get(x,z));}
    }
}
