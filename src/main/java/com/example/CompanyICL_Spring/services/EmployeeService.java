package com.example.CompanyICL_Spring.services;

import com.example.CompanyICL_Spring.DTO.IndexOutOfBoundException;
import com.example.CompanyICL_Spring.ENUM.Position;
import com.example.CompanyICL_Spring.models.Employee;
import com.example.CompanyICL_Spring.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Формирование сервисного слоя приложения
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //Метод добавляющий сотрудника в таблицу
    public void hire(Position position) {
        Employee employee;
        switch (position) {
            case Operator:
                employee = new Employee(position, 15000, 0);
                break;
            case Manager:
                employee = new Employee(position, 50000, 0);
                break;
            case TopManager:
                employee = new Employee(position, 70000, 0);
                break;
            default:
                throw new IndexOutOfBoundException("Unreal hire Employee with this position");
        }
        employeeRepository.save(employee);
    }

    //Метод добавляющий список сотрудников в таблицу
    public void hireAll(List<Employee> employee) {

        employeeRepository.saveAll(employee);
    }

    //Метод удаляющий сотрудника из таблицы по id
    public void fire(int id) {
        if(employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        }
        else {
            throw new IndexOutOfBoundException("Employee with id " + id + " not found");
        }
    }

    //Метод получения выручки компании
    public float getCompanyRevenue() {
       return employeeRepository.findCompanyRevenue();
    }

    //Метод получения списка из 30 сотрудников с самой высокой зарплатой
    public List<Employee> getTopHighMonthSalary() {
        return employeeRepository.findTop30ByOrderByIncomeDesc();
    }

    //Метод получения списка из 30 сотрудников с самой низкой зарплатой
    public List<Employee> getTopLessMonthSalary() {
        return employeeRepository.findTop30ByOrderByIncomeAsc();
    }
}
