package com.anastasiia.exam2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AnagramFromFile {


    public static void main(String[] args) {
        AnagramFromFile anagramFromFile = new AnagramFromFile();
        List<String> lines = anagramFromFile.readFileLines("anagramy.txt");
        List<String> anagrams = new ArrayList<>();

        for (int i = 0; i < lines.size(); i++) {
            String[] pairs = lines.get(i).split(" ");
            if (anagramFromFile.areAnagram(pairs[0].toCharArray(), pairs[1].toCharArray())) {
                anagrams.add(String.format("%d %s", i, lines.get(i)));
            }
        }

        anagramFromFile.writeAnagramsToFile("result.txt", anagrams);
    }

    public List<String> readFileLines(String fileName) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                lines.add(currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public void writeAnagramsToFile(String fileName, List<String> anagrams) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String anagram : anagrams) {
                writer.write(anagram + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    boolean areAnagram(char[] wordArr1, char[] wordArr2) {

        int len1 = wordArr1.length;
        int len2 = wordArr2.length;

        if (len1 != len2) {
            return false;
        }

        sort(wordArr1);
        sort(wordArr2);


        for (int i = 0; i < len1; i++) {
            if (wordArr1[i] != wordArr2[i]) {
                return false;
            }
        }
        return true;
    }

    void sort(char[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            char key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
