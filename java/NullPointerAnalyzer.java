public class NullPointerAnalyzer {
    public static void analyzeCode(String code) {
        String[] lines = code.split("\n");

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i].trim();

            // Check for null checks followed by usage
            if (line.contains("!= null") || line.contains("== null")) {
                String variable = extractVariableName(line);
                checkVariableUsage(lines, i + 1, variable);
            }
        }
    }

    private static String extractVariableName(String line) {
        String[] parts = line.split("!=|==");
        return parts[0].trim();
    }

    private static void checkVariableUsage(String[] lines, int startIndex, String variable) {
        for (int i = startIndex; i < lines.length; i++) {
            String line = lines[i].trim();
            if (line.contains(variable + ".") && !line.contains("null")) {
                System.out.println("Potential NullPointerException at line " + (i + 1));
            }
        }
    }

    public static void main(String[] args) {
        String sampleCode = "Object obj = null;\n" +
                "if (obj != null) {\n" +
                "    obj.toString();\n" +
                "} else {\n" +
                "    obj.toString();\n" +
                "}";
        analyzeCode(sampleCode);
    }
}