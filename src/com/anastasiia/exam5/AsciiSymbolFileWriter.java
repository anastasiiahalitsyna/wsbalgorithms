package com.anastasiia.exam5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class AsciiSymbolFileWriter {

    public void writeLengthIntoFile(String input) {
        DictionaryService task2 = new DictionaryService();
        int countDistinct = task2.getDictionary(input).length();
        char asciiSymbol = (char) countDistinct;
        byte[] bytes = String.valueOf(asciiSymbol).getBytes();
        try {
            Files.write(Paths.get("src/com/anastasiia/exam5/ascii_output.txt"),
                    bytes,
                    StandardOpenOption.TRUNCATE_EXISTING,
                    StandardOpenOption.WRITE,
                    StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
