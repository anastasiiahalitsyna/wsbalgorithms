package com.anastasiia.exam4;

import java.util.Scanner;

public class KodCezara {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("please enter the text: ");
        String input = scanner.nextLine();
        System.out.print("please enter the offset to encrypt: ");
        int offset = scanner.nextInt();
        String encryptedInput = encrypt(input, offset);
        System.out.printf("Encrypted into: %s\n", encryptedInput);
        String decrypted = decrypt(encryptedInput, offset);
        System.out.printf("Decrypted into: %s\n", decrypted);
    }


    public static String encrypt(String message, int offset) {
        StringBuilder encrypted = new StringBuilder();
        for (char character : message.toCharArray()) {
            if (character != ' ') {
                if (Character.isLowerCase(character)) {
                    int pos = character - 'a';
                    int newPos = (pos + offset) % 26;
                    char newChar = (char) ('a' + newPos);
                    encrypted.append(newChar);
                } else {
                    int pos = character - 'A';
                    int newPos = (pos + offset) % 26;
                    char newChar = (char) ('A' + newPos);
                    encrypted.append(newChar);
                }
            } else {
                encrypted.append(character);
            }
        }
        return encrypted.toString();
    }

    public static String decrypt(String message, int offset) {
        return encrypt(message, 26 - (offset % 26));
    }
}
