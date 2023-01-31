package Program;

import Sasiedztwo.Sasiedztwo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldFrame extends JFrame {

    private JTextArea textField;
    private JButton button;
    int[][] array;
    Sasiedztwo sasiedztwo;

    public TextFieldFrame(Sasiedztwo sasiedztwo) {
        this.array = sasiedztwo.mymatrix.my_matrix;
        setTitle("Text Field Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(450,400));

        textField = new JTextArea();
        textField.setFont(new Font("Arial", Font.PLAIN, 25));
        add(textField, BorderLayout.CENTER);

        button = new JButton("Następny krok");
        add(button, BorderLayout.SOUTH);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sasiedztwo.program_glowny();
                displayArray();
            }
        });
        displayArray();
        pack();
        setVisible(true);
    }

    private void displayArray() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : array) {
            for (int value : row) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
        }
        textField.setText(sb.toString());
    }

    public static void main(String[] args) {
//        new TextFieldFrame(new int[10][10]);
    }
}