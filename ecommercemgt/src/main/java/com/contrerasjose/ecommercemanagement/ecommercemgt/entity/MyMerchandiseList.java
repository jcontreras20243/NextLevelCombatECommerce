package com.contrerasjose.ecommercemanagement.ecommercemgt.entity;

import jakarta.persistence.*;


@Entity
@Table(name="MyMerchandise")
public class MyMerchandiseList {

    @Id
    private int id;
    private String name;
    private String brand;
    private String category;
    private double price;
    private int quantity;
    private String size;
    private String imageName;

    public MyMerchandiseList() {
        super();
        // TODO Auto-generated constructor stub

    }

    public MyMerchandiseList(int id, String name, String brand, String category, double price, int quantity, String size, String imageName) {
        super();
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.size = size;
        this.imageName = imageName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}