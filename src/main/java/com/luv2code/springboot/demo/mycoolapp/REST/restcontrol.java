package com.luv2code.springboot.demo.mycoolapp.REST;
//package com.luv2code.springboot.demo.mycoolapp.REST.EmployeeRepository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")


/*
In Spring Boot, the "Optional" keyword is a container object that may or may not contain a non-null value.
It is used to handle null values returned from a method or operation, without having to
explicitly check for null values using conditional statements.
*/

/*
    ResponseEntity<Employee> it is used when we have to retrive single employee record from table
 */

/*
    ResponseEntity<List<Employee>> it is used when we have to retrive multiple rows from a database
 */


public class restcontrol {

    @Autowired // we do not have to craete the object , spring itself will do it

    // instance of employee repository class
    EmployeeRepository employeeRepository;

    // use to create new entry in table
    @PostMapping("/employees")

     public String create(@RequestBody  Employee employee) {
        employeeRepository.save(employee);
        System.out.println(employee);
        return "Employee entry stored in database";
    }

    // use to get all the entries in table
    @GetMapping("/employees")
    public ResponseEntity <List<Employee>> getAllEmployees(){
        List <Employee> emp = new ArrayList<>();
        employeeRepository.findAll().forEach(emp::add);
        return new ResponseEntity<List<Employee>>(emp, HttpStatus.OK);
    }


    /* use to get entry of all the employees with the given city ="City"
        its api request would be like : http://localhost:8080/api/employees/emp_city?city=<city-name>
    */

    @GetMapping("/employees/emp_city")
    public List<Employee> getEmployeesByCity(@RequestParam String city) {
        return employeeRepository.findByCity(city);
    }

        /* use to get entry of all the employees whose age is greater than the given age
              its api request would be like : http://localhost:8080/api/employees/emp_age?emp_age=<age>
        */

    @GetMapping("employees/emp_age")
    public List<Employee> getEmployees_age(@RequestParam int emp_age) {
        return employeeRepository.findByAge(emp_age);
    }

    // use to get entry of row which have this.empid = empid

    @GetMapping("/employees/{empid}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long empid){
        Optional <Employee> emp = employeeRepository.findById(empid);
        if(emp.isPresent()){
            return new ResponseEntity<Employee>(emp.get(),HttpStatus.FOUND);
        }else{
//            System.out.println("Could not find the required details");
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
    }

    /*
        use to update entry of row having this.empid = empid
    */

    @PutMapping("/employees/{empid}")
    public String updateEmployeeById(@PathVariable long empid,@RequestBody Employee employee){
        Optional <Employee> emp = employeeRepository.findById(empid);
        if(emp.isPresent()){
            Employee existEmp = emp.get();
            existEmp.setEmp_age(employee.getEmp_age());
            existEmp.setEmp_city(employee.getEmp_city());
            existEmp.setEmp_name(employee.getEmp_name());
            existEmp.setEmp_salary(employee.getEmp_salary());
            employeeRepository.save(existEmp);
            return "Employee details against Id "+ empid + "updated";
        }else{
            return "Employee details does not exist for "+ empid;
        }
    }

        /*
            use to delete the entry corresponding to empid
        */

    @DeleteMapping("/employees/{empid}")
    public String deleteemploybyid(@PathVariable long empid){
        employeeRepository.deleteById(empid);
        return "Employee with Id "+empid + "deleted succesfully";
    }

    // use to delete all the entry present in the table

     @DeleteMapping("/employees")
    public String deleteAllEmployee(){
        employeeRepository.deleteAll();
        return "All employee has been deleted successfully";
     }

}
