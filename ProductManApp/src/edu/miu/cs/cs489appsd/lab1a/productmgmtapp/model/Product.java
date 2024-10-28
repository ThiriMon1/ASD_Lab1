package edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model;

import java.time.LocalDate;

public class Product {
    private long productId;
    private String name;
    private LocalDate date;
    private int quantityInStock;
    private double unitPrice;

    public Product() {
    }

    public Product(String name, LocalDate date, int quantityInStock, double unitPrice) {
        this.name = name;
        this.date = date;
        this.quantityInStock = quantityInStock;
        this.unitPrice = unitPrice;
    }

    public Product(long productId, String name, LocalDate date, int quantityInStock, double unitPrice) {
        this.productId = productId;
        this.name = name;
        this.date = date;
        this.quantityInStock = quantityInStock;
        this.unitPrice = unitPrice;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
