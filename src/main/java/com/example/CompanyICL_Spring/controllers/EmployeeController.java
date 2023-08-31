package com.example.CompanyICL_Spring.controllers;

import com.example.CompanyICL_Spring.DTO.IndexOutOfBoundException;
import com.example.CompanyICL_Spring.ENUM.Position;
import com.example.CompanyICL_Spring.models.Employee;
import com.example.CompanyICL_Spring.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//Формирование контроллера
@RestController
@RequestMapping("/company")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    //Маппа, добавляющая нового сотрудника в таблицу по его должности, реализация метода hire
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/new_person")
    public void newPerson(@RequestParam("position") int position) {
        if(position < 0 || position > 2){
            throw new IndexOutOfBoundException("Unreal hire Employee with position " + position);
        }
        else {
            employeeService.hire(Position.values()[position]);
        }
    }

    @GetMapping("/income")
    public float getCompanyIncome(){
        return employeeService.getCompanyRevenue();
    }

    @GetMapping("/topLessMonthSalary")
    public List<Employee> topLessMonthSalary(){
       return employeeService.getTopLessMonthSalary();
    }

    @GetMapping("/topHighMonthSalary")
    public List<Employee> topHighMonthSalary(){
        return employeeService.getTopHighMonthSalary();
    }

    @DeleteMapping ("/fire")
    public void fireEmployee(@RequestParam("id") int id) {
        employeeService.fire(id);
    }
}
