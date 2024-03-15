package org.Picnic.Controller;

import org.Picnic.Model.Products;
import org.Picnic.Model.RandomProducts;
import org.Picnic.View.View;

public class Controller {
    public Controller(String fileName, int wordCount) {
        //Если список и кол-во предметов менять не нужно
        //Строку ниже можно закомментировать
        new RandomProducts(fileName, wordCount);

        Products products = new Products(fileName);

        View.printHelloMessage(fileName);
        View.printWordFrequency(products);
        View.printWordCount(
                products.getWordCount());
        View.printLongestWord(
                products.getLongestWord());
    }
}
