package com.bhochhi.spring.reactwithspring.payroll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final EmployeeRepository respository;

    @Autowired
    public DatabaseLoader(EmployeeRepository respository) {
        this.respository = respository;
    }


    @Override
    public void run(String... args) throws Exception {
        this.respository.save(new Employee("ee", "bhochhi", "my man!!"));
    }
}
