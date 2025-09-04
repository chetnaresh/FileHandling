package bufferstreams;



import java.io.*;

public class MergingFiles {
    public static void main(String[] args) {
        // Input files
        String[] inputFiles = {
               "src/bufftextfiles/file1",
                "src/bufftextfiles/file2",
                "src/bufftextfiles/file3"

        };

        // Output file
        String outputFile = "src/bufftextfiles/merge_feedback";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (String inputFile : inputFiles) {
                try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        writer.write(line);
                        writer.newLine();
                    }
                }
            }
            System.out.println("Files merged successfully into: " + outputFile);
        } catch (IOException e) {
            System.out.println("An error occurred while merging files.");
            e.printStackTrace();
        }
    }
}
