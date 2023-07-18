package desafio;

import java.util.Scanner;

class PalindromicSubstring {
    public static String getSubstring(String str, int low, int high) {
        StringBuilder sb = new StringBuilder();
        for (int i = low; i <= high; ++i) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    static String longesPalSubstr(String str) {
        int n = str.length();

        int maxLenght = 1, start = 0;

        for(int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                int flag = 1;

                for(int k = 0; k <(j - i + 1) / 2; k++) {
                    if (str.charAt(i + k ) != str.charAt(j  - k)) {
                        flag = 0;
                    }
                }

                if (flag!= 0 &&(j - i + 1) > maxLenght) {
                    start = i;
                    maxLenght = j = i  + 1;
                }
            }
        }

        if (maxLenght > 2 ) {
            return getSubstring(str, start, start + maxLenght - 1);
        } else
            return "";
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input: ");
        String str = scanner.nextLine();
        scanner.close();

        String longesPalindrome = longesPalSubstr(str);
        if (!longesPalindrome.isEmpty()) {
            System.out.println("Output: " + longesPalindrome);
        }
        System.out.println("None: ");
    }
    }



