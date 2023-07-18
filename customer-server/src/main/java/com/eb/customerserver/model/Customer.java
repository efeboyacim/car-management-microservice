package com.eb.customerserver.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="customer")
@Data
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;

    private String fullName;

    private int age;

    private String buyCarBefore;


    public Customer(String fullName, int age, String buyCarBefore) {
        this.fullName = fullName;
        this.age = age;
        this.buyCarBefore = buyCarBefore;
    }
}
