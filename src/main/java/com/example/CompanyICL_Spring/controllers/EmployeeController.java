package com.example.CompanyICL_Spring.controllers;

import com.example.CompanyICL_Spring.DTO.ResourceNotFoundException;
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
    public void newPerson(@RequestParam("position") String position) {
        switch (position) {
            case "operator":
                employeeService.hire(new Employee("Operator", 15000, 0));
                break;
            case "manager":
                employeeService.hire(new Employee("Manager", 50000, 0));
                break;
            case "top_manager":
                employeeService.hire(new Employee("TopManager", 70000,0));
                break;
            default:
                throw new ResourceNotFoundException("Unreal hire Employee with position" + position);
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

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping ("/fire")
    public void fireEmployee(@RequestParam("id") int id) {
        employeeService.fire(id);
    }
}
