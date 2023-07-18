package desafio;

import java.util.Scanner;

public class Wildcards {
    public static boolean Wildcards(String pattern, String str) {
        int patternIndex = 0;
        int strIndex = 0;

        while (patternIndex < pattern.length()) {
            if (strIndex >= str.length()) {
                if (pattern.charAt(patternIndex) == '*' && patternIndex < pattern.length() - 1 && pattern.charAt(patternIndex + 1) == '{' && pattern.charAt(patternIndex + 3) == '}') {
                    int repeatCount = Character.getNumericValue(pattern.charAt(patternIndex + 2));
                    patternIndex += 4;
                    if (repeatCount > 0) {
                        continue;
                    }
                }
                return false;
            }

            char patternChar = pattern.charAt(patternIndex);
            char strChar = str.charAt(strIndex);

            if (patternChar == '+') {
                if (!Character.isLetter(strChar))
                    return false;

            } else if (patternChar == '$') {
                if (!Character.isDigit(strChar) || strChar == '0')
                    return false;

            } else if (patternChar == '*') {
                int repeatCount = 3;

                if (patternIndex < pattern.length() - 3 && pattern.charAt(patternIndex + 1) == '{' && pattern.charAt(patternIndex + 3) == '}') {
                    repeatCount = Character.getNumericValue(pattern.charAt(patternIndex + 2));
                    patternIndex += 3;
                }
                for (int i = 0; i < repeatCount; i++) {
                    if (strIndex >= str.length() || str.charAt(strIndex) != strChar)
                        return false;
                    strIndex++;
                }
                patternIndex++;
                continue;
            } else {
                if (patternChar != strChar)
                    return false;
            }
            patternIndex++;
            strIndex++;
        }

        if (strIndex < str.length())
            return false;

        return true;
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine();
        String[] parts = input.split(" ");
        System.out.print("Output: " +Wildcards(parts[0], parts[1]));
        scanner.close();
    }

}
