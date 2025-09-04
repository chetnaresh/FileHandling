package bufferstreams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyingData {
    public static void main(String[] args) {
        String sourceFile = "src/bufftextfiles/source";
        String destinationFile = "src/bufftextfiles/destination";


        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(destinationFile))) {

            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }

            System.out.println("File copied successfully from " + sourceFile + " to " + destinationFile);

        } catch (IOException e) {
            System.out.println("Error occurred while copying file.");
            e.printStackTrace();
        }
    }
}
