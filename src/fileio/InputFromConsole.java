package fileio;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class InputFromConsole {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "src/textfiles/user_input.txt";

        System.out.println("Enter some text (type 'exit' to stop):");

        try (FileWriter writer = new FileWriter(fileName)) {
            while (true) {
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                writer.write(input + System.lineSeparator());
            }
            System.out.println("User input has been written to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
