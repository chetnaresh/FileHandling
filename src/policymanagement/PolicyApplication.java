package policymanagement;

public class PolicyApplication {
    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();
        manager.readPolicies("src/policymanagement/policies");
        manager.writeSummary("src/policymanagement/summary");
    }
}