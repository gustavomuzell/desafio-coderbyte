package desafio;

import java.util.Scanner;

public class TetrisMove {


    public static int TetrisMove(String[] strArr) {
        String piece = strArr[0];
        int [] levels = new int[12];

        for(int i = 0; i < 12; i++) {
            levels[i] = Integer.parseInt(strArr[i + 1]);
        }

        int maxHeight = Integer.MAX_VALUE;

        switch (piece) {
            case "I":
                maxHeight = Math.min(maxHeight, calculateMaxHeightI(levels));
                break;
            case "J":
                maxHeight = Math.min(maxHeight, calculateMaxHeightJ(levels));
                break;
            case "L":
                maxHeight = Math.min(maxHeight, calculateMaxHeightL(levels));
                break;
            case "O":
                maxHeight = Math.min(maxHeight, calculateMaxHeightO(levels));
                break;
            case "S":
                maxHeight = Math.min(maxHeight, calculateMaxHeightS(levels));
                break;
            case "T":
                maxHeight = Math.min(maxHeight, calculateMaxHeightT(levels));
                break;
            case "Z":
                maxHeight = Math.min(maxHeight, calculateMaxHeightZ(levels));
                break;
        }
        return Math.min(maxHeight, 4);

    }

    private static int calculateMaxHeightI(int [] levels) {
        return findMin(levels);
    }

    private static int calculateMaxHeightJ(int [] levels) {
        int maxHeight = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++) {
            maxHeight = Math.min(maxHeight, levels[i]);
        }
        for(int i = 4; i < 12; i++) {
            maxHeight = Math.min(maxHeight, levels[i] + 1);
        }
        return maxHeight;
    }

    private static int calculateMaxHeightL(int [] levels) {
        int maxHeight = Integer.MAX_VALUE;
        for(int i = 4; i < 12; i++) {
            maxHeight = Math.min(maxHeight, levels[i] + 1);
        }
        for(int i = 0; i < 4; i++) {
            maxHeight = Math.min(maxHeight, levels[i]);
        }
        return maxHeight;
    }

    private static int calculateMaxHeightO(int [] levels) {
        int maxHeight = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++) {
            maxHeight = Math.min(maxHeight, levels[i]);
            maxHeight = Math.min(maxHeight, levels[i + 4]);
        }
        return maxHeight;
    }

    private static int calculateMaxHeightS(int [] levels) {
        int maxHeight = Integer.MAX_VALUE;
        for(int i = 0; i < 8; i++) {
            maxHeight = Math.min(maxHeight, levels[i]);
        }
        for(int i = 8; i < 12; i++) {
            maxHeight = Math.min(maxHeight, levels[i] + 1);
        }
        return maxHeight;
    }

    private static int calculateMaxHeightT(int [] levels) {
        int maxHeight = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++) {
            maxHeight = Math.min(maxHeight, levels[i] + 1);
        }
        for(int i = 4; i < 8; i++) {
            maxHeight = Math.min(maxHeight, levels[i]);
        }
        for(int i = 8; i < 12; i++) {
            maxHeight = Math.max(maxHeight, levels[i] + 1);
        }
        return maxHeight;
    }

    private static int calculateMaxHeightZ(int [] levels) {
        int maxHeight = Integer.MAX_VALUE;
        for(int i = 0; i < 8; i++) {
            maxHeight = Math.min(maxHeight, levels[i] + 1);
        }
        for(int i = 8; i < 12; i++) {
            maxHeight = Math.min(maxHeight, levels[i]);
        }
        return maxHeight;
    }

    private static int findMin(int [] array) {
        int min = Integer.MAX_VALUE;
        for (int value: array) {
            min = Math.min(min, value);
        }
        return min;
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");

        if(scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] strArr = input.split("\\s+ ");

            int maxCompletedLines = TetrisMove(strArr);
            System.out.println("Output:" + maxCompletedLines);
        } else {
            System.out.println("No input found.");
        }

        scanner.close();

    }
    }

