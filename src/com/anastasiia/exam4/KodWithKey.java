package com.anastasiia.exam4;

public class KodWithKey {

    public static void main(String[] args) {
        System.out.println(encrypt("ALA MA KOTA","PIES"));
    }

    public static String encrypt(String input, String key) {
        char[] original = input.toCharArray();
        char[] encrypted = new char[input.length()];
        char[] keyArr = key.toCharArray();
        int keyIndex = 0;

        for (int i = 0; i < original.length; i++) {

            if (keyIndex >= keyArr.length) {
                keyIndex = 0;
            }

            if (original[i] != ' ') {
                encrypted[i] = keyArr[keyIndex++];
            } else {
                encrypted[i] = original[i];
            }

        }

        return new String(encrypted);
    }
}
