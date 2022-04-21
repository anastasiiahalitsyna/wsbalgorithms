package com.anastasiia.exam5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class Exam5Application {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/com/anastasiia/exam5/input_to_encode.txt"));

        StringJoiner joiner = new StringJoiner("\n");
        for (String line : lines) {
            joiner.add(line);
        }


        final String inputToEncode = joiner.toString();

        DictionaryService dictionaryService = new DictionaryService();
        final String dictionary = dictionaryService.getDictionary(inputToEncode);
        System.out.println("Slownik: " + dictionary);

        InputSizeService inputSizeService = new InputSizeService();
        final int L = inputSizeService.countTheNumberOfSymbols(inputToEncode);
        System.out.println("Dlugosc tekstu przed kompresja: " + L);


        final int X = dictionary.length();
        System.out.println("Unikalnych liter: " + X);


        BitPerCharacterCalculator bitPerCharacterCalculator = new BitPerCharacterCalculator();
        final int N = bitPerCharacterCalculator.getNumberOfBitsForEncoding(inputToEncode);
        System.out.println("Liczba bitow na znak: " + N);


        AsciiSymbolFileWriter asciiSymbolFileWriter = new AsciiSymbolFileWriter();
        asciiSymbolFileWriter.writeLengthIntoFile(inputToEncode);


        final int R = (8 - (L * N + 3) % 8) % 8;
        System.out.println("Liczba nadmiarowych 1: " + R);

        Map<Character, String> symbolToBinaryDictionary = dictionaryService.getSymbolToBinaryDictionary(dictionary, N);

        NumberSystemConverter numberSystemConverter = new NumberSystemConverter();
        String binaryPrefix = numberSystemConverter.decimalToBinary(R, 3);

        StringBuilder binaryCompressed = new StringBuilder(binaryPrefix);
        int bitCapacity = 5;

        for (int i = 0; i < inputToEncode.length(); i++) {
            String binaryForSymbol = symbolToBinaryDictionary.get(inputToEncode.charAt(i));
            for (int j = 0; j < binaryForSymbol.length(); j++) {
                binaryCompressed.append(binaryForSymbol.charAt(j));
                bitCapacity--;
                if (bitCapacity == 0) {
                    bitCapacity = 8;
                    binaryCompressed.append(" ");
                }
            }
        }

        for (int i = 0; i < R; i++) {
            binaryCompressed.append('1');
        }

        System.out.println(binaryCompressed);

        String[] splitedBinary = binaryCompressed.toString().split(" ");

        int[] decimalArr = new int[splitedBinary.length];

        for (int i = 0; i < splitedBinary.length; i++) {
            decimalArr[i] = numberSystemConverter.binaryToDecimal(splitedBinary[i]);
        }

        for (int i = 0; i < decimalArr.length; i++) {
            System.out.printf("%d ", decimalArr[i]);
        }
        System.out.println();

        StringBuilder compressedOutput = new StringBuilder();
        for (int element : decimalArr) {
            char asciiSymbol = (char) element;
            compressedOutput.append(asciiSymbol);
        }
        System.out.printf("Skompresowany tekst: %s%s\n", dictionary, compressedOutput);
        System.out.println("Dlugosc tekstu po kompresji: " + compressedOutput.length());
    }
}
