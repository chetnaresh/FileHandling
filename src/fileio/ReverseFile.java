package fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReverseFile {
    public static void main(String[] args) {
        String inputFile = "src/textfiles/input";
        String outputFile = "src/textfiles/reversed";

        StringBuilder content = new StringBuilder();


        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
            return;
        }


        content.reverse();


        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write(content.toString());
            System.out.println("Reversed content has been written to " + outputFile);
        } catch (IOException e) {
            System.out.println("An error occurred while writing the file.");
            e.printStackTrace();
        }
    }
}
