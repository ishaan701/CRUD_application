package com.luv2code.springboot.demo.mycoolapp;
//package com.luv2code.springboot.demo.mycoolapp.REST.EmployeeRepository
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot:spring-boot:3.0.6
//import spring.jpa.open-in-view

@SpringBootApplication
public class MycoolappApplication {

	public static void main(String[] args) {

		SpringApplication.run(MycoolappApplication.class, args);

	}

	//curl -iXPOST http://localhost:8080/api/employees -H "Content-Type: application/json" --data-raw '{"emp_name": "Ishaan", "emp_salary": 100000, "emp_age": 21, "emp_city": "Patna"}'

}
`