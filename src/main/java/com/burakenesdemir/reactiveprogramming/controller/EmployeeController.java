package com.burakenesdemir.reactiveprogramming.controller;

import com.burakenesdemir.reactiveprogramming.data.entity.Employee;
import com.burakenesdemir.reactiveprogramming.data.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    /**
     *
     * @param id Mono tek bir kaydın gösteriminde kullanılıyor.
     *           Flux ise birden fazla kaydın gösteriminde kullanılıyor.
     * @return
     */
    @GetMapping("/id/{id}")
    public Mono<Employee> getById(@PathVariable String id){
        return employeeRepository.findById(id);
    }

    @GetMapping
    public Flux<Employee> getAll(){
        return employeeRepository.findAll();
    }

    @PostMapping("/create-employee")
    public void create(@RequestParam Employee employee){
        employeeRepository.save(employee);
    }
}
