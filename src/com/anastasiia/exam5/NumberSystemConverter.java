package com.anastasiia.exam5;

public class NumberSystemConverter {

    public int binaryToDecimal(String binary) {
        double decimal = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                decimal += Math.pow(2, binary.length() - (1 + i));
            }
        }
        return (int) decimal;
    }

    public String decimalToBinary(int number, int maxLength) {
        int[] bits = new int[32];

        int i = 31;

        while (number > 0) {
            bits[i] = number % 2;
            number /= 2;
            i--;
        }

        StringBuilder binary = new StringBuilder();
        int startIndex = bits.length - maxLength;

        for (int j = startIndex; j < bits.length; j++) {
            binary.append(bits[j]);
        }

        return binary.toString();
    }
}
