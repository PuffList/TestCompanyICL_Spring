package com.example.CompanyICL_Spring.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


//Описание модели-сущности Employee с присущими ей полями(столбцами)
@Data
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "position")
    private String position;

    @Column(name = "income")
    private float income;

    @Column(name = "revenue")
    private float revenue;

    public Employee(String position, float income, float revenue) {
        this.position = position;
        this.income = income;
        this.revenue = revenue;
    }
}
