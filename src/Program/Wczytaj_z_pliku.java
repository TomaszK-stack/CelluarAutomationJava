package Program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Wczytaj_z_pliku {

    public static int[][] fileToArray(String fileName) throws IOException {
        int[][] result = null;
        try  {

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            int rows = 0;
            int cols = 0;
            if (line != null) {
                String[] parts = line.split(" ");
                rows = Integer.parseInt(parts[0]);
                cols = Integer.parseInt(parts[1]);
                result = new int[rows][cols];
                int row = 0;
                while ((line = reader.readLine()) != null) {
                    parts = line.split(" ");
                    for (int col = 0; col < cols; col++) {
                        result[row][col] = Integer.parseInt(parts[col]);
                    }
                    row++;
                }
            }
        }catch (IOException e){
            System.out.println(e);
        }
        return result;
    }


}