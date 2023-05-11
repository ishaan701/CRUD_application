package com.luv2code.springboot.demo.mycoolapp.REST;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface EmployeeRepository extends JpaRepository <Employee , Long> {

////        Optional <List<Employee>> findEmployeeByEmp_city(String emp_city);
//
////    Employee findByemp_city(String emp_city);
////    Optional<List<Employee>> findByemp_ageGreaterThan(int emp_age);
//
//
//    List<Employee> findByEmpCity(String city);

    @Query("select  e from Employee e")
    List<Employee> findAll();
    @Query("SELECT e FROM Employee e WHERE e.emp_city = :city")
    List<Employee> findByCity(@Param("city") String city);

    @Query ("select  e from Employee e where e.emp_age > :age ")
    List<Employee> findByAge(@Param("age")int age);

    @Query("select  e from Employee  e where e.empid = :id")
    Optional <Employee> findById(@Param("id") int id);

}
