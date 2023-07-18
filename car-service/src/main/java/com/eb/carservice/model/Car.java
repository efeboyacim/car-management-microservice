package com.eb.carservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="car")
@ToString
public class Car {

    public Car(){

    }

    public Car(int id, String brandName, String color, String model, int year, String sold) {
        this.id = id;
        this.brandName = brandName;
        this.color = color;
        this.model = model;
        this.year = year;
        this.sold = sold;
    }

    public Car(String brandName, String color, String model, int year, String sold) {
        this.brandName = brandName;
        this.color = color;
        this.model = model;
        this.year = year;
        this.sold = sold;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name ="brandName")
    private String brandName;

    @Column(name="color")
    private String color;

    @Column(name="model")
    private String model;

    @Column(name="year")
    private int year;

    @Column(name="sold")
    private String sold;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSold() {
        return sold;
    }

    public void setSold(String sold) {
        this.sold = sold;
    }
}
