package Program;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import Program.Mymatrix;
import javax.swing.*;
import Sasiedztwo.Odbijajace;
import Sasiedztwo.Pochlaniajace;
import Sasiedztwo.Przenikajace;


public class MatrixButtons {
    private JFrame frame;

    private JPanel buttonPanel;
    private Mymatrix matrix;
    private JTextField matrixTextField;

    public MatrixButtons(int rows, int cols) {
        matrix = new Mymatrix(rows, cols);

        // Create the GUI
        frame = new JFrame("Matrix Buttons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create the button panel
        buttonPanel = new JPanel(new GridLayout(rows, cols));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                JButton button = new JButton("0");
                button.addActionListener(new ButtonListener(i, j));
                buttonPanel.add(button);
            }
        }

        matrixTextField = new JTextField();
        matrixTextField.setEditable(false);

        JButton doneButton = new JButton("DONE");
        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                program_glowny();
            }
        });

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(matrixTextField, BorderLayout.NORTH);
        frame.add(doneButton, BorderLayout.SOUTH);

        // Show the frame
        frame.pack();
        frame.setVisible(true);
        frame.setPreferredSize(new Dimension(400, 400));
    }

    private class ButtonListener implements ActionListener {
        private int row;
        private int col;

        public ButtonListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("0")) {
                matrix.set(row, col, 1);
                button.setText("1");
            } else {
                matrix.set(row, col, 0);
                button.setText("0");
            }
            matrixTextField.setText(matrix.toString());
        }
    }

    public static void main(String[] args) {
        new MatrixButtons(10, 10);
    }

    public void program_glowny() {
        System.out.println("twoja macierz to ");
        printmatrix(matrix);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Teraz wybierz warunek brzegowy pochłaniający = p, przenikający - s , odbijający - o");
        String warunek = scanner.nextLine();

        while (!warunek.equals("s") && !warunek.equals("o") && !warunek.equals("p")) {
            System.out.println("Podaj prawidłową wartość");
            warunek = scanner.nextLine();

        }
        System.out.println("Czy chcesz zmienić wartość zbioró S i B? chcę podawać - t, nie chce - n (Domyślne wartości to (2,3), (3))");
        String line = scanner.nextLine();
        while (!line.equals("n") && !line.equals("t")) {
            System.out.println("Podaj prawidłową wartość");
            line = scanner.nextLine();

        }
        String S;
        String B;
        ArrayList<Integer> zbior_S = new ArrayList<>();
        ArrayList<Integer> zbior_B = new ArrayList<>();
        if (line.equals("t")) {
            System.out.println("Podaj wartość zbioru S");
            S = scanner.nextLine();
            System.out.println("Podaj wartość zbioru B");

            B = scanner.nextLine();

            Arrays.stream(S.split(",")).forEach(e -> zbior_S.add(Integer.parseInt(e)));
            Arrays.stream(B.split(",")).forEach(c -> zbior_B.add(Integer.parseInt(c)));
            System.out.println(zbior_S);
            System.out.println(zbior_B);
        }else{
            zbior_S.add(2);
            zbior_S.add(3);
            zbior_B.add(3);
        }
        if(warunek.equals("s")){
            Przenikajace przenikajace = new Przenikajace(matrix, zbior_S, zbior_B);

        }else if(warunek.equals("o")){
            Odbijajace odbijajace = new Odbijajace(matrix, zbior_S, zbior_B);
        }else{
            Pochlaniajace pochlaniajace = new Pochlaniajace(matrix, zbior_S, zbior_B);

        }

    }

    public static void printmatrix(Mymatrix simpleMatrix) {
        DecimalFormat decimalFormat = new DecimalFormat("0");

        for (int i = 0; i < simpleMatrix.numRows(); i++) {
            for (int j = 0; j < simpleMatrix.numCols(); j++) {
                System.out.printf(decimalFormat.format(simpleMatrix.get(i, j)));

            }
            System.out.println();
        }


    }


}