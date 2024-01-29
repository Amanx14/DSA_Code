import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryString {
    public static List<String> generateBinaryStrings(int length) {
        List<String> binaryStrings = new ArrayList<>();
        generateStringsHelper("", length, binaryStrings);
        return binaryStrings;
    }

    private static void generateStringsHelper(String currentString, int length, List<String> binaryStrings) {
        if (currentString.length() == length) {
            binaryStrings.add(currentString);
            return;
        }
        
        // Append '0' to the current string and continue
        generateStringsHelper(currentString + "0", length, binaryStrings);

        // Only append '1' if the current string doesn't end with '1'
        if (!currentString.endsWith("1")) {
            generateStringsHelper(currentString + "1", length, binaryStrings);
        }
    }

    public static void main(String[] args) {
        int length = 4; // Change this to the desired length
        List<String> binaryStrings = generateBinaryStrings(length);
        for (String string : binaryStrings) {
            System.out.println(string);
        }
    }
}
