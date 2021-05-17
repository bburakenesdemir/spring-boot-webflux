package com.burakenesdemir.reactiveprogramming.data.repository;

import com.burakenesdemir.reactiveprogramming.data.entity.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee,String> {
}
