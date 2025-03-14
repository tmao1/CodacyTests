public class ComplexityAnalyzer {
    private int complexity = 1; // Base complexity is 1

    public int calculateComplexity(String methodCode) {
        complexity = 1; // Reset for each method
        String[] lines = methodCode.split("\n");

        for (String line : lines) {
            line = line.trim();
            // Count decision points
            if (line.contains("if ") || line.contains("else if")) {
                complexity++;
            }
            if (line.contains("for ") || line.contains("while ")) {
                complexity++;
            }
            if (line.contains("case ")) {
                complexity++;
            }
            if (line.contains("&&") || line.contains("||")) {
                complexity++;
            }
        }
        return complexity;
    }

    public void analyzeMethod(String methodCode) {
        int complexityScore = calculateComplexity(methodCode);
        System.out.println("Cyclomatic Complexity: " + complexityScore);
        if (complexityScore > 10) {
            System.out.println("Warning: Method complexity exceeds recommended threshold");
        }
    }
}