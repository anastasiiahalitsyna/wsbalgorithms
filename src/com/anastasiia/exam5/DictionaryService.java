package com.anastasiia.exam5;

import java.util.HashMap;
import java.util.Map;

public class DictionaryService {

    public String getDictionary(String input) {
        char[] chars = input.toCharArray();
        sort(chars);
        StringBuilder dictionary = new StringBuilder();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] != chars[i + 1]) {
                dictionary.append(chars[i]);
            }
        }
        return dictionary.append(chars[chars.length - 1]).toString();
    }

    public Map<Character, String> getSymbolToBinaryDictionary(String dictionary, int bitsPerChar) {
        Map<Character, String> binaryMapping = new HashMap<>();
        NumberSystemConverter numberSystemConverter = new NumberSystemConverter();
        for (int i = 0; i < dictionary.length(); i++) {
            String binary = numberSystemConverter.decimalToBinary(i, bitsPerChar);
            binaryMapping.put(dictionary.charAt(i), binary);
        }
        return binaryMapping;
    }

    private void sort(char[] arr) {

        int len = arr.length;
        char[] output = new char[len];

        int[] count = new int[128];
        for (int i = 0; i < 128; ++i)
            count[i] = 0;

        for (int i = 0; i < len; ++i) {
            ++count[arr[i]];
        }


        for (int i = 1; i <= 127; ++i) {
            count[i] += count[i - 1];
        }


        for (int i = len - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            --count[arr[i]];
        }

        for (int i = 0; i < len; ++i) {
            arr[i] = output[i];
        }
    }

}
