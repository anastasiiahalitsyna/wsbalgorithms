package com.anastasiia.exam4;

public class DecimalBinaryConverter {

    public static void main(String[] args) {
        System.out.println(convertBinaryToDecimal("1010100101"));
        System.out.println(convertDecimalToBinary(677));
    }

    public static long convertDecimalToBinary(int number) {
        long binaryNumber = 0;
        int remainder, i = 1;

        while (number != 0) {
            remainder = number % 2;
            number /= 2;
            binaryNumber += remainder * i;
            i *= 10;
        }

        return binaryNumber;
    }

    public static int convertBinaryToDecimal(String binary) {
        int decimal = 0;
        int base = 1;

        int len = binary.length();
        for (int i = len - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                decimal += base;
            }
            base = base * 2;
        }
        return decimal;
    }

}
