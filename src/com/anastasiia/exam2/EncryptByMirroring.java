package com.anastasiia.exam2;

public class EncryptByMirroring {

    public static void main(String[] args) {
        System.out.println(encodeDecode("Anna ma psa."));
        System.out.println(encodeDecode(".asp am annA"));
    }


    static String encodeDecode(String input) {
        String result = "";
        char[] chars = input.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            result = result + chars[i];
        }
        return result;
    }

}
