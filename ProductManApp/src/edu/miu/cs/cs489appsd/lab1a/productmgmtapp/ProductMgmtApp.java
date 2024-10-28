package edu.miu.cs.cs489appsd.lab1a.productmgmtapp;

import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductMgmtApp {
    public static void main(String[] args) {

        List<Product> products= new ArrayList<>();

        // Adding products with data
        products.add(new Product(3128874119L, "Banana", LocalDate.parse("2023-01-24"), 124, 0.55));
        products.add(new Product(2927458265L, "Apple", LocalDate.parse("2022-12-09"), 18, 1.09));
        products.add(new Product(9189927460L, "Carrot", LocalDate.parse("2023-03-31"), 89, 2.99));

        printProducts(products);
    }

    private static void printProducts(List<Product> products){
        // Sort products by name using Stream API
        List<Product> sortedProducts = products.stream()
                .sorted(Comparator.comparing(Product::getName))
                .collect(Collectors.toList());

        System.out.println("JSON :");
        String jsonOutput = sortedProducts.stream()
                .map(product -> String.format("  {\"id\": \"%s\",   \"name\": \"%s\",    \"dateSupplied\": \"%s\",    \"quantityInStock\": %d,    \"unitPrice\": %.2f  }",
                        product.getProductId(), product.getName(), product.getDate(), product.getQuantityInStock(), product.getUnitPrice()))
                .collect(Collectors.joining(",\n", "[\n", "\n]"));
        System.out.println(jsonOutput);

        System.out.println("\nXML :");
        System.out.println("<?xml version=\"1.0\"?>");
        String xmlOutput = sortedProducts.stream()
                .map(product -> String.format("  <product>    <id>%s</id>    <name>%s</name>    <dateSupplied>%s</dateSupplied>    <quantityInStock>%d</quantityInStock>    <unitPrice>%.2f</unitPrice>  </product>",
                        product.getProductId(), product.getName(), product.getDate(), product.getQuantityInStock(), product.getUnitPrice()))
                .collect(Collectors.joining("\n", "<products>\n", "\n</products>"));
        System.out.println(xmlOutput);

        System.out.println("\nCSV :");
        String csvHeader = "Id,Name,DateSupplied,QuantityInStock,UnitPrice";
        String csvOutput = sortedProducts.stream()
                .map(product -> String.format("%s,%s,%s,%d,%.2f",
                        product.getProductId(), product.getName(), product.getDate(), product.getQuantityInStock(), product.getUnitPrice()))
                .collect(Collectors.joining("\n", csvHeader + "\n", ""));
        System.out.println(csvOutput);
    }
}
