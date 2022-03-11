package com.anastasiia.exam2;

public class ApproximatePalindrome {

    public static void main(String[] args) {
        String input = "CABCBAB";

        int totalNumberOfPairs = input.length() / 2;

        int difResult = isApproximatePalindrome(input);

        if (difResult == 0) {
            System.out.println("Dokładny palindrom");
        } else if (difResult < totalNumberOfPairs) {
            System.out.println( "Palindrom przybliżony i " + difResult + "  par znaków się różni");
        } else {
            System.out.println("Nie jest palindromem");
        }
    }


    static int isApproximatePalindrome(String input) {

        char[] chars = input.toCharArray();
        int len = chars.length;
        int diff = 0;
        for (int i = 0; i < len / 2; i++) {
            if (chars[i] != chars[len - i - 1]) {
                diff++;
            }
        }

        return diff;
    }

}
