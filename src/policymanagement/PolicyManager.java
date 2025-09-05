package policymanagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class PolicyManager {
    private List<Policy> policies = new ArrayList<>();
    public void readPolicies(String inputFile) {
        try (BufferedReader reader = new BufferedReader(
                new FileReader( inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    String policyId = data[0].trim();
                    String holderName = data[1].trim();
                    int amount = Integer.parseInt(data[2].trim());
                    policies.add(new Policy(policyId, holderName,
                            amount));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeSummary(String outputFile) {
        int totalPolicies = policies.size();
        int totalAmount =
                policies.stream().mapToInt(Policy::getAmount).sum();
        try (BufferedWriter writer = new BufferedWriter(new
                FileWriter(outputFile))) {
            writer.write("Total Number of Policies: " +
                    totalPolicies);
            writer.newLine();
            writer.write("Total Policy Amount: " + totalAmount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}