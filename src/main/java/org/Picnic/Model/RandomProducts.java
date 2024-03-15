package org.Picnic.Model;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomProducts {
    private final String fileName;
    public RandomProducts(String fileName, int wordCount) {
        this.fileName = fileName;

        String randomProductString = generateRandomProductString(wordCount);
        createRandomProductFile(randomProductString);
    }

    private String generateRandomProductString(int wordCount) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        int productCount = ProductList.list.size();
        for (int i = 0; i < wordCount; i++) {
            int indexProduct = random.nextInt(productCount);
            sb.append(ProductList.list.get(indexProduct));
            sb.append(",");
        }
        return sb.toString();
    }

    private void createRandomProductFile(String randomString) {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(
                        "src/main/java/org/Picnic/Model/" +
                                fileName,
                        false))) {
            writer.write(randomString);
            System.out.println("Случайные данные о продуктах записаны в файл: /Model/" + fileName);
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
