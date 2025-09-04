package fileio;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyTheContents {
    public static void main(String[] args) {

        try (FileReader fr = new FileReader("source.txt");
             FileWriter fw = new FileWriter("destination.txt")) {

            int c;

            while ((c = fr.read()) != -1) {
                fw.write(c);
            }

            System.out.println("Contents copied successfully from source.txt to destination.txt");

        } catch (IOException e) {
            System.out.println("An error occurred while copying the file: " + e.getMessage());
        }
    }
}
