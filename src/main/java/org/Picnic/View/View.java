package org.Picnic.View;

import org.Picnic.Model.Products;

public abstract class View {
    public static void printHelloMessage(String fileName) {
        System.out.println(
                "Производится анализ взятого на пикник из файла: " +
                fileName + "\n");
    }

    public static void printWordFrequency(Products products) {
        System.out.println(products);
    }

    public static void printWordCount(int wordCount) {
        System.out.println(
                "────────────────────────────────────────────────────────────\n" +
                "Всего на пикник взято: " + wordCount + " шт.");
    }
    public static void printLongestWord(String longestWord) {
        System.out.println(
                "Продукт с самым длинным именем: " + longestWord);
    }
}
