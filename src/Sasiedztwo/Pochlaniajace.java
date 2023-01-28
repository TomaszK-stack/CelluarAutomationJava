package Sasiedztwo;

import org.ejml.simple.SimpleMatrix;

import java.util.ArrayList;

public class Pochlaniajace extends Odbijajace{
    public Pochlaniajace(SimpleMatrix simpleMatrix, ArrayList<Integer> s, ArrayList<Integer> b) {
        super(simpleMatrix, s, b);
    }

    @Override
    protected void sprawdzenie(int i, int j, int x, int z, ArrayList<Integer> sasiedzi) {

        if (x < 0 || copy_matrix.numRows() <= x || z < 0 || z >= copy_matrix.numCols()) {
           sasiedzi.add(0);

        }else{sasiedzi.add((int) copy_matrix.get(x,z));}


    }
}

