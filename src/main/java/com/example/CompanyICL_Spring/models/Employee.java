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

    public Employee(Position position) {
        switch (position){
            case Operator:
                this.position = position.Operator.name();
                this.income = 15000;
                this.revenue = 0;
                break;
            case Manager:
                this.position = position.Manager.name();
                this.income = 50000;
                this.revenue = 0;
                break;
            case TopManager:
                this.position = position.TopManager.name();
                this.income = 70000;
                this.revenue = 0;
                break;
        }
    }
}
