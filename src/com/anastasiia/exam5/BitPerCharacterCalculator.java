package com.anastasiia.exam5;

public class BitPerCharacterCalculator {

    public int getNumberOfBitsForEncoding(String input) {
        DictionaryService task2 = new DictionaryService();
        int distinctNumber = task2.getDictionary(input).length();
        double perSymbol = Math.log(distinctNumber) / Math.log(2);
        return (int) Math.ceil(perSymbol);
    }

}


