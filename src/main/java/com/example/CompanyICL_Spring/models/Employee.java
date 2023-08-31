package com.example.CompanyICL_Spring.models;

import com.example.CompanyICL_Spring.ENUM.Position;
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

    public Employee(Position position, float income, float revenue) {
        this.position = position.name();
        this.income = income;
        this.revenue = revenue;
    }
}
