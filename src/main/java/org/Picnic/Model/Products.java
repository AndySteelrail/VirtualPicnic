package org.Picnic.Model;


import java.io.*;
import java.util.*;

public class Products {
    private final String fileName;
    private final HashMap<String, Integer> productsMap;
    public Products(String fileName) {
        this.fileName = fileName;

        String productsString = getStringFromFile();
        this.productsMap = createProductsMap(productsString);
    }

    private String getStringFromFile() {
        String line = null;
        try (BufferedReader reader = new BufferedReader(
                new FileReader(
                        "src/main/java/org/Picnic/Model/" + fileName))) {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    private HashMap<String, Integer> createProductsMap(String productsString) {
        String[] productsArray = productsString.trim().split(",");
        HashMap<String, Integer> productsMap = new HashMap<>();

        for (String product : productsArray) {
            if (productsMap.containsKey(product)) {
                productsMap.put(
                        product,
                        productsMap.get(product) + 1);
            } else {
                productsMap.put(product, 1);
            }
        }
        return productsMap;
    }

    public int getWordCount() {
        int wordCount = 0;
        for (HashMap.Entry<String, Integer> product : productsMap.entrySet()) {
            wordCount += product.getValue();
        }
        return wordCount;
    }

    public String getLongestWord() {
        String longestWord = " ";
        for (HashMap.Entry<String, Integer> product : productsMap.entrySet()) {
            String word = product.getKey();
            if (word.length() > longestWord.length()) {
                longestWord = word;
            };
        }
        return longestWord;
    }

    @Override
    public String toString() {
        Set<Map.Entry<String, Integer>> set = productsMap.entrySet();
        Map.Entry<String, Integer>[] array = set.toArray(new Map.Entry[set.size()]);

        Arrays.sort(array,
                (a, b) -> Integer.signum(b.getValue() - a.getValue())
        );
        StringBuilder sb = new StringBuilder();
        sb.append("В наличии, в порядке убывания:");
        for (Map.Entry<String, Integer> item : array) {
            sb.append("\n");
            sb.append(item.getKey());
            sb.append(" - ");
            sb.append(item.getValue());
            sb.append(" шт.");
        }
        return sb.toString();
    }
}