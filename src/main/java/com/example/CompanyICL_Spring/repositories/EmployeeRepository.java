package com.example.CompanyICL_Spring.repositories;

import com.example.CompanyICL_Spring.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//Классический репозиторий Spring Data JPA
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    //Формирование запроса на поиск суммы выручки(revenue) в таблице Employee
    @Query(value =  "SELECT sum(e.revenue) FROM Employee e ")
    float findCompanyRevenue();

    //Формирование запроса на поиск 30 самых высоких зарплат
    List<Employee> findTop30ByOrderByIncomeDesc();
    //Формирование запроса на поиск 30 самых низких зарплат
    List<Employee> findTop30ByOrderByIncomeAsc();
}
