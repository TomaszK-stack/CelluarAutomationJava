package Program;

import java.util.Arrays;

public class Mymatrix {
    int[][] my_matrix;
    int row;
    int columns;

    public Mymatrix(Mymatrix mymatrix) {
        this.row = mymatrix.numRows();
        this.columns = mymatrix.numCols();
        this.my_matrix = Arrays.stream(mymatrix.my_matrix).map(int[]::clone).toArray(int[][]::new);
    }

    public static void main(String[] args){
        Mymatrix mymatrix = new Mymatrix(5,5);
        mymatrix.set(4,4,3);
        Mymatrix mymatrix1 = new Mymatrix(mymatrix);
        MatrixButtons.printmatrix(mymatrix1);
        mymatrix.set(4,4,4);
        MatrixButtons.printmatrix(mymatrix1);
    }

    public Mymatrix(int row, int columns) {
        this.row = row;
        this.columns = columns;
        this.my_matrix = new int[row][columns];
    }
    public int get(int i, int j){

        return my_matrix[i][j];

    }
    public void set(int i, int j, int value){
        my_matrix[i][j] = value;

    }
    public int numRows(){
        return this.my_matrix.length;
    }

    public int numCols(){
        return this.my_matrix[0].length;

    }


}
